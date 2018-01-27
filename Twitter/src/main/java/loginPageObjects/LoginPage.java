package loginPageObjects;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonAPI{
    @FindBy(xpath = "//div[@id='page-container']//fieldset/div[1]/input")
    public static WebElement username;
    @FindBy(className = "js-password-field")
    public static WebElement password;
    @FindBy(xpath = "//div[@id='page-container']//button")
    public static WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"message-drawer\"]/div/div/span")
    public static WebElement errorMessage;

    //T3TWI_LP_TC01 verify Login with blank email and blank password
    public String blankEmailPassword(){
        loginButton.click();
        String str = errorMessage.getText();
        return str;
    }
    //T3TWI_LP_TC02 verify Login with invalid email and blank password
    public String invalidEmailBlankPassword(){
        username.sendKeys("Aarti");
        implicitWait(driver,20);
        int login_size=driver.findElements(By.xpath("//div[@id='page-container']//button")).size();
        driver.findElements(By.xpath("//div[@id='page-container']//button")).get(login_size-1).click();
        String str = errorMessage.getText();
        return str;
    }
    //T3TWI_LP_TC03 verify Login with blank email and invalid password
    public String blankEmailInvalidPassword(){
        password.sendKeys("password");
        loginButton.click();
        String str = errorMessage.getText();
        return str;
    }
    //T3TWI_LP_TC04 verify Login with invalid email and invalid password
    public String invalidEmailInvalidPassword(){
        username.sendKeys("Aarti");
        password.sendKeys("password");
        loginButton.click();
        String str = errorMessage.getText();
        return str;
    }
}
