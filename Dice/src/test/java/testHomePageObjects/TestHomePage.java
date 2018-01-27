package testHomePageObjects;

import dataObjects.DataFileReader;
import homePageObjects.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.util.List;

public class TestHomePage extends HomePage {

    HomePage objOfHomePage;
    DataFileReader objOfDataFileReader;

    @BeforeMethod
    public void initializationOfElements() {
        objOfHomePage = PageFactory.initElements(driver, HomePage.class);
        objOfDataFileReader = PageFactory.initElements(driver, DataFileReader.class);
    }

    //T3DIC_HP_TC01 Verify Home Page Title
   // @Test
    public void testGetTitle() {
        objOfHomePage.getPageTitle();
        System.out.println("testGetTitle Passed");
    }

    //T3DIC_HP_TC02 Verify Logo
  //  @Test
    public void testLogo() {
        objOfHomePage.verifyLogoStatus();
        objOfHomePage.veriyLogoDisplay();
    }

    //T3DIC_HP_TC04 Verify Links
    @Test
    public void testAllLinksInHomePage() throws IOException {
        List<String> actualLinkList = objOfHomePage.findNumberOfLink();
        List<String> expectedLinkList = objOfDataFileReader.getAssertData("Dice2.xls");
        for (int i = 0; i < actualLinkList.size(); i++) {
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(actualLinkList.get(i).contains(expectedLinkList.get(i)));
            System.out.println("testAllLinksInHomePage Test - Passed");
        }
    }

    //T3DIC_HP_TC05 Search Option
   // @Test
    public void testHomePageSearchOptions() {
        objOfHomePage.searchFromHomePage();
        System.out.println("searchFromHomePage Passed");
    }
}
