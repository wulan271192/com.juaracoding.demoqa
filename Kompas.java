package com.juaracoding.demoqa.kompas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.demoqa.driver.DriverSingleton;

public class Kompas {
	
	private WebDriver driver;
	
	public Kompas() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy (xpath = "//div[@class='td-module-thumb']//a[@title='Inilah Medali Olimpiade Tokyo 2020 yang Terbuat Dari Limbah Elektronik']")
	private WebElement btnHeadLine;

	
	@FindBy (css ="#post-122539 > div:nth-child(2) > div.td-pb-span8.td-main-content > div > div.td-post-content.tagdiv-type > p:nth-child(2)")
	private WebElement textContentBerita;
	
	public void menuTekno() {
		
		btnHeadLine.click();
		
		
		
		

		
	}
	public String contentBerita() {
		// TODO Auto-generated method stub
		return textContentBerita.getText();
	}
}
