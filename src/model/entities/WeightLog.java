package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class WeightLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date date;
	private Double weightInKg;
	
	public WeightLog() {
	}

	public WeightLog(Integer id, Date date, Double weightInKg) {
		this.id = id;
		this.date = date;
		this.weightInKg = weightInKg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getWeightInKg() {
		return weightInKg;
	}

	public void setWeightInKg(Double weightInKg) {
		this.weightInKg = weightInKg;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id, weightInKg);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeightLog other = (WeightLog) obj;
		return Objects.equals(date, other.date) && id == other.id && Objects.equals(weightInKg, other.weightInKg);
	}

	@Override
	public String toString() {
		return "WeightLog [id=" + id + ", date=" + date + ", weightInKg=" + weightInKg + "]";
	}

}
