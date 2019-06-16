package edu.dkravchuk.studentorder.dao;

import edu.dkravchuk.studentorder.domain.StudentOrder;
import edu.dkravchuk.studentorder.exception.DaoException;

public interface StudentOrderDao {

	Long saveStudentOrder(StudentOrder so) throws DaoException;
}
