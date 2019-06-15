package edu.dkravchuk.studentorder.dao;

import java.util.List;

import edu.dkravchuk.studentorder.domain.Street;
import edu.dkravchuk.studentorder.exception.DaoException;

public interface DictionaryDao {
	public List<Street> findStreets(String pattern) throws DaoException;

}
