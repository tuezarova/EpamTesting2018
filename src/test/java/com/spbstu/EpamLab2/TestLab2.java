package com.spbstu.EpamLab2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.aeonbits.owner.ConfigFactory.create;

public class TestLab2 {

    private WebDriver driver;
    TestConfig cfg;
    public static HomePage homePage;


    public static void initHP(WebDriver driver) {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @BeforeSuite
    public void beforeSuite() {
        cfg = create(TestConfig.class);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        initHP(this.driver);
    }


    @Test
    public void Lab2() {

        homePage.open(cfg);
        homePage.getUrl();

        Assert.assertEquals(homePage.getUrl(), PAGE_CONSTANTS.SITE.str);
        Assert.assertEquals(homePage.getTitle(), PAGE_CONSTANTS.TITLE.str);
        Assert.assertTrue(homePage.isLoggedIn(PAGE_CONSTANTS.LOGIN.str, PAGE_CONSTANTS.PASSWORD.str));
        Assert.assertEquals(homePage.getUsername(), PAGE_CONSTANTS.USER_NAME.str);
        Assert.assertEquals(homePage.getTitle(), PAGE_CONSTANTS.TITLE.str);


        Assert.assertEquals(java.util.Optional.ofNullable(homePage.getIconsNumber()),
                java.util.Optional.ofNullable(PAGE_CONSTANTS.ICONS_NUMBERS.i));
        for (int i = 0; i < PAGE_CONSTANTS.ICONS_NUMBERS.i; i++) {
            Assert.assertEquals(homePage.getPictureText(i), PAGE_CONSTANTS.TEXT.strArr[i]);
        }

        Assert.assertEquals(homePage.getMainTitle(), PAGE_CONSTANTS.MAIN_HEADER.str);
        Assert.assertEquals(homePage.getMainText(), PAGE_CONSTANTS.HOME_PAGE.str);
    }

    @AfterSuite
    public void afterSuite() {
        homePage.driver.close();
    }
}
