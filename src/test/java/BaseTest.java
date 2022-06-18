import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.MenuBoard;
import pages.MyInfoPage;

public class BaseTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashBoardPage dashBoardPage;
    private MenuBoard menuBoard;
    private MyInfoPage myInfoPage;

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
    }

//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }

    @Test
    public void loginTest(){
        loginPage.login();
        dashBoardPage.assertPageIsOpened();
        menuBoard.clickOrangeHRM();
        menuBoard.switchTab();
        menuBoard.clickMyInfo();
        myInfoPage.editInfoUser("Santri","Arustamyan", "Grigor", "785455","787745",
                "77787855","99663345","2022-12-12","784512","1993-10-09",
                "Armenian","san","Yes",
                MyInfoPage.Gender.FEMALE, MyInfoPage.MartialStatus.MARRIED, MyInfoPage.Smoker.NO);
    }
}
