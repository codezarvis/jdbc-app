package com.jdbcapp.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File("jdbcapp.properties"));
			Properties properties = new Properties();
			try {
				properties.load(inputStream);
				String driverName = properties.getProperty("oracle.driver");
				String userName = properties.getProperty("oracle.username");
				String password = properties.getProperty("oracle.password");
				String url = properties.getProperty("oracle.url");

				Class.forName(driverName);

				Connection connection = DriverManager.getConnection(url,
						userName, password);

				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM EMPLOYEES");
				while (resultSet.next()) {
					System.out.println(resultSet.getString(2));
				}

			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
