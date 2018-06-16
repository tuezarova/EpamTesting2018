package com.spbstu.EpamLab4;

import com.spbstu.EpamLab4.enums.PAGE_CONSTANTS;

import com.spbstu.EpamLab4.pages.TestConfig;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;


import static com.spbstu.EpamLab4.enums.PAGE_ELEMENTS_CONSTANTS.*;
import static org.aeonbits.owner.ConfigFactory.create;

@Listeners(com.spbstu.EpamLab4.allure.Allure.class)
@Features({"Testing"})
@Stories({"the test"})

public class TestLab4 {

    static public HomePageSelenide homePageSelenide;
    static public DifferentElementsPages differentElementsPages;
    public static void init(){
        homePageSelenide = new HomePageSelenide();
        differentElementsPages = new DifferentElementsPages();

    }
    @BeforeSuite
    public void beforeSuite() {
        TestConfig cfg = create(TestConfig.class);
        com.codeborne.selenide.Configuration.timeout = 6000;
        com.codeborne.selenide.Configuration.browser = "chrome";
        TestLab4.init();
        homePageSelenide = new HomePageSelenide();


    }

    @Test
    @Step("Test_case_1")
    public void Lab4Task1() {
        homePageSelenide.open();
        com.codeborne.selenide.Selenide.zoom(0.5);
        homePageSelenide.checkLoggedIn(PAGE_CONSTANTS.LOGIN.str, PAGE_CONSTANTS.PASSWORD.str);
        homePageSelenide.checkUserName(PAGE_CONSTANTS.USER_NAME.str);
        homePageSelenide.checkIconsAndTextsExists();
        homePageSelenide.checkMainTitle(PAGE_CONSTANTS.MAIN_HEADER.str);
        homePageSelenide.checkMainText(PAGE_CONSTANTS.HOME_PAGE.str);
        homePageSelenide.checkSreviceButtons(PAGE_CONSTANTS.SERVICE.strAr);

        differentElementsPages.differentElementsPageButton.click();
        differentElementsPages.checkDiffBoxexExists();

        differentElementsPages.selectBoxElements(CHECK_BOXES.strAr[2]);
        differentElementsPages.selectBoxElements(CHECK_BOXES.strAr[0]);
        differentElementsPages.selectRadioElements(RADIOS.strAr[3]);
        differentElementsPages.selectColorElement(DROP_COLORS.strAr[3]);
        differentElementsPages.selectBoxElements(CHECK_BOXES.strAr[0]);
        differentElementsPages.selectBoxElements(CHECK_BOXES.strAr[2]);
        differentElementsPages.checkSelectedElements(SELECT_ELEMENTS.strAr);
        homePageSelenide.serviceHeader.click();
        differentElementsPages.datesPageButton.click();
        differentElementsPages.sliders.get(0).scrollTo();

        System.out.println(differentElementsPages.sliderLength.getSize().width);

        differentElementsPages.checkSlidePositions(0, 100);

        differentElementsPages.checkSlidePositions(0, 0);

        differentElementsPages.checkSlidePositions(100, 100);

        differentElementsPages.checkSlidePositions(30, 70);
    }

   /* @Test
    @Step("Test_case_2")
    public void Lab4Task2() {
        homePageSelenide.open();
        homePageSelenide.checkLoggedIn(PAGE_CONSTANTS.LOGIN.str, PAGE_CONSTANTS.PASSWORD.str);
        homePageSelenide.checkUserName(PAGE_CONSTANTS.USER_NAME.str);

        homePageSelenide.serviceHeader.click();
        differentElementsPages.datesPageButton.click();
        differentElementsPages.sliders.get(0).scrollTo();

        System.out.println(differentElementsPages.sliderLength.getSize().width);

        differentElementsPages.checkSlidePositions(0, 100);

        differentElementsPages.checkSlidePositions(0, 0);

        differentElementsPages.checkSlidePositions(100, 100);

        differentElementsPages.checkSlidePositions(30, 70);

    }*/
}
