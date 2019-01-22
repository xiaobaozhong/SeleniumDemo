package com.finance.robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChanjetPageHandle {

    public static void login(WebDriver driver, String userName, String password){
        WebElement phoneElement = driver.findElement(By.cssSelector("input#login3loginNameIpt"));
        phoneElement.sendKeys(userName);
        WebElement passwordElement = driver.findElement(By.cssSelector("input#login3loginPwdIpt"));
        passwordElement.sendKeys(password);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> elements2 = driver.findElements(By.cssSelector("a#login3Btn"));
        WebElement login = elements2.get(0);
        login.click();
    }

}
