 package com.spbstu.EpamLab3;

import com.spbstu.EpamLab3.DifferentElementsPages;
import com.spbstu.EpamLab3.HomePageSelenide;
import com.spbstu.EpamLab3.enums.PAGE_CONSTANTS;
import com.spbstu.EpamLab3.enums.PAGE_ELEMENTS_CONSTANTS;
import com.spbstu.EpamLab3.pages.TestConfig;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import static org.aeonbits.owner.ConfigFactory.create;


public class TestLab3 {

    static public HomePageSelenide homePageSelenide;
    static public DifferentElementsPages differentElementsPages;

    public static void init() {
        homePageSelenide = new HomePageSelenide();
        differentElementsPages = new DifferentElementsPages();
    }

    @BeforeSuite
    public void beforeSuite() {
        TestConfig cfg = create(TestConfig.class);
        com.codeborne.selenide.Configuration.timeout = 6000;
        com.codeborne.selenide.Configuration.browser = "chrome";
        TestLab3.init();
        homePageSelenide.open();
    }

    @Test
    public void Lab3Task1() {
        //homePageSelenide.open();
        homePageSelenide.checkLoggedIn(PAGE_CONSTANTS.LOGIN.str, PAGE_CONSTANTS.PASSWORD.str);
        homePageSelenide.checkUserName(PAGE_CONSTANTS.USER_NAME.str);
        homePageSelenide.checkIconsAndTextsExists();
        homePageSelenide.checkMainTitle(PAGE_CONSTANTS.MAIN_HEADER.str);
        homePageSelenide.checkMainText(PAGE_CONSTANTS.HOME_PAGE.str);
        homePageSelenide.checkServiceButtons(PAGE_CONSTANTS.SERVICE.strAr);

        differentElementsPages.differentElementsPageButton.click();
        differentElementsPages.checkDiffBoxesExists();

        differentElementsPages.selectBoxElements(PAGE_ELEMENTS_CONSTANTS.CHECK_BOXES.strAr[2]);
        differentElementsPages.selectBoxElements(PAGE_ELEMENTS_CONSTANTS.CHECK_BOXES.strAr[0]);
        differentElementsPages.selectRadioElements(PAGE_ELEMENTS_CONSTANTS.RADIOS.strAr[3]);
        differentElementsPages.selectColorElement(PAGE_ELEMENTS_CONSTANTS.DROP_COLORS.strAr[3]);
        differentElementsPages.selectBoxElements(PAGE_ELEMENTS_CONSTANTS.CHECK_BOXES.strAr[0]);
        differentElementsPages.selectBoxElements(PAGE_ELEMENTS_CONSTANTS.CHECK_BOXES.strAr[2]);
        differentElementsPages.checkSelectedElements(PAGE_ELEMENTS_CONSTANTS.SELECT_ELEMENTS.strAr);
    }

    @Test
    public void Lab3Task2() {
        //homePageSelenide.open();
        homePageSelenide.checkLoggedIn(PAGE_CONSTANTS.LOGIN.str, PAGE_CONSTANTS.PASSWORD.str);
        homePageSelenide.checkUserName(PAGE_CONSTANTS.USER_NAME.str);

        homePageSelenide.serviceHeader.click();
        differentElementsPages.datesPageButton.click();

        differentElementsPages.checkSlidePositions(0, 100);

        differentElementsPages.checkSlidePositions(0, 0);

        differentElementsPages.checkSlidePositions(100, 100);

        differentElementsPages.checkSlidePositions(30, 70);

    }

}
