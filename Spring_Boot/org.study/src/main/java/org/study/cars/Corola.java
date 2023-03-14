package org.study.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.study.intefaces.Car;

@Component("mycorola")
public class Corola implements Car {
	@Autowired
	Engine engine;
	
//	@Autowired
//	public void setEngine(Engine engine) {
//		engine.type = "V12";
//		this.engine = engine;
//	}
	
	public Corola(Engine engine) {
		super();
		engine.type = "V12";
		this.engine = engine;
	}

	public String getCar() {
		String car = "Sedan from Toyota Engine type = "+engine.type;
		return car;
	}
}
