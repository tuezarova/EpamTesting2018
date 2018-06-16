package com.spbstu.EpamLab5.data;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.*;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.web.matcher.junit.Assert;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/page2.htm", title = "Metal and Colors")

public class MetalsAndColorsPage extends WebPage {
    @FindBy(css = ".radio")
    public RadioButtons radios;

    @JFindBy(css = "#elements-checklist | .checkbox label")
    public CheckList elements;

    @JDropdown(root = @FindBy(css = ".colors"),
            list = @FindBy(tagName = "li"))
    public Dropdown colors;

    @JComboBox(root = @FindBy(css = ".metals"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(tagName = "li"))
    public ComboBox metals;

    @JComboBox(root = @FindBy(css = ".salad"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button"))
    public ComboBox vegetables;

    @FindBy(css = ".panel-body-list.results li")
    public TextList resultLog;

    public TextList expectedResult;

    @FindBy(css = "#submit-button")
    public Button submit;

    public void unSelectElementsAndVegetables(MetalsAndColorsDataSet metalsAndColorsDataSet) {
        /*for(int i=0; i<4; i++){
            if(elements.isSelected(PAGE_DATA.ELEMENTS.strAr[i])){
                    elements.select(PAGE_DATA.ELEMENTS.strAr[i]);
            }
            if(vegetables.isSelected(PAGE_DATA.VEGETABLES.strAr[i])){
                elements.select(PAGE_DATA.VEGETABLES.strAr[i]);
            }
        }*/
        for (int i = 0; i < metalsAndColorsDataSet.getElements().length; i++)
            elements.select(metalsAndColorsDataSet.getElements()[i]);
        for (int i = 0; i < metalsAndColorsDataSet.getVegetables().length; i++)
            vegetables.select(metalsAndColorsDataSet.getVegetables()[i]);
    }

    public void selectMetalsAndColors(MetalsAndColorsDataSet metalsAndColorsDataSet) {

        radios.select(Integer.toString(metalsAndColorsDataSet.getSummary()[0]));
        radios.select(Integer.toString(metalsAndColorsDataSet.getSummary()[1]));

        for (int i = 0; i < metalsAndColorsDataSet.getElements().length; i++) {
            elements.select(metalsAndColorsDataSet.getElements()[i]);
        }

        colors.select(metalsAndColorsDataSet.getColor());
        metals.select(metalsAndColorsDataSet.getMetals());

        for (int i = 0; i < metalsAndColorsDataSet.getVegetables().length; i++) {
            vegetables.select(metalsAndColorsDataSet.getVegetables()[i]);
        }
        submit.click();
        unSelectElementsAndVegetables(metalsAndColorsDataSet);
        //System.out.println(resultLog.getValue());
    }

    public void checkSelectedMetalsAndColors(MetalsAndColorsDataSet metalsAndColorsDataSet) {
        //System.out.println(resultLog.getValue());
        int sum = (metalsAndColorsDataSet.getSummary()[0]+metalsAndColorsDataSet.getSummary()[1]);
        Assert.assertTrue(resultLog.getValue().contains(Integer.toString(sum)));
        for(int i=0; i<metalsAndColorsDataSet.getElements().length; i++)
            Assert.assertTrue(resultLog.getValue().contains(metalsAndColorsDataSet.getElements()[i]));
        Assert.assertTrue(resultLog.getValue().contains(metalsAndColorsDataSet.getColor()));
        Assert.assertTrue(resultLog.getValue().contains(metalsAndColorsDataSet.getMetals()));
        for(int i=0; i<metalsAndColorsDataSet.getVegetables().length; i++)
            Assert.assertTrue(resultLog.getValue().contains(metalsAndColorsDataSet.getVegetables()[i]));
    }

}