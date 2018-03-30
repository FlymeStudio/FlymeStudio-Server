package database.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSONArray;

import bean.PlanBean;
import bean.ProjectBean;

public class ProjectMapper implements RowMapper<ProjectBean> {

	public ProjectBean mapRow(ResultSet arg0, int arg1) throws SQLException {
		ProjectBean bean = new ProjectBean();
		bean.setId(arg0.getInt("id"));
		bean.setTel(arg0.getInt("tel"));
		bean.setPercent(0);
		bean.setType(arg0.getInt("type"));
		bean.setDate(arg0.getDate("date"));
		bean.setTitle(arg0.getString("title"));
		bean.setContent(arg0.getString("content"));
		JSONArray array = JSONArray.parseArray(arg0.getString("plans"));
		bean.setPlans(array.toJavaList(PlanBean.class));
		return null;
	}
}
