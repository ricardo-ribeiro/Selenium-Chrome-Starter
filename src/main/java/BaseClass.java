
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    public static  WebDriver driver;
    // ChromeDriver Path on System 
    private static final String WINDOWS_CHROME_DRIVER_LOCATION = BaseClass.class.getClassLoader().getResource("chromedriver").getPath();
    private static final String MAC_CHROME_DRIVER_LOCATION = BaseClass.class.getClassLoader().getResource("chromedriver").getPath();


    public static void main(String[] args) {
        setupDriver();
        exampleGotoGoogle();      

    }

    public static void exampleGotoGoogle(){
        driver.get("http://google.com");
    }
    public static void search(){
        WebElement searchBox = driver.findElement(By.id("lst-ib"));
        searchBox.sendKeys("keysToSend");
    }

    public static void setupDriver() {
        if (SystemUtils.IS_OS_WINDOWS){
            System.setProperty("webdriver.chrome.driver", WINDOWS_CHROME_DRIVER_LOCATION);
        }else if(SystemUtils.IS_OS_MAC){
            System.setProperty("webdriver.chrome.driver", MAC_CHROME_DRIVER_LOCATION);            
        }
        driver = new ChromeDriver();
    }   
   

}
