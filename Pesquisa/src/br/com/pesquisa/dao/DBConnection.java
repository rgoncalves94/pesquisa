package br.com.pesquisa.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String JDBC_USER = "system";
	private static String JDBC_PASSWORD = "forbidden";
	private static Driver driver = null;

	public static synchronized Connection getConnection() throws SQLException {
		if (driver == null) {
			try {
				Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
			} catch (Exception e) {
				System.out.println("Failed to initialise JDBC driver");
				e.printStackTrace();
			}
		}
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}

	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
