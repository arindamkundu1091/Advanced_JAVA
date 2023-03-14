package org.study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.study.intefaces.Car;
//import org.study.cars.Corola;
//import org.study.cars.Swift;

public class App {

	public static void main(String[] args) {
//		Car swift=new Swift();
//		Car corola=new Corola();
//		System.out.println(swift.getCar());
//		System.out.println(corola.getCar());
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Car mycar = context.getBean("mycorola",Car.class);
		System.out.print(mycar.getCar());
		context.close();
	}
}
