package edu.dkravchuk.studentorder.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import edu.dkravchuk.studentorder.config.Config;
import edu.dkravchuk.studentorder.domain.Adult;
import edu.dkravchuk.studentorder.domain.StudentOrder;
import edu.dkravchuk.studentorder.domain.StudentOrderStatus;
import edu.dkravchuk.studentorder.exception.DaoException;

public class StudentOrderDaoImpl implements StudentOrderDao {

	private static final String INSERT_ODER = "INSERT INTO public.jc_student_order("
			+ " student_order_status, student_order_date, h_sur_name, h_given_name, h_patronymic, h_date_of_birth, h_passport_seria, h_passport_number, h_passport_date, h_passport_office_id, h_post_index, h_street_code, h_building, h_extension, h_apartment, w_sur_name, w_given_name, w_patronymic, w_date_of_birth, w_passport_seria, w_passport_number, w_passport_date, w_passport_office_id, w_post_index, w_street_code, w_building, w_extension, w_apartment, certificate_id, register_office_id, marriage_date)"
			+ "	VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(Config.getProperty(Config.DB_URL),
				Config.getProperty(Config.DB_LOGIN), Config.getProperty(Config.DB_PASSWORD));
		return con;

	}

	@Override
	public Long saveStudentOrder(StudentOrder so) throws DaoException {
		Long result = -1L;

		try (Connection con = getConnection();
				PreparedStatement stmt = con.prepareStatement(INSERT_ODER, new String[] { "student_order_id" })) {
			stmt.setInt(1, StudentOrderStatus.START.ordinal());
			stmt.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now()));
			// Husband - Wife
			setParamsForAdult(stmt, 3, so.getHusband());
			setParamsForAdult(stmt, 16, so.getWife());
			// Marriage
			stmt.setString(29, so.getMarriageCertificateId());
			stmt.setLong(30, so.getRegisterOffice().getOfficeId());
			stmt.setDate(31, java.sql.Date.valueOf(so.getMarriageDate()));

			stmt.executeUpdate();
			ResultSet gkRs = stmt.getGeneratedKeys();
			if (gkRs.next()) {
				result = gkRs.getLong(1);
			}

		} catch (SQLException e) {
			throw new DaoException(e);
		}
		return result;
	}

	private void setParamsForAdult(PreparedStatement stmt, int start, Adult adult) throws SQLException {
		stmt.setString(start, adult.getSurName());
		stmt.setString(start + 1, adult.getGivenName());
		stmt.setString(start + 2, adult.getPatronymic());
		stmt.setDate(start + 3, java.sql.Date.valueOf(adult.getDateOfBirth()));
		stmt.setString(start + 4, adult.getPassportSeria());
		stmt.setString(start + 5, adult.getPassportNumber());
		stmt.setDate(start + 6, java.sql.Date.valueOf(adult.getIssueDate()));
		stmt.setLong(start + 7, adult.getPassportOffice().getOfficeId());
		stmt.setString(start + 8, adult.getAddress().getPostCode());
		stmt.setInt(start + 9, adult.getAddress().getStreet().getStreetCode().intValue());
		stmt.setString(start + 10, adult.getAddress().getBuildung());
		stmt.setString(start + 11, adult.getAddress().getExtension());
		stmt.setString(start + 12, adult.getAddress().getApartment());
	}

}
