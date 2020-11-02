package Assign2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DragandDrop {

	WebDriver wd;
    String urlname="https://jqueryui.com/droppable/";
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "E:\\SELENIUM\\chromedriver.exe");
        wd=new ChromeDriver();
       wd.get(urlname);
        wd.manage().window().maximize();
    }
    @After
    public void tearDown() throws Exception {
        wd.quit();
    }
    @Test
    public void test() throws InterruptedException {
        //Switching to child frame
        wd.switchTo().frame(0);
        
        //Taking webelement from browser
        WebElement DragElement = wd.findElement(By.id("draggable"));
        WebElement DroppingPlace = wd.findElement(By.id("droppable"));
        
        //Performing drag and drop action
        Actions action = new Actions(wd);
        action.dragAndDrop(DragElement, DroppingPlace).perform();
        //implicit wait for 5 seconds 
        Thread.sleep(5000);
        
    }
}
