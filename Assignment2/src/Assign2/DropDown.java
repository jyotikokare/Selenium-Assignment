package Assign2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DropDown {

	WebDriver drive;
    String urlname1="https://www.jquery-az.com/boots/demo.php?ex=63.0_2";
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "E:\\SELENIUM\\chromedriver.exe");
        drive=new ChromeDriver();
        drive.get(urlname1);
        drive.manage().window().maximize();
        drive.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
    }
    @After
    public void tearDown() throws Exception {
    	drive.quit();
    }
    @Test
    public void test() {
       
    	drive.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/button")).click();
        
        List<WebElement> WE = drive.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));
        
        for(int i=0;i<WE.size();i++) {
            String val = WE.get(i).getText();
            if(val.contentEquals("Java")||val.contentEquals("Python")) {
                WE.get(i).click();
            }
        }
    }


}
