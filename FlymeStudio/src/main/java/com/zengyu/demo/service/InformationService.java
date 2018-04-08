package com.zengyu.demo.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.zengyu.demo.dao.InformationDao;
import com.zengyu.demo.model.UserMapper;
import com.zengyu.demo.model.UserVO;
import com.zengyu.demo.others.Const;

@Service
public class InformationService extends AbstractService implements InformationDao {

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean modify(String oldTel, String name, String tel, String email, String password) {
		boolean result = false;
		try {
			// 查询新电话号码是否已注册
			String SQL1 = "select * from " + Const.User.TABLE_NAME + " where " + Const.User.COLUMN_TEL + " = ?";

			List<UserVO> userVOs = jdbcTemplate.query(SQL1, new UserMapper(), tel);
			if (userVOs == null || userVOs.size() == 0) {
				// 更新用户信息
				String SQL2 = "update " + Const.User.TABLE_NAME + " set " + Const.User.COLUMN_TEL + " = ?, "
						+ Const.User.COLUMN_NAME + " = ?, " + Const.User.COLUMN_EMAIL + " = ?, "
						+ Const.User.COLUMN_PASSWORD + " = ? where " + Const.User.COLUMN_TEL + " = ?";

				int count = jdbcTemplate.update(SQL2, name, tel, email, password, oldTel);
				if (count > 0) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
