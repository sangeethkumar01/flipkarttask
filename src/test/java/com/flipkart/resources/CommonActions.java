package com.flipkart.resources;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.xml.stream.events.Characters;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonActions {

	public static WebDriver driver;
	public void launch(String url){
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	public void insertTexts(WebElement element, String value){
		element.sendKeys(value);
	}
	
	public void buttons(WebElement element){
		
		element.click();
	}
	
	public void gettext(WebElement element){
		
		element.getText();
	}
	
	public void textmob(){
		WebElement data = driver.findElement(By.xpath("//div[contains(text(),'GB')]/parent::div/div[1]"));
		
	}
	public String removespecial(String str){
		String s= "";
		char[] po = str.toCharArray();
		for (char c : po) {
			if(Character.isDigit(c)){
				s=s+c;
				
			}
		}
		return s;
	}
	
	public void excelread(List<String> modellist,List<String> pricelist) throws IOException {
		
		
		FileInputStream readpri =new FileInputStream("C:\\Users\\sange\\workspace sangeeth\\projectflipkart\\Excel\\flipkart.xlsx");
	       XSSFWorkbook wr = new XSSFWorkbook(readpri);
	      
	       XSSFSheet sheet = wr.getSheet("Sheet1");
	       
	       for (int i = 0; i < 24; i++) {
		
	       XSSFRow row = sheet.getRow(i);
	       XSSFCell cell = row.getCell(0);
	       String mobil = cell.getStringCellValue();
	    
	      
	       XSSFCell cell1 = row.getCell(1);
	       String price = cell1.getStringCellValue();
	       
	       
	        pricelist.add(price);
	        modellist.add(mobil);
	        
	       }
	       
	}
	
	public String lowprice(List<String> low)
	{
		List<Integer> lp = new LinkedList<Integer>();
		String st ="";
		for (String p : low) {
			int pi = Integer.parseInt(p);
			lp.add(pi);
		}
		Collections.sort(lp);
		Integer in = lp.get(0);
		System.out.println(in);
		String vo = String.valueOf(in);
		return vo;
	}
	public String modelname(String nam) throws IOException{
		
		FileInputStream readpri =new FileInputStream("C:\\Users\\sange\\workspace sangeeth\\projectflipkart\\Excel\\flipkart.xlsx");
	       XSSFWorkbook wr = new XSSFWorkbook(readpri);
	      
	       XSSFSheet sheet = wr.getSheet("Sheet1");
	       
	       String sd="";
	       for (int i = 0; i < 24; i++) {
		
	       XSSFRow row = sheet.getRow(i);
	       XSSFCell cell = row.getCell(0);
	       String mobil = cell.getStringCellValue();
	    
	      
	       XSSFCell cell1 = row.getCell(1);
	       String price = cell1.getStringCellValue();
	       
	       if(price.equals(nam)){
	    	   sd=mobil;
	    	   break;
	    	  
	       }
	       }
	       
	       return sd;
	}
}
