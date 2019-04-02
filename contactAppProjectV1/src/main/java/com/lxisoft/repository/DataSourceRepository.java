package com.lxisoft.repository;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DataSourceRepository {
	
				public static DataSource getMySQLDataSource() {
					ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
					InputStream input = classLoader.getResourceAsStream("DBCon.properties");
					Properties prop = new Properties();
					MysqlDataSource mysqlDataSource = null;
					try {
						prop.load(input);
						mysqlDataSource= new MysqlDataSource();
						mysqlDataSource.setURL(prop.getProperty("MYSQL_DB_URL"));
						mysqlDataSource.setUser(prop.getProperty("MYSQL_DB_USERNAME"));
						mysqlDataSource.setPassword(prop.getProperty("MYSQL_DB_PASSWORD"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					return mysqlDataSource;
				}
}
