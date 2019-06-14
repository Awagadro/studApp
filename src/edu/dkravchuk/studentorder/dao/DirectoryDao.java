package edu.dkravchuk.studentorder.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import edu.dkravchuk.studentorder.domain.Street;

public class DirectoryDao {

	private Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jc_student", "postgres", "1");
		return con;

	}

	public List<Street> findStreets(String pattern) throws Exception {
		List<Street> result = new LinkedList<Street>();

		Connection con = getConnection();
		Statement stmt = con.createStatement();
		String sql = "SELECT street_code FROM js_street WHERE UPPER (street_name) LIKE UPPER ('%" + pattern + "%')";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Street str = new Street(rs.getLong("street_code"), rs.getString("street_name"));
			result.add(str);
		}
		return result;
	}
	
}
