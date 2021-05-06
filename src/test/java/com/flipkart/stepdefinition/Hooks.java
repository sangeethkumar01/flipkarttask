package com.flipkart.stepdefinition;



import com.flipkart.resources.CommonActions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks  extends CommonActions {

	@Before
	public void berforScenario(){
		launch("https://www.flipkart.com/");
	}
	
	@After
	public void afterscenario(){
		driver.quit();
	}
}