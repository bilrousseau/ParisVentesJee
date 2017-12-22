package com.parisventes.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	public static final String EMAIL_REGEXP = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

	private static final String HOST = "localhost";
	private static final String DBNAME = "parisventes";
	private static final Integer PORT = 3306;
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	public DB() {
	}

	private static void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String urlConnect() {
		return "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME;
	}
	
	private static Connection establishConnection() throws SQLException {
		return DriverManager.getConnection(urlConnect(), USERNAME, PASSWORD);
	}
	
	private static Statement getStatement() throws SQLException {
		loadDriver();
		return establishConnection().createStatement();
	}
	
	public static Integer executeInsert(String query) throws SQLException {
		return getStatement().executeUpdate(query);
	}
	
	public static ResultSet executeSelect(String query) throws SQLException {
		return getStatement().executeQuery(query);
	}
	
	public static String parseToSql(String str) {
		return "\"" + str + "\"";
	}
}
