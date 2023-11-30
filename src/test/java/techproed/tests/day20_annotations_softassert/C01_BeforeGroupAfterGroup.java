package techproed.tests.day20_annotations_softassert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_BeforeGroupAfterGroup {

    WebDriver driver;

    @BeforeGroups("chrome")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @BeforeGroups("edge")
    public void edgeSetUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test(groups = "edge")
    public void test01() {
        driver.get("https://amazon.com");
    }

    @Test(groups = "chrome")
    public void test02() {
        driver.get("https://facebook.com");
    }

    @Test(groups = "chrome")
    public void test03() {
        driver.get("https://google.com");
    }

    @AfterGroups(groups = "chrome")
    public void chromeTearDown(){
        driver.quit();
    }


}
