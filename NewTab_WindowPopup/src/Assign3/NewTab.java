package Assign3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NewTab {
	WebDriver d;
    String url="http://openclinic.sourceforge.net/openclinic/home/index.php";
    
	 @Before
	    public void setUp()  {
	        System.setProperty("webdriver.chrome.driver", "E:\\SELENIUM\\chromedriver.exe");
	        d=new ChromeDriver();
	        d.get(url);
	        d.manage().window().maximize();
	    }
	 
	    @After
	    public void tearDown() throws Exception {
	        d.quit();
	    }
	    
	    @Test
	    public void test() throws InterruptedException {
	        //Opening Medical Records in new tab
	        String NewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
	        d.findElement(By.linkText("Medical Records")).sendKeys(NewTab);
	        
	        
	        //switchint handle to next tab
	        Set<String> WindowHandle = d.getWindowHandles();
	        for(String Tab:WindowHandle) {
	            d.switchTo().window(Tab);
	        }        
	        
	        //click on search patient link
	        d.findElement(By.linkText("Search Patient")).click();
	        
	        //select value from dropdown
	        WebElement Field = d.findElement(By.id("search_type"));
	        Select field = new Select(Field);
	        field.selectByVisibleText("First Name");
	        
	        String title1 = d.getTitle();  //title before clicking on search button
	        
	        //click on search patient button
	        d.findElement(By.id("search_patient")).click();
	        
	        String title2 = d.getTitle();   //title after clicking on search button
	        
	        Assert.assertTrue(title1!=title2);
	        
	        System.out.println("Title : "+title2);
	        
	        
	    }

}
