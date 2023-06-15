package model.dao;

import java.util.List;

import model.entities.WeightLog;

public interface WeightLogDao {

	void insert(WeightLog obj);

	void update(WeightLog obj);

	void deleteById(Integer id);

	WeightLog findById(Integer id);

	List<WeightLog> findAll();

}
