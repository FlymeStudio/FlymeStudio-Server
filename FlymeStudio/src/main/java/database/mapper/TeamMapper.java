package database.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSONArray;

import bean.MemberBean;
import bean.TeamBean;

public class TeamMapper implements RowMapper<TeamBean> {

	public TeamBean mapRow(ResultSet arg0, int arg1) throws SQLException {
		TeamBean bean = new TeamBean();
		bean.setId(arg0.getInt("id"));
		bean.setName(arg0.getString("name"));
		bean.setTel(arg0.getInt("tel"));
		JSONArray array = JSONArray.parseArray(arg0.getString("members"));
		bean.setMembers(array.toJavaList(MemberBean.class));
		return bean;
	}
}
