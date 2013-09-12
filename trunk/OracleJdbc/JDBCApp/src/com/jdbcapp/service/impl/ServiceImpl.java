/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdbcapp.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.jdbcapp.service.Service;

/**
 * 
 * @author Sudarsan
 */
public class ServiceImpl implements Service {

	private static String DRIVER = null;
	private static String USERNAME = null;
	private static String PASSWORD = null;
	private static String URL = null;

	private Connection connection = null;
	
	static {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File("jdbcapp.properties"));
			Properties properties = new Properties();
			try {
				properties.load(inputStream);

				String vendor = properties.getProperty("db.vendor");

				switch (Integer.parseInt(vendor)) {

				case 1:
					ServiceImpl.DRIVER = properties
							.getProperty("db.oracle.driver");
					ServiceImpl.USERNAME = properties
							.getProperty("db.oracle.username");
					ServiceImpl.PASSWORD = properties
							.getProperty("db.oracle.password");
					ServiceImpl.URL = properties.getProperty("db.oracle.url");
					break;

				case 2:
					ServiceImpl.DRIVER = properties.getProperty("db.mysql.driver");
					ServiceImpl.USERNAME = properties
							.getProperty("db.mysql.username");
					ServiceImpl.PASSWORD = properties
							.getProperty("db.mysql.password");
					ServiceImpl.URL = properties.getProperty("db.mysql.url");
					break;

				case 3:
					ServiceImpl.DRIVER = properties.getProperty("db.derby.driver");
					ServiceImpl.USERNAME = properties
							.getProperty("db.derby.username");
					ServiceImpl.PASSWORD = properties
							.getProperty("db.derby.password");
					ServiceImpl.URL = properties.getProperty("db.derby.url");
					break;

				default:
					break;
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Connection getConnection() throws ClassNotFoundException,
			SQLException {

		Class.forName(DRIVER);
		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return connection;
	}

}
