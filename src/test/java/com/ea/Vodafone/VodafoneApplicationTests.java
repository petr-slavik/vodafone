package com.ea.Vodafone;

import org.openqa.selenium.By;
        
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



@SpringBootTest
class VodafoneApplicationTests {   
  
	@Test
	//void VodafoneTest(String[] args) throws Exception {
        void VodafoneTest() throws Exception {           
            
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            //driver.manage().window().maximize();
            
            //String url = args[0]; 
            //driver.get(url);
            driver.get("https://www.vodafone.cz");

            
            WebElement btnPovolitVse = driver.findElement(By.className("vfcc__button"));
            WebElement btnTelefonyaZarizeni = driver.findElement(By.id("cf5b8462-7c47-4b18-bae5-1589717c5bf0"));
                     
            System.out.println("Step 1: Odklikne cookies");
            btnPovolitVse.click(); 
            System.out.println("Step 2: Klikne na Telefony a zarizeni");
            btnTelefonyaZarizeni.click();
            
            WebElement drpAreYouCustomer = driver.findElement(By.id("select2-chosen-1"));
          
            System.out.print("Step 3: Kontrola jestli je vybrabo, ze uzivatel neni zakaznikem Vodafonu - ");
            String nejsem = drpAreYouCustomer.getText();               
            if(nejsem.contentEquals("Nejsem")) {
                System.out.println("PASS: " + nejsem);
            } else {
                System.out.println("FAIL: " + nejsem);
            }
            
            WebElement drpSTarifem = driver.findElement(By.id("tariffsSelect"));
            System.out.println("Step 4: Rozklikne nabidku tarifu");
            drpSTarifem.click();      
            
            WebElement optBezTarifu = driver.findElement(By.xpath("//div[@id='tariffsSelect']/ul/li[5]/a/span"));
            System.out.println("Step 5: Vybere volbu bez tarifu");
            optBezTarifu.click();
            
            //driver.navigate().refresh();
            Thread.sleep(4000);
                       
            WebElement ourPhone = driver.findElement(By.linkText("Samsung Galaxy Z Flip3 5G 256 GB, černá"));    
            System.out.println("Step 6: Z prodiktu vybere 'Samsung Galaxy Z Flip3 5G 256 GB, černá'");
            ourPhone.click();
            
            System.out.println("Step 7: Na strance produktu zjisti jestli je aktivni volba 'Bez tarifu'");
            if (!driver.getPageSource().contains("Koupit telefon bez tarifu")){
                WebElement drpSTarifem2 = driver.findElement(By.id("tariffsSelect"));
                System.out.println("Step 8: Pokud ne, tak rozklikne vyber tarifu");
                drpSTarifem2.click();  
                WebElement optBezTarifu2 = driver.findElement(By.xpath("//div[@id='tariffsSelect']/ul/li[5]/a/span"));
                System.out.println("Step 9: A vybere 'Ne, chci telefon bez tarifu'");
                optBezTarifu2.click();
            } 
            
            Thread.sleep(4000);

            WebElement btnBezTarifu = driver.findElement(By.linkText("Koupit telefon bez tarifu"));
            System.out.println("Step 10: Klikne na button 'Koupit telefon bez tarifu'");
            btnBezTarifu.click();
            
            System.out.println("Step 11: Udela screenshot a ulozi do 'C:\temp\scereenshot.png'");
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
            
            WebElement btnPokracovatvObjednavce = driver.findElement(By.linkText("Pokračovat v objednávce"));
            System.out.println("Step 12: Klikne na 'Pokracovat v objednavce'");
            btnPokracovatvObjednavce.click();
            
            System.out.println("Step 13: Zavre prohlizec");
            driver.close();
            driver.quit();

            
                
            }
        
        @Test
	//void VodafoneTest(String[] args) throws Exception {
        void VodafoneTest2() throws Exception {  
            Thread.sleep(4000);
        }         
            
            
            


}
