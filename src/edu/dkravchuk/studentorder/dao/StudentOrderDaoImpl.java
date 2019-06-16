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
// Husband	
			Adult husband = so.getHusband();
			stmt.setString(3, husband.getSurName());
			stmt.setString(4, husband.getGivenName());
			stmt.setString(5, husband.getPatronymic());
			stmt.setDate(6, java.sql.Date.valueOf(husband.getDateOfBirth()));
			stmt.setString(7, husband.getPassportSeria());
			stmt.setString(8, husband.getPassportNumber());
			stmt.setDate(9, java.sql.Date.valueOf(husband.getIssueDate()));
			stmt.setLong(10, husband.getPassportOffice().getOfficeId());
			stmt.setString(11, husband.getAddress().getPostCode());
			stmt.setInt(12, husband.getAddress().getStreet().getStreetCode().intValue());
			stmt.setString(13, husband.getAddress().getBuildung());
			stmt.setString(14, husband.getAddress().getExtension());
			stmt.setString(15, husband.getAddress().getApartment());
// Wife			
			Adult wife = so.getWife();
			stmt.setString(16, wife.getSurName());
			stmt.setString(17, wife.getGivenName());
			stmt.setString(18, wife.getPatronymic());
			stmt.setDate(19, java.sql.Date.valueOf(wife.getDateOfBirth()));
			stmt.setString(20, wife.getPassportSeria());
			stmt.setString(21, wife.getPassportNumber());
			stmt.setDate(22, java.sql.Date.valueOf(wife.getIssueDate()));
			stmt.setLong(23, wife.getPassportOffice().getOfficeId());
			stmt.setString(24, wife.getAddress().getPostCode());
			stmt.setLong(25, wife.getAddress().getStreet().getStreetCode());
			stmt.setString(26, wife.getAddress().getBuildung());
			stmt.setString(27, wife.getAddress().getExtension());
			stmt.setString(28, wife.getAddress().getApartment());

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

}
