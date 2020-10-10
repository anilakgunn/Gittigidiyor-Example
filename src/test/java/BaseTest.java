import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BaseTest {

    WebDriver driver;
    Scanner scanner;
    List<String> secret;


    @Before
    public void startTest() throws InterruptedException, FileNotFoundException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        File file = new File("secret.txt");
        secret = new ArrayList<String>();
        scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            secret.add(scanner.nextLine());
        }
        driver.get("https://www.gittigidiyor.com");
        Thread.sleep(2000);
        clickByClassName("styles__AlertClose-tyj39b-3 bcfLkR");
        Thread.sleep(2000);
        assertEquals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi",driver.getTitle());
    }

    @After
    public void endTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public void clickByText(String text){
        driver.findElement(By.xpath("//*[text()='"+text+"']")).click();
    }

    public void clickByDataCy(String dataCy){
        driver.findElement(By.xpath("//*[@data-cy='"+dataCy+"']")).click();
    }

    public void sendByName(String name,String value){
        driver.findElement(By.xpath("//*[@name='"+name+"']")).clear();
        driver.findElement(By.xpath("//*[@name='"+name+"']")).sendKeys(value);
    }

    public void sendByDataType(String dataType,String value){
        driver.findElement(By.xpath("//*[@data-type='"+dataType+"']")).clear();
        driver.findElement(By.xpath("//*[@data-type='"+dataType+"']")).sendKeys(value);
    }

    public void clickByClassName(String className){ driver.findElement(By.xpath("//*[@class='"+className+"']")).click(); }

    public void sendByDataCy(String dataCy,String value){
        driver.findElement(By.xpath("//*[@data-cy='"+dataCy+"']")).clear();
        driver.findElement(By.xpath("//*[@data-cy='"+dataCy+"']")).sendKeys(value);
    }

    public void clickByProductIndex(String index){ driver.findElement(By.xpath("//*[@product-index='"+index+"']")).click(); }

    public void clickById(String id){
        driver.findElement(By.xpath("//*[@id='"+id+"']")).click();
    }

    public void selectById(String id,String value){
        new Select(driver.findElement(By.id(id))).selectByValue(value);
    }

}