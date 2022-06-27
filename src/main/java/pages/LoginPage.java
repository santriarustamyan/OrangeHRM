package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private String userName = "Admin";
    private String password = "admin123";
    private final By userNamePath = By.id("txtUsername");
    private final By userPasswordPath = By.id("txtPassword");
    private final By loginBtn = By.id("btnLogin");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void login(){
        driver.findElement(userNamePath).sendKeys(userName);
        driver.findElement(userPasswordPath).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

}
