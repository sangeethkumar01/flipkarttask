package com.flipkart.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.resources.CommonActions;

public class Searchmobile extends CommonActions {

	public Searchmobile(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='✕']")
	private WebElement popbtn;

	
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchbtn;


	@FindBy(xpath="//button[@type='submit']")
	private WebElement textbtn;

	@FindBy(xpath="//div[contains(text(),'GB')]/parent::div/div[1]")
	private WebElement textmob;
	
	@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
	private WebElement pricev;
	
	public WebElement getPricev() {
		return pricev;
	}

	public WebElement getTextmob() {
		return textmob;
	}

	public WebElement getPopbtn() {
		return popbtn;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}



	public WebElement getTextbtn() {
		return textbtn;
	}

	
}


