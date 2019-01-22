package com.finance.robot;

import com.ecust.utils.PageUtils;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AutoReporter {
    @Test
    public void CrawlingCompanyInfo() throws Exception {
        String companyName = "安信证券股份有限公司";
        //开启个浏览器并且输入链接
        WebDriver driver_chanjet = PageUtils.getChromeDriver("http://e.chanjet.com/#home/customer");
        Thread.sleep(2000);
        //1、去登录页面，并且登录
        ChanjetUtils.toLoginAndLogin(driver_chanjet);
        Thread.sleep(5000);
        WebDriver driver_dzswj = PageUtils.getChromeDriver("https://dzswj.ln-n-tax.gov.cn");
        Thread.sleep(2000);
        //1、去登录页面，并且登录
        DzswjUtils.toLoginAndLogin(driver_dzswj);


        /*//2、查询公司名称
        CompanyInfoUtils.searchCompanyName(driver, companyName);
        //3、遍历每个页面
        List<WebElement> pageElements = driver.findElements(By.cssSelector("nav ul.pagination li a"));
        //4、保存当前页面信息
        saveResult(driver, companyName);
        for (int i = 2; i < pageElements.size() - 1; ) {
            //5、进入下一页
            List<WebElement> nextElements = driver.findElements(By.cssSelector("nav ul.pagination li"));
            if (
                    !nextElements.get(nextElements.size() - 1).getAttribute("class").equals("disabled")
                            && i >= 7
            ) {
                pageElements.get(7).click();
            } else {
                pageElements.get(i).click();
                Thread.sleep(2000);
                i = i + 1;
            }
            //6、判断当前页面的情况并进行处理
            CompanyInfoPageHandle.handleDifferentPage(driver);

            //7、保存当前页面信息
            saveResult(driver, companyName);
*/
        //}


    }

}
