package com.WorldOfSys.tests;

import com.worldofsystem.drivers.DriverManager;
import com.worldofsystem.pages.*;
import com.worldofsystem.utils.BrowserActions;
import com.worldofsystem.utils.JsonUtils;
import com.worldofsystem.utils.PropertiesUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.worldofsystem.utils.FakerData.dynamicId;
import static com.worldofsystem.utils.PropertiesUtils.loadProperties;

public class E2ETests {

    // variables
    JsonUtils testData;
    String employeeId = dynamicId();
    SoftAssert softAssert = new SoftAssert();
    private WebDriver driver ;

    // tests
    // Test Case 1: Create Employee (PIM Module) - Tag: smoke
    @Test()
    public void CreateNewEmployee() {
        new LoginPageOrange(DriverManager.getDriver()).enterUserName(testData.getJsonData("login-credential.Username"))
                .enterPassword(testData.getJsonData("login-credential.Password"))
                .clickLogin();
        new HomePageOrange(DriverManager.getDriver()).ClickOnPimModule();
        new PimPage(DriverManager.getDriver()).clickAddEmployeeButton();
        new CreateEmployee(DriverManager.getDriver()).enterFirstName(testData.getJsonData("employeeInfo.firstname"))
                .enterLastName(testData.getJsonData("employeeInfo.lastname"))
                .clearEmployeeId()
                .enterEmployeeId(employeeId)
                .clickSaveButton();
    };

    // Test Case 2: Search Employee - Tag: regression
    @Test()
    public void searchEmployee() throws InterruptedException {
        new LoginPageOrange(DriverManager.getDriver()).enterUserName(testData.getJsonData("login-credential.Username"))
                .enterPassword(testData.getJsonData("login-credential.Password"))
                .clickLogin();
        new HomePageOrange(DriverManager.getDriver()).ClickOnPimModule();
        new PimPage(DriverManager.getDriver()).enterEmployeeId1(employeeId)
                .clickSearchButton()
                .clickFirstResult();
        new EmployeeList(DriverManager.getDriver()).verifyEmployeeFirstName(testData.getJsonData("employeeInfo.firstname"));
        new EmployeeList(DriverManager.getDriver()).verifyEmployeeLastName(testData.getJsonData("employeeInfo.lastname"));
        new EmployeeList(DriverManager.getDriver()).verifyEmployeeID(employeeId);
    };

    // Test Case 3: Create Vacancy (Recruitment Module) - Tag: smoke
    @Test
    public void createAVacancy() throws InterruptedException {
        new LoginPageOrange(DriverManager.getDriver()).enterUserName(testData.getJsonData("login-credential.Username"))
                .enterPassword(testData.getJsonData("login-credential.Password"))
                .clickLogin();
        new HomePageOrange(DriverManager.getDriver()).ClickOnRecruitment();
        new Recruitment(DriverManager.getDriver()).clickVacanciesButton();
        new Vacancies(DriverManager.getDriver()).clickAddVacancyButton();
        new AddVacancy(DriverManager.getDriver()).enterVacancyNameField(testData.getJsonData("vacancy-info.name")+dynamicId())
                .enterJobTitleListField(testData.getJsonData("vacancy-info.job-title"))
                .enterHiringManager(testData.getJsonData("vacancy-info.hiring-manager"))
                .clickSaveButton();
    }

    // Test Case 4: Add Candidate - Tag: regression
    @Test()
    public void CreateNewCandidates(){
        new LoginPageOrange(DriverManager.getDriver()).enterUserName(testData.getJsonData("login-credential.Username"))
                .enterPassword(testData.getJsonData("login-credential.Password"))
                .clickLogin();
        new HomePageOrange(DriverManager.getDriver()).ClickOnRecruitment();
        new Recruitment(DriverManager.getDriver()).clickCandidatesButton();
        new Candidates(DriverManager.getDriver()).clickAddCandidatesButton();
        new AddCandidates(DriverManager.getDriver())
                .addFirstName(testData.getJsonData("candidates-info.first-name"))
                .addLastName(testData.getJsonData("candidates-info.last-name")+dynamicId())
                .addEmail(testData.getJsonData("candidates-info.email"))
                .clickSaveButton()
                .verifyCandidatesCreated(testData.getJsonData("candidates-info.first-name")+" "+testData.getJsonData("candidates-info.last-name")+dynamicId());
    }

    // Test Case 5: Create System User and Login - Tag: smoke
    @Test
    public void createSystemUser() throws InterruptedException {
        String userRoleOption = testData.getJsonData("user-info.user-role");
        String EmployeeNameField = testData.getJsonData("user-info.employee-name");
        String StatusField = testData.getJsonData("user-info.status");
        String UserName = testData.getJsonData("user-info.user-name")+dynamicId();
        String PasswordField = testData.getJsonData("user-info.password");
        new LoginPageOrange(DriverManager.getDriver()).enterUserName(testData.getJsonData("login-credential.Username"))
                .enterPassword(testData.getJsonData("login-credential.Password"))
                .clickLogin();
        new HomePageOrange(DriverManager.getDriver()).ClickOnAdmin();
        new Admin(DriverManager.getDriver()).clickAddSystemUserButton();
        new AddSystemUser(DriverManager.getDriver())
                .enterUserRoleOption(userRoleOption)
                .enterEmployeeNameField(EmployeeNameField)
                .enterUserName(UserName)
                .enterStatusField(StatusField)
                .enterPasswordField(PasswordField)
                .enterConfirmPasswordField(PasswordField)
                .clickSaveButton()
                .WaitElement()
                .clickLogOutButton()
                .clickLogOutOption();
        new LoginPageOrange(DriverManager.getDriver())
                .enterUserName(UserName)
                .enterPassword(PasswordField)
                .clickLogin();
        new AddSystemUser(DriverManager.getDriver()).verifySuccessfulLogin("Dashboard");
    }

    // configuration
    @BeforeSuite
    public void beforeSuite(){
        // code
        loadProperties();
        testData =new JsonUtils("test-data");
    }
    @AfterSuite
    public void afterSuite(){
        softAssert.assertAll();
    }
    @BeforeMethod
    public void setup(){
        // code
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        driver = DriverManager.createInstance(browserName);
        new LoginPageOrange(DriverManager.getDriver()).navigateToLoginPage();
    }
    @AfterMethod
    public void tearDown(){
        //code
        BrowserActions.closeBrowser(DriverManager.getDriver());
    }
}
