package com.juaracoding.demoqa.driver;

public class DriverStrategyImplementor {
	
	public static DriverStrategy chooseStrategy(String strategy)
	{
		switch (strategy) {
		case "chrome":
			return new Chrome();
			
		case "firefox":
			return new Firefox();
			
			default:
				return null;
		}
	}

}
