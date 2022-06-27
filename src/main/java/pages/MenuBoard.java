package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuBoard {
    WebDriver driver;
    private By openTab = By.cssSelector("#branding a img");
    private By myInfo = By.cssSelector("#menu_pim_viewMyDetails");
    private By users = By.id("menu_admin_viewAdminModule");
    public MenuBoard(WebDriver driver){
        this.driver = driver;
    }
    public void clickOrangeHRM(){
        driver.findElement(openTab).click();
    }
    public void clickMyInfo(){
        driver.findElement(myInfo).click();
    }
    public void clickUsersButton(){
        driver.findElement(users).click();
    }
    public void switchTab(){
        driver.switchTo().window(driver.getWindowHandle());
    }

}
