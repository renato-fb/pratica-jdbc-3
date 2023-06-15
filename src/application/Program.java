package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.WeightLogDao;
import model.entities.WeightLog;

public class Program {

	public static void main(String[] args) {
		
		WeightLogDao log = DaoFactory.newWeightLog();
		
		System.out.println("==== TEST Nº1: weightLog insert ====");
		WeightLog wl = new WeightLog(null, new Date(), 77.2);
		log.insert(wl);
		
//		System.out.println();
//		System.out.println("==== TEST Nº2: weightlog update ====");
//		WeightLog wl1 = new WeightLog(3, new Date(), 99.9);
//		log.update(wl1);

//		System.out.println();
//		System.out.println("==== TEST Nº3: weightlog delete ====");
//		log.deleteById(1);
		
//		System.out.println();
//		System.out.println("==== TEST Nº4: weightlog findById ====");
//		WeightLog wl3 = log.findById(2);
//		System.out.println(wl3);
		
		System.out.println();
		System.out.println("==== TEST Nº5: weightlog findAll ====");
		List<WeightLog> list = log.findAll();
		list.forEach(System.out::println);
		
		
		
	}

}
