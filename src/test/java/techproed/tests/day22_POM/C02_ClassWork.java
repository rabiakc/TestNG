package techproed.tests.day22_POM;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.TestCenterPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_ClassWork {
    @Test
    public void test01() {

        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));
        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterPage testCenterPage = new TestCenterPage();
        String userName=ConfigReader.getProperty("techpro_test_username");
        String password=ConfigReader.getProperty("techpro_test_password");
        testCenterPage.username.sendKeys(userName);
        testCenterPage.password.sendKeys(password);
        testCenterPage.submitButton.click();

        ReusableMethods.visibleWait(testCenterPage.logout,15);//logout un görünür olmasını 15 sn bekleyecek

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(testCenterPage.logout.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et
        testCenterPage.logout.click();
        softAssert.assertEquals(Driver.getDriver().getTitle(),"Login");
        softAssert.assertAll();
        //sayfayı kapatınız


    }
}
