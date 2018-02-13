package BJSS;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scratchpad {

    @Test
    public void Checkout() {

        WebDriver driver=new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?id_product=4&controller=product");

        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        driver.findElement(By.xpath(".//*[text()='Add to cart']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement checkoutWindow = driver.findElement(By.cssSelector("div.layer_cart_cart"));

        wait.until(ExpectedConditions.visibilityOf(checkoutWindow));

        // driver.switchTo().frame(checkoutWindow);

        driver.findElement(By.cssSelector("span.continue.btn")).click();


       // driver.switchTo().defaultContent();
    }

}
