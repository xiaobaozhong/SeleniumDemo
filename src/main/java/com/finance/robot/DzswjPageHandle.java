package com.finance.robot;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class DzswjPageHandle {
    public static void login(WebDriver driver, String userName, String password){
        WebElement phoneElement = driver.findElement(By.cssSelector("input#name2"));
        phoneElement.sendKeys(userName);
        WebElement passwordElement = driver.findElement(By.cssSelector("input#pass2"));
        passwordElement.sendKeys(password);
        GetVSFile(driver);
        String vsCode = executeTess4J("D:/test.jpg");
        System.out.println(vsCode);
        WebElement checkCodeElement = driver.findElement(By.cssSelector("input#check_code"));
        checkCodeElement.sendKeys(vsCode);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> elements2 = driver.findElements(By.cssSelector("a#loginDW"));
        WebElement login = elements2.get(0);
        login.click();
    }
    /*
        下载验证码文件
     */
    public static void GetVSFile(WebDriver driver){
        try{
            WebElement ele = driver.findElement(By.xpath("//*[@id=\"picimg\"]"));
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            // Get entire page screenshot
            BufferedImage fullImg= ImageIO.read(screenshot);
            // Get the location of element on the page
            org.openqa.selenium.Point point= ele.getLocation();
            // Get width and height of the element
            int eleWidth= ele.getSize().getWidth();
            int eleHeight= ele.getSize().getHeight();
            // Crop the entire page screenshot to get only element screenshot
            BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
            ImageIO.write(eleScreenshot, "jpg", screenshot);
            // Copy the element screenshot to disk
            File screenshotLocation= new File("D:/test.jpg");
            FileUtils.copyFile(screenshot, screenshotLocation);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String executeTess4J(String imgUrl){
        String ocrResult = "";
        try{
            ITesseract instance = new Tesseract();
            //instance.setLanguage("chi_sim");
            File imgDir = new File(imgUrl);
            //long startTime = System.currentTimeMillis();
            ocrResult = instance.doOCR(imgDir);
        }catch (TesseractException e){
            e.printStackTrace();
        }
        return ocrResult;
    }
}
