package com.spbstu.EpamLab5.pages;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.Sources;

@Sources({"classpath:test.properties"})
public interface TestConfig extends Config {

    @Key("homepage.url")
    String homepage();

    @Key("webdriver.chrome.driver")
    String pathToDriver();

    @Key("webdriver.folder")
    String driverFolder();
}
