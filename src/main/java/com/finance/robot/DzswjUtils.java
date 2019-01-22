package com.finance.robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DzswjUtils {
    //去登陆页面并且登录
    public static void toLoginAndLogin(WebDriver driver) {
        //1、去登陆页面
        List<WebElement> elements = driver.findElements(By.cssSelector("body > div.header > div > a > img"));
        WebElement loginElement = elements.get(elements.size() - 1);
        loginElement.click();
        //2、该方法判断当前页面是登录页面，则进行登录
        //CompanyInfoPageHandle.handleDifferentPage(driver);
        DzswjPageHandle.login(driver,"91210103MA0XYDTP7T","ZZT3LW");
    }
}
