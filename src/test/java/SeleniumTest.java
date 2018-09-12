import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    WebDriver driver;
    @Before
    public void setup()
    {
        //driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        String browser = System.getProperty("browser");
        if(browser == null) {
            driver = new ChromeDriver();
        }
        else if(browser.equals("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else
        {
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");
    }

    @After
    public void quibrowser()
    {
        driver.quit();
    }

    @Test
    public void testEnter() throws InterruptedException {

        String expected = "French language - Wikipedia";

        WebElement barreRecherche = driver.findElement(By.id("lst-ib"));
        barreRecherche.sendKeys("french");
        //barreRecherche.sendKeys("canelé" + Keys.ENTER);
        barreRecherche.sendKeys(Keys.ENTER);

        //WebElement premierResultat = driver.findElement((By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div/h3/a")));
        WebElement premierResultat = driver.findElement(By.cssSelector(".rc>.r>a"));
        Assert.assertEquals(expected, premierResultat.getText());


        //Thread.sleep(1000);

    }

    @Test
    public void testClick() throws InterruptedException {
        String expected = "République française - France — Wikipédia";

        WebElement barreRecherche = driver.findElement(By.id("lst-ib"));
        barreRecherche.sendKeys("france");

        WebElement buttonRecheche = driver.findElement(By.className("lsb"));
        buttonRecheche.click();

        //WebElement premierResultat = driver.findElement((By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div/h3/a")));
        WebElement premierResultat = driver.findElement(By.cssSelector(".rc>.r>a"));
        Assert.assertEquals(expected, premierResultat.getText());



        //Thread.sleep(1000);

    }
}
