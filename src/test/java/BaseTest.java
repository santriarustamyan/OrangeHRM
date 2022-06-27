import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashBoardPage dashBoardPage;
    private MenuBoard menuBoard;
    private MyInfoPage myInfoPage;
    private UsersData usersData;
    private AddUserPage addUserPage;

    @BeforeSuite
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeClass
    public void navigateLoginPage(){
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        driver.manage().window().maximize();
        loginPage  = new LoginPage(driver);
        dashBoardPage = new DashBoardPage(driver);
        menuBoard = new MenuBoard(driver);
        myInfoPage = new MyInfoPage(driver);
        usersData= new UsersData(driver);
        addUserPage = new AddUserPage(driver);
    }
    @BeforeMethod
    public void loginTest(){
        loginPage.login();
        dashBoardPage.assertPageIsOpened();
        menuBoard.clickOrangeHRM();
        menuBoard.switchTab();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void editTest(){
        menuBoard.clickMyInfo();
        myInfoPage.editInfoUser( "785455","787745",
                "77787855","99663345","2022-12-12","784512","1993-10-09",
                "Armenian","Yes",
                MyInfoPage.Gender.FEMALE, MyInfoPage.MartialStatus.MARRIED, MyInfoPage.Smoker.NO);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }
    @Test
    public void createUserAndDeleteTest(){
        menuBoard.clickUsersButton();
        usersData.clickAddButton();
        addUserPage.addUserData(UsersData.UserRole.Admin,UsersData.Status.Disabled);
        usersData.searchUser(addUserPage.username);

    }
}
