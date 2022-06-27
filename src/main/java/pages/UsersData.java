package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UsersData {
    WebDriver driver;
    private final By addButtonPath = By.id("btnAdd");
    private final By searchPath = By.id("searchSystemUser_userName");
    private final By searchBtnPath = By.id("searchBtn");
    private final By checkPath = By.name("chkSelectRow[]");
    private final By deletePath = By.id("btnDelete");
    private final By okBtnPath = By.id("dialogDeleteBtn");
    public enum UserRole{
        Admin,
        ESS
    }
    public enum Status{
        Enabled,
        Disabled
    }
    public UsersData(WebDriver driver){
        this.driver = driver;
    }
    public void clickAddButton(){
        driver.findElement(addButtonPath).click();
    }
    public void searchUser(String username){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(searchPath)).sendKeys(username);
        driver.findElement(searchBtnPath).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(checkPath).click();
        driver.findElement(deletePath).click();
        driver.findElement(okBtnPath).click();
    }

}
