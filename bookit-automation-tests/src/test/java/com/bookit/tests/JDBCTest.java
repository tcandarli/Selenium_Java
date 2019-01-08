package com.bookit.tests;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class JDBCTest {

	String dbUrl = "jdbc:postgresql://localhost:5432/hr";
	String dbUsername = "postgres";
	String dbPassword = "abc";

	@Test(enabled = false)
	public void PostGreSQL() throws SQLException {

		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet resultset = statement.executeQuery("Select * from countries");

		// next method -> move pointer to next row

		while (resultset.next()) {
			System.out.println(
					resultset.getString(1) + " - " + resultset.getString("country_name" + " - " + resultset.getInt(3)));
		}

		resultset.next();
		System.out.println(
				resultset.getString(1) + " - " + resultset.getString("country_name" + " - " + resultset.getInt(3)));

		resultset.next();
		System.out.println(resultset.getString(1) + " - " + resultset.getString("country_name" + " - " + resultset.getInt(3)));

		resultset.next();
		resultset.next();
		resultset.next();

		// System.out.println(resultset.getRow()); // Retrieves the current row number

		resultset.first();
		// System.out.println(resultset.getRow());

		// find out how many record in the resultset?
		resultset.last();
		int rowCount = resultset.getRow();

		System.out.println("Total number of rows: " + rowCount);

		// how to move first row and loop everything again after you area at last row?
		resultset.beforeFirst();
		while (resultset.next()) {
			System.out.println(
					resultset.getString(1) + " - " + resultset.getString("country_name" + " - " + resultset.getInt(3)));

		}

		resultset.close();
		statement.close();
		connection.close();

	}
	
	@Test
	public void JDBCMetaData() throws SQLException {
		
		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet resultset = statement.executeQuery("Select * from employees");
		
		// database metadata (create object)
		DatabaseMetaData dbMetaData = connection.getMetaData();
		
		// which username are we using?
		System.out.println("User: " + dbMetaData.getUserName());
		
		// database product name
		System.out.println("Database product name: " + dbMetaData.getDatabaseProductName());
		
		// database product version
		System.out.println("Database product version: " + dbMetaData.getDatabaseProductVersion());
		
		// -------------------------------------
		
		// resultset metata create object
		ResultSetMetaData rsMetaData = resultset.getMetaData();
		
		// how many columns we have?
		System.out.println("Columns count: " + rsMetaData.getColumnCount());
		
		// get column name
		System.out.println("First column name: " + rsMetaData.getColumnName(1));
		
		// get table name
		System.out.println("Table name: " + rsMetaData.getTableName(1));
		
		// print all column names using loop
		
		int columnCount = rsMetaData.getColumnCount();

		for (int i = 1; i <= columnCount; i++) {
			System.out.println(rsMetaData.getColumnName(i));
		}

		
		resultset.close();
		statement.close();
		connection.close();
	}
}
