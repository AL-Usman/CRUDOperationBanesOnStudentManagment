package com.usmanIndia;

import java.util.ArrayList;

public class MyApp {

	public static void main(String[] args) {
//		Student.creating();
//		Student.inserting("usman", "java", "usman@gmail.com");
//		Student.inserting("Ruman", "mysql", "ruman@gmail.com");
//		Student.inserting("rizwan", "java", "rizwan@gmail.com");
//		Student.inserting("sameer", ".net", "sameer@gmail.com");
//		Student.inserting("arbaz", "testing", "arbaz@gmail.com");
//		Student.inserting("sadiq", "C++", "sadiq@gmail.com");
//		Student.inserting("masood", "java", "masood@gmail.com");
//		Student.updating(6, "parveez", "marketing", "parveez@gmail.com");
//		Student.deleting(8);
//		Student.read();
		ArrayList<Std>a=Student.reading();
		for(Std i:a) {
			System.out.println(i.getSno()+" ");
			System.out.println(i.getSname()+" ");
			System.out.println(i.getSub()+" ");
			System.out.println(i.getEmail()+" ");
			System.out.println("----------------------------------");
		}
	}

}
