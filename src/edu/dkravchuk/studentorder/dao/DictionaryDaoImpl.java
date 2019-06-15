package edu.dkravchuk.studentorder.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import edu.dkravchuk.studentorder.config.Config;
import edu.dkravchuk.studentorder.domain.Street;
import edu.dkravchuk.studentorder.exception.DaoException;

public class DictionaryDaoImpl implements DictionaryDao {

	private static final String GET_STREET = "SELECT street_code FROM jc_street WHERE UPPER (street_name) LIKE UPPER (?)";

	private Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(
				Config.getProperty(Config.DB_URL),
				Config.getProperty(Config.DB_LOGIN), 
				Config.getProperty(Config.DB_PASSWORD));
		return con;

	}

	@Override
	public List<Street> findStreets(String pattern) throws DaoException {
		List<Street> result = new LinkedList<Street>();

		try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(GET_STREET)) {

			stmt.setString(1, "%" + pattern + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Street str = new Street(rs.getLong("street_code"), rs.getString("street_name"));
				result.add(str);
			}

		} catch (SQLException e) {
			throw new DaoException(e);
		}

		return result;
	}

}
