package com.juaracoding.demoqa.element;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.juaracoding.demoqa.driver.DriverSingleton;

public class Elements {
	
private WebDriver driver;
	
	public Elements( ) {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(1) > div > div.avatar.mx-auto.white")
	private WebElement btnElements;
	
	@FindBy(id = "item-0")
	private WebElement btnTextBox;
	
	@FindBy(id = "item-1")
	private WebElement btnCheckBox;
	
	@FindBy(id = "item-2")
	private WebElement btnRadioButton;
	
	@FindBy(css = "#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(2) > span > div")
	private WebElement btnPracticeForm;
	
	//Isi Form
	@FindBy(id = "userName")
	private WebElement textboxFullName;
	
	@FindBy(id = "userEmail")
	private WebElement textboxEmail;
	
	@FindBy(id = "currentAddress")
	private WebElement textboxCurrentAddress;
	
	@FindBy(id = "permanentAddress")
	private WebElement textboxPermanentAddress;
	
	@FindBy(id = "submit")
	private WebElement btnSubmit;
	
	//Check Box
	@FindBy(css = "#tree-node > div > button.rct-option.rct-option-expand-all")
	private WebElement btnExpandAll;
	
	@FindBy(css = "#tree-node > ol > li > ol > li:nth-child(1) > span > label > span.rct-checkbox")
	private WebElement checkboxDesktop;
	
	@FindBy(css = "#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(1) > ol > li:nth-child(1) > span > label > span.rct-checkbox")
	private WebElement checkboxReact;
	
	@FindBy(css = "#tree-node > ol > li > ol > li:nth-child(3) > span > label > span.rct-checkbox")
	private WebElement checkboxDownloads;
	
	//radio button
	@FindBy(css = "#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(1) > div:nth-child(3) > label")
	private WebElement btnImpressiveRadio;	
	
	public void menuElements() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(btnElements));
		btnElements.click();
	}
	
	public void menuTextBox() {
		btnTextBox.click();
	}
	
	public void formTextBox(String userName, String userEmail, String currentAddress, String permanentAddress) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		textboxFullName.sendKeys(userName);
		textboxEmail.sendKeys(userEmail);
		textboxCurrentAddress.sendKeys(currentAddress);
		textboxPermanentAddress.sendKeys(permanentAddress);
		//autoscroll ke element tertentu
		js.executeScript("arguments[0].scrollIntoView();", textboxPermanentAddress);
		btnSubmit.click();
	}
	
	public void menuCheckBox() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		btnCheckBox.click();
		btnExpandAll.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(checkboxDesktop));
		checkboxDesktop.click();
		//autoscroll ke element tertentu
		js.executeScript("arguments[0].scrollIntoView();", checkboxReact);
		checkboxDownloads.click();
	}
	
	public void menuRadioButton() {
		btnRadioButton.click();
		btnImpressiveRadio.click();
	}
	
	public void menuPracticeForm() {		
		btnPracticeForm.click();
	}
}
