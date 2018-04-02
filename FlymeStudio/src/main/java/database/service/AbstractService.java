package database.service;

import javax.sql.DataSource;

public abstract class AbstractService {
	abstract void setDataSource(DataSource dataSource);
}
