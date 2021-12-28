package com.juaracoding.demoqa.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import com.juaracoding.demoqa.driver.DriverStrategy;
import com.juaracoding.demoqa.driver.DriverStrategyImplementor;

public class DriverSingleton {
	private static DriverSingleton instance = null;
	private static WebDriver driver;
	
	public DriverSingleton(){
	intantiate("chrome");
	}
	public WebDriver intantiate (String strategy) {
		DriverStrategy driverStrategy = DriverStrategyImplementor.chooseStrategy(strategy);
		driver = driverStrategy.setStrategy();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
		
		
	}
	public static DriverSingleton getInstance() {
		if(instance==null) {
			instance = new DriverSingleton();
			
		}
		return instance;
	}
	public static void closeObjectInstance() {
		
	}
	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

}

