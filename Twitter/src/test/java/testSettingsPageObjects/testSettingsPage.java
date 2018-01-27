package testSettingsPageObjects;

import homePageObjects.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import settingsPageObjects.SettingsPage;

public class testSettingsPage extends SettingsPage {
    HomePage objHomePage;
    SettingsPage objSettingsPage;

    @BeforeMethod
    public void initializePageObjects() {
        objHomePage = PageFactory.initElements(driver, HomePage.class);
        objSettingsPage = PageFactory.initElements(driver, SettingsPage.class);
    }
    //T3TWI_SP_TC01 verify Personlize ads checkbox
    @Test
    public void testPersonlizeCheckBox(){
        objHomePage.goToSettingsPage();
        objSettingsPage.verifyPersonlizeCheckBox();
        System.out.println("testPersonlizeCheckBox test passed");
    }
    //T3TWI_SP_TC02 verify Personlize devices checkbox
    @Test
    public void testPersonlizeDevicesCheckBox(){
        objHomePage.goToSettingsPage();
        Boolean actual = objSettingsPage.verifyPersonlizeDevices();
        Assert.assertTrue(actual);
        System.out.println("testPersonlizeCheckBox test passed");
    }
    //T3TWI_SP_TC03 click Disable button
    //@Test
    public void testDisableAllButton(){
        objHomePage.goToSettingsPage();
        objSettingsPage.verifyDisableAllButton();
        System.out.println("testDisableAllButton test passed");
    }
    //T3TWI_SP_TC04 verify Track Twitter checkbox
    @Test
    public void testTrackTwitterCheckBox(){
        objHomePage.goToSettingsPage();
        Boolean actual = objSettingsPage.verifyTrackTwitterCheckBox();
        Assert.assertTrue(actual);
        System.out.println("testTrackTwitterCheckBox test passed");
    }

}
