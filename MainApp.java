package com.juaracoding.demoqa.main;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.juaracoding.demoqa.driver.DriverSingleton;
import com.juaracoding.demoqa.forms.Form;

public class MainApp {
	
	public static void main(String[] args) {
		WebDriver driver = DriverSingleton.getInstance().getDriver();
		
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();		
        Form form = new Form();
        
		form.menuForm2();
		form.submenuForm2();
		
		form.TextBoxForm("Wulan","Nurfadilah Sulistiani","adhillahwullan@gmail.com");
		
		form.setGender(1);	
		
		form.TextBoxForm2("082210209680");
		
		form.setTextBOD("27 Nov 1992");
		
		List<String> listString = new ArrayList<String>();
		listString.add("English");
		listString.add("Chemistry");
		form.setTextSubject(listString);
		
		form.RadioButton2();
		
		form.TextBoxForm3("Tangerang Banten");
		
		form.uploadFoto();
		
		form.lstCity(2);
		form.StateKedua(2);

		form.submit();
	}

}