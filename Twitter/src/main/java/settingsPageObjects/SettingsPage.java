package settingsPageObjects;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage extends CommonAPI {
    @FindBy(name = "allow_ads_personalization")
    public static WebElement personalizeCheckBox;
    @FindBy(name = "allow_logged_out_device_personalization")
    public static WebElement personalizeDevicesCheckBox;
    @FindBy(name = "use_cookie_personalization")
    public static WebElement trackTwitterCheckBox;
    @FindBy(name = "allow_sharing_data_for_third_party_personalization")
    public static WebElement shareDateCheckBox;
    @FindBy(xpath = "//*[@id='personalization-form']/div[1]/div/button[1]")
    public static WebElement disable;
    @FindBy(xpath = "//*[@id=\"personalization-disable-warning-dialog-dialog\"]//button[2]")
    public static WebElement yesButton;
    @FindBy(xpath = "//div[@id=\"personalization-disable-warning-dialog-body\"]/p")
    public static WebElement disableText;
    @FindBy (className = "list-link js-nav")
    public static WebElement twitterDataLink;
    @FindBy (id = "content-main-heading")
    public static WebElement twitterDataText;

    //T3TWI_SP_TC01 verify Personlize ads checkbox
    public boolean verifyPersonlizeCheckBox() {
        boolean bl = personalizeCheckBox.isEnabled();
        return bl;
    }
    //T3TWI_SP_TC02 verify Personlize devices checkbox
    public boolean verifyPersonlizeDevices() {
        boolean bl = personalizeDevicesCheckBox.isEnabled();
        return bl;
    }
    //T3TWI_SP_TC03 click Disable button
    public String verifyDisableAllButton() {
        int disable_size=driver.findElements(By.xpath("//*[@id='personalization-form']/div[1]/div/button[1]")).size();
        driver.findElements(By.xpath("//*[@id='personalization-form']/div[1]/div/button[1]")).get(disable_size-1).click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
     new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(yesButton));
        yesButton.click();
        String str = disableText.getText();
        System.out.println("Disable warning text: "+str);
        return str;
    }
    //verify Personlize devices checkbox
    public void verifytwitterDataLink() {
        twitterDataLink.click();
        String str = twitterDataText.getText();
        System.out.println(str);
    }
    //T3TWI_SP_TC04 verify Track Twitter checkbox
    public boolean verifyTrackTwitterCheckBox() {
        boolean bl = personalizeDevicesCheckBox.isEnabled();
        return bl;
    }
}
