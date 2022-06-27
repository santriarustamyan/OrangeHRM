package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddUserPage {
    WebDriver driver;
    Faker faker = new Faker();
    private String employeeName = faker.name().firstName();
    public String username = faker.name().username();
    private String password = faker.internet().password(8,15,true,true,true);
    private final By userRolePath = By.id("systemUser_userType");
    private final By employeeNamePath = By.id("systemUser_employeeName_empName");
    private final By usernamePath = By.id("systemUser_userName");
    private final By statusPath = By.id("systemUser_status");
    private final By passwordPath = By.id("systemUser_password");
    private final By confirmPasswordPath = By.id("systemUser_confirmPassword");
    private final By saveButtonPath = By.id("btnSave");

    public AddUserPage(WebDriver driver){
        this.driver = driver;
    }
    public void addUserData(UsersData.UserRole userRole, UsersData.Status status ){
        new Select(driver.findElement(userRolePath)).selectByVisibleText(userRole.toString());
        driver.findElement(employeeNamePath).sendKeys("Ananya Vijay Dash");
        driver.findElement(usernamePath).sendKeys(username);
        new Select(driver.findElement(statusPath)).selectByVisibleText(status.toString());
        driver.findElement(passwordPath).sendKeys(password);
        driver.findElement(confirmPasswordPath).sendKeys(password);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(saveButtonPath)).click();
    }

}
