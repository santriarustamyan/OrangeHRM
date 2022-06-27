package pages;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashBoardPage {
    WebDriver driver;
    private String pageNameUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";

    public DashBoardPage(WebDriver driver){
        this.driver=driver;
    }

    public void assertPageIsOpened(){
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, pageNameUrl);
    }
}
