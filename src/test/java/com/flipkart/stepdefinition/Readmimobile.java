package com.flipkart.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.xml.xpath.XPath;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.flipkart.repository.Searchmobile;
import com.flipkart.resources.CommonActions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Readmimobile extends CommonActions{
	
	String redmilowcost ="";
	
	
	
	Searchmobile sm = new Searchmobile();
	CommonActions ca = new CommonActions();
	@When("user need to close login pops")
	public void user_need_to_close_login_pops() {
		ca.buttons(sm.getPopbtn());
	}

	@When("user need to click the search box")
	public void user_need_to_click_the_search_box() {
	    ca.buttons(sm.getSearchbtn());
	}

	@When("user enter the product and click search {string}")
	public void user_enter_the_product_and_click_search(String pro) {
		ca.insertTexts(sm.getSearchbtn(), pro);
		ca.buttons(sm.getTextbtn());
		
	}
	@When("user need to get redmi phone text and price")
	public void user_need_to_get_redmi_phone_text_and_price() throws IOException, InterruptedException {
		
		
		
	//File f = new File("C:\\Users\\sange\\workspace sangeeth\\projectflipkart\\ExcelNewExcel.xlsx");
		
		Thread.sleep(3000);
		List<WebElement> textmobi = driver.findElements(By.xpath("//div[contains(text(),'GB')]/parent::div/div[1]"));
		
		List<WebElement> pri = driver.findElements(By.xpath("//div[contains(text(),'GB')]/parent::div/following-sibling::div/div[1]/div/div[1]"));
	
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet("sheet1");
		
		

		for (int i = 0; i < textmobi.size(); i++) {
			String text = textmobi.get(i).getText();
			
			XSSFRow rw = sh.createRow(i);
			XSSFCell cw = rw.createCell(0);
			cw.setCellValue(text);
			
			
			String text2 = pri.get(i).getText();
			String removespe = removespecial(text2);
			XSSFCell cw2 = rw.createCell(1);
			cw2.setCellValue(removespe);
		}
		
		FileOutputStream mob = new FileOutputStream(
	            new File("C:\\Users\\sange\\workspace sangeeth\\projectflipkart\\Excel\\flipkart.xlsx"));
	  
	        wb.write(mob);

	        mob.close();
	}
	        @When("user need get lowest price")
	        public void user_need_get_lowest_price() throws IOException  {
	       
	        	List<String> pricelist = new LinkedList<String>();
	        	List<String> modellist = new LinkedList<String>();
	        	
	        	excelread(modellist, pricelist);
	        	/*String lowpri = lowprice(pricelist);
	        	
	        	
	         redmilowcost = modelname(lowpri);*/
	        	
	        }
		
	        @When("user need get lowest prices form excel")
	        public void user_need_get_lowest_prices_form_excel() throws InterruptedException {
	        	Thread.sleep(3000);
	        	driver.findElement(By.xpath("//div[text() ='Redmi 8A Dual (Sky White, 32 GB)']")).click();
	        	String parentname = driver.getWindowHandle();
	        	Set<String> allwind = driver.getWindowHandles();
	        	for (String wind : allwind) {
					if(!parentname.equals(allwind)){
						driver.switchTo().window(wind);
						
					}
				}
	        }
	        @When("user need get lowest prices form excels")
	        public void user_need_get_lowest_prices_form_excels() throws InterruptedException {
	        	Thread.sleep(3000);
	        	String gettext = driver.findElement(By.xpath("//h1/span")).getText();
	        	if(gettext.contains(redmilowcost)){
	        		System.out.println(gettext);
	        		System.out.println("verify");
	        		driver.close();
	        	}
	        	
	        }

		/*public static  WebDriver driver;
		
			
			List<WebElement> mobileName = driver.findElements(By.xpath("//div[contains(text(),'GB')]/parent::div/div[1]"));
			
			List<WebElement> mobilePrice = driver.findElements(By.xpath("//div[contains(text(),'GB')]/parent::div/following-sibling::div/div[1]/div/div[1]"));
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet spreadsheet = workbook.createSheet(" Student Data ");
			
		
			
			for (int i = 0; i < mobileName.size(); i++) {
				
				String names = mobileName.get(i).getText();
				System.out.println(names);
				Row row = sheet.createRow(i);
				Cell cell = row.createCell(0);
				cell.setCellValue(names);
				
				 price = mobilePrice.get(i).getText();
				System.out.println(price);
				Row row = sheet.createRow(i);
				Cell cell = row.createCell(1);
				cell.setCellValue(price);
				
			}
			
			
			FileOutputStream out = new FileOutputStream(
		            new File("C:/savedexcel/GFGsheet.xlsx"));
		  
		        workbook.write(out)
	;
		        out.close();
		        
		    //store in array and use ascending or descending order
		        int j = Integer.parseInt(price);
		        int[] k	= {100,10000};        
		    //    least value in array ----> excel 
		        
		        FileInputStream fis=new FileInputStream(new File("C:\\demo\\student.xls"));  
		        HSSFWorkbook wb=new HSSFWorkbook(fis);
		        HSSFSheet sheet=wb.getSheetAt(0);
		        int rows; // No of rows
		        rows = sheet.getPhysicalNumberOfRows();

		        int cols = 0; // No of columns
		        int tmp = 0;
		        
		        for (int i = 0; i < mobileName.size(); i++) {
		        	row = sheet.getRow(i);
		        	 if(row != null) {
		                 tmp = sheet.getRow(i);
		               String  cell = row.getCell(1).getStringCellValue();
		               int l = Integer.parseInt(cell);
		        if(k[0] == l){
		        	sheet.getRow(i);
		        	String  lestPriceMobilename = row.getCell(0).getStringCellValue();
		        }
		        }

			
			
		}
		        
		        driver.findElement(By.xpath("//div[text()='"+lestPriceMobilename+"']")).click();*/
	}



