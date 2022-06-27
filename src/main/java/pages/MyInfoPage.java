package pages;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MyInfoPage {
    WebDriver driver;
    private final By editAndSaveButton = By.cssSelector("p #btnSave");
    private final By userFirstName = By.name("personal[txtEmpFirstName]");
    private final By userMiddleName = By.name("personal[txtEmpMiddleName]");
    private final By userLastName = By.name("personal[txtEmpLastName]");
    private final By userEmployeeId = By.name("personal[txtEmployeeId]");
    private final By userDriversLicenseNumber = By.name("personal[txtLicenNo]");
    private final By userSSNNumber = By.id("personal_txtNICNo");
    private final By userOtherId = By.id("personal_txtOtherID");
    private final By userLicenseExpiryDate = By.name("personal[txtLicExpDate]");
    private final By userSINNumber = By.id("personal_txtSINNo");
    private final By userNationality = By.id("personal_cmbNation");
    private final By userDateOfBirth = By.name("personal[DOB]");
    private final By userNickName = By.name("personal[txtEmpNickName]");
    private final By userMilitaryService = By.name("personal[txtMilitarySer]");
    private final By userSmoker = By.id("personal_chkSmokeFlag");
    Faker faker = new Faker();
    private String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String middleName = faker.name().nameWithMiddle();
    public String employeeId = faker.idNumber().validSvSeSsn();
    public String nickName = faker.name().username();
//    public String driversLicenseNumber = faker.number().numberBetween( 100000000  ,100000000.);
//    public String lastName = faker.name().lastName();



//    String employeeId,String driversLicenseNumber, String sSNNumber,
//    String otherId,String licenseExpiryDate,String sINNumber,
//    String dateOfBirth,String nationality,String nickName,String militaryService,

    public enum Gender {
        MALE ,
        FEMALE
    }
    public enum MartialStatus{
        SINGLE,
        MARRIED,
        OTHER
    }
    public enum Smoker {
        YES ,
        NO
    }
    public MyInfoPage(WebDriver driver){
        this.driver = driver;
    }
    private final By userGender(Gender gender) {
        return By.id("personal_optGender_"+ (gender.ordinal() + 1) );
    }
    private final By userMarital(MartialStatus status) {
        return By.cssSelector("#personal_cmbMarital > option:nth-child("+(status.ordinal() + 2)+")");
    }
    private final void userIsSmoker(Smoker smoker) {
        if (!driver.findElement(userSmoker).isSelected()  && smoker == Smoker.YES)
            driver.findElement(userSmoker).click();
        else if (driver.findElement(userSmoker).isSelected()  && smoker == Smoker.NO)
            driver.findElement(userSmoker).click();
    }
    private void cleanAllTextFields(){

        driver.findElement(userFirstName).clear();
        driver.findElement(userLastName).clear();
        driver.findElement(userMiddleName).clear();

        driver.findElement(userEmployeeId).clear();
        driver.findElement(userDriversLicenseNumber).clear();
        driver.findElement(userSSNNumber).clear();
        driver.findElement(userOtherId).clear();
        driver.findElement(userLicenseExpiryDate).clear();
        driver.findElement(userSINNumber).clear();

        driver.findElement(userDateOfBirth).clear();

        driver.findElement(userNickName).clear();
        driver.findElement(userMilitaryService).clear();
    }

    public void editInfoUser(String employeeId,String driversLicenseNumber, String sSNNumber,
                             String otherId,String licenseExpiryDate,String sINNumber,
                             String dateOfBirth,String nationality,String militaryService,
                             Gender gender, MartialStatus status, Smoker smoker){

        driver.findElement(editAndSaveButton).click();
        cleanAllTextFields();

        driver.findElement(userFirstName).sendKeys(firstName);
        driver.findElement(userLastName).sendKeys(lastName);
        driver.findElement(userMiddleName).sendKeys(middleName);

        driver.findElement(userEmployeeId).sendKeys(employeeId);
        driver.findElement(userDriversLicenseNumber).sendKeys(driversLicenseNumber);
        driver.findElement(userSSNNumber).sendKeys(sSNNumber);
        driver.findElement(userOtherId).sendKeys(otherId);
        driver.findElement(userLicenseExpiryDate).sendKeys(licenseExpiryDate);
        driver.findElement(userSINNumber).sendKeys(sINNumber);

        driver.findElement(userDateOfBirth).sendKeys(dateOfBirth);
        driver.findElement(  userGender(gender)).click();
        driver.findElement(  userMarital(status)).click();
        new Select(driver.findElement(userNationality)).selectByVisibleText(nationality);

        driver.findElement(userNickName).sendKeys(nickName);
        driver.findElement(userMilitaryService).sendKeys(militaryService);
        userIsSmoker(smoker);

        driver.findElement(editAndSaveButton).click();
    }

}
