/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdbcapp.service;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * @author Sudarsan
 */
public interface Service {

	Connection getConnection() throws ClassNotFoundException, SQLException;
}
