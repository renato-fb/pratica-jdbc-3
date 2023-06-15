package model.dao;

import db.DB;
import model.dao.impl.WeightLogDaoJDBC;

public class DaoFactory {

	public static WeightLogDao newWeightLog() {
		return new WeightLogDaoJDBC(DB.getConnection());
	}
	
}
