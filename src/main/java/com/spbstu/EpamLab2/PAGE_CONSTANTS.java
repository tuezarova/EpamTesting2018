package com.spbstu.EpamLab2;

public enum PAGE_CONSTANTS {
    SITE("https://jdi-framework.github.io/tests/index.htm"),
    TITLE("Index Page"),
    LOGIN("epam"),
    PASSWORD("1234"),
    USER_NAME("PITER CHAILOVSKII"),
    ICONS_NUMBERS(4),
    TEXT(new String[] {"To include good practices\nand ideas from successful\nEPAM projec", 
            "To be flexible and\ncustomizable", "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects)," +
                    "\nwish to get more…"}),
    MAIN_HEADER("EPAM FRAMEWORK WISHES…"),
    HOME_PAGE("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT," +
            " SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA." +
            " UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP " +
            "EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN" +
            " VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

    String[] strArr;
    public String str;
    Integer i;
    PAGE_CONSTANTS(String str){
        this.str = str;
    }
    PAGE_CONSTANTS(Integer i){
        this.i = i;
    }
    PAGE_CONSTANTS(String[] strArr){
        this.strArr = strArr;
    }
}