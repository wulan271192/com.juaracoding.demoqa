package com.juaracoding.demoqa.forms;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.juaracoding.demoqa.driver.DriverSingleton;

public class Form {
	
private WebDriver driver;
	
	public Form() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(2) > span > div > div.header-text")
	private WebElement btnForm;
	
	@FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(2) > div > div.card-body")
	private WebElement btnForm2;
	
	
	
	
	
	@FindBy(css = "#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(2) > div")
	private WebElement subMenuForm;
	
	@FindBy(css = "#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(2) > div")
	private WebElement subMenuForm2;
	
	@FindBy(id = "firstName")
	private WebElement TextBoxFirstName;
	
	@FindBy(id = "lastName")
	private WebElement TextBoxLastName;
	
	@FindBy(id = "userEmail")
	private WebElement TextBoxEmail;

	@FindBy(css = "#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1)")
	WebElement genderMale;
	
	@FindBy(css = "#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(2)")
	WebElement genderFemale;
	
	@FindBy(css = "#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(3)")
	WebElement genderOther;
	
	@FindBy(id = "userNumber")
	private WebElement TextBoxNumber;
	
	@FindBy(id = "dateOfBirthInput")
	WebElement TextBoxBirthDay;
	
	@FindBy(id = "subjectsInput")
	private WebElement TextBoxSubject;
		
	@FindBy(css = "#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label")
	private WebElement btnRadioButtonHobby;
	
	@FindBy(css = "#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(3) > label")
	private WebElement btnRadioButtonHobby2;
	
	@FindBy(id = "currentAddress")
	private WebElement TextBoxAddress;
	
	@FindBy(id = "uploadPicture")
	private WebElement BtnUploadPicture;
	
	@FindBy(id = "state")
	private WebElement btnState;
		
	@FindBy(id = "city")
	private WebElement btnCity;
		
	@FindBy(id = "submit")
	private WebElement btnSubmit;
		
	public void TextBoxForm(String number, String lastname, String email) {	
		TextBoxFirstName.sendKeys(number);
		TextBoxLastName.sendKeys(lastname);
		TextBoxEmail.sendKeys(email);	
	}
	
	public void TextBoxForm2(String number) {	
		TextBoxNumber.sendKeys(number);
	}

	public void RadioButton2() {	
		btnRadioButtonHobby.click();
		btnRadioButtonHobby2.click();
	}
	
	public void TextBoxForm3(String address) {	
		TextBoxAddress.sendKeys(address);	
	}
	
	public void lstCity (int selection) {
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("window.scrollBy(0,1000)");
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(btnState));
		
		btnState.click();
		
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
			
		}
	
	public void StateKedua (int selection) {	
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(btnCity));
		
		btnCity.click();
		
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
			
		}
	
	public void setTextBOD(String bod) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(TextBoxBirthDay));
		TextBoxBirthDay.clear();
		TextBoxBirthDay.sendKeys(Keys.chord(Keys.CONTROL +"a" , bod));
		
		TextBoxBirthDay.sendKeys(bod);
		TextBoxBirthDay.sendKeys(Keys.ENTER);
	}

	
	public void setTextSubject(List<String> lstSubject) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(TextBoxSubject));
		TextBoxSubject.click();
		for (String subject : lstSubject) {
		
		TextBoxSubject.sendKeys(subject);
		
		TextBoxSubject.sendKeys(Keys.ENTER);
		}
	}
	
	public void setGender(int selection) {
    	
		switch(selection) {
		case 1 :
			genderMale.click();
			break;
		case 2 :
			genderFemale.click();
			break;
		case 3 :
			genderOther.click();
			break;
		}
    }
	
	public void uploadFoto() {
		BtnUploadPicture.sendKeys("D:/wulantesting.jpeg");
	}
	
	public void menuForm2() {
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("arguments[0].scrollIntoView()", btnForm2);
		btnForm2.click();		
	}
	
	public void submenuForm2() {	
		subMenuForm2.click();		
	}
	
	public void submit() {	
		btnSubmit.click();		
	}

}