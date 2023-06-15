package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.WeightLogDao;
import model.entities.WeightLog;

public class WeightLogDaoJDBC implements WeightLogDao {

	private Connection conn;

	public WeightLogDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(WeightLog obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO weightlog (Date, WeightInKg) VALUES (?,?)");

			st.setDate(1, new java.sql.Date(obj.getDate().getTime()));
			st.setDouble(2, obj.getWeightInKg());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Successfully inserted data into DB!");
			} else {
				System.out.println("Data entry failed!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void update(WeightLog obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE weightlog SET WeightInKg = ? WHERE Id = ?");

			st.setDouble(1, obj.getWeightInKg());
			st.setInt(2, obj.getId());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Successfully updated data into DB!");
			} else {
				System.out.println("Data update failed!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM weightlog WHERE Id = ?");

			st.setInt(1, id);

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Successfully deleted data from DB!");
			} else {
				System.out.println("Data deletion failed!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public WeightLog findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM weightlog WHERE Id = ?");

			st.setInt(1, id);

			rs = st.executeQuery();

			if (rs.next()) {
				WeightLog wl = new WeightLog(rs.getInt("Id"), rs.getDate("Date"), rs.getDouble("WeightInKg"));
				System.out.println("Successfully retrieved data from weightlog database!");
				return wl;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public List<WeightLog> findAll() {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();

			rs = st.executeQuery("SELECT * FROM weightlog");

			List<WeightLog> list = new ArrayList<>();
			
			while (rs.next()) {
				WeightLog wl = new WeightLog(rs.getInt("Id"), rs.getDate("Date"), rs.getDouble("WeightInKg"));
				list.add(wl);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

}
