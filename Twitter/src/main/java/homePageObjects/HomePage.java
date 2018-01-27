package homePageObjects;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonAPI{
    @FindBy(xpath = "//section/div[1]/h1")
    public static WebElement heroImage;
    @FindBy(tagName = "a")
    public List<WebElement> anchorTag = new ArrayList<>();
    @FindBy(xpath = "//*[@id='doc']//h1")
    public static WebElement HomePageText;
    @FindBy(xpath = "//div[@id='doc']/div[1]//div[2]/div/a[2]")
    public static WebElement sports;
    @FindBy(xpath = "//div[@id='doc']/div[1]//div[2]//div[2]/span")
    public static WebElement moreDropBox;
    @FindBy(xpath = "//a[text()='Log in']")
    public static WebElement login;

    //Footer links
    @FindBy(xpath = "//a[text()='About']")
    public static WebElement aboutLink;
    @FindBy(xpath = "//a[text()='Help Center']")
    public static WebElement helpCenterLink;
    @FindBy(xpath = "//a[text()='Blog']")
    public static WebElement blogLink;
    @FindBy(xpath = "//a[text()='Status']")
    public static WebElement statusLink;
    @FindBy(xpath = "//a[text()='Jobs']")
    public static WebElement jobsLink;
    @FindBy(xpath = "//a[text()='Terms']")
    public static WebElement termsLink;
    @FindBy(xpath = "//a[text()='Cookies']")
    public static WebElement cookiesLink;
    @FindBy(xpath = "//a[text()='Settings']")
    public static WebElement settingsLink;

    //T3TWI_HP_TC01 go to About page and get HeroImage text
    public static String goToAboutPageGetHeroImageText(){
        aboutLink.click();
        implicitWait(driver, 10);
        String str = heroImage.getText();
        System.out.println("Hero Image text: "+str);
        return str;
    }
    //T3TWI_HP_TC02 Get list of links in Home page(anchor tags)
    public int findNumberOfLinks() {
        int countLinks = anchorTag.size();
        System.out.println("Total count of Links in the page: "+countLinks);
        implicitWait(driver, 5);
        List<String> actualLinks = new ArrayList<>();
        for (int i = 0; i < anchorTag.size(); i = i + 1) {
            implicitWait(driver, 5);
           // System.out.println(anchorTag.get(i).getText());
            if (anchorTag.get(i).getText() != null && anchorTag.get(i).getText().length() > 0){
                actualLinks.add(anchorTag.get(i).getText());
            }
        }
        for (String link:actualLinks){
            System.out.println("Link text: " + link);
        }
        return countLinks;
    }
    //T3TWI_HP_TC03 verify HelpCenter link
    public static boolean verifyHelpCenterLink(){
        Boolean bl = helpCenterLink.isDisplayed();
        return bl;
    }
    //T3TWI_HP_TC04 verify Blog link
    public static boolean verifyBlogLink(){
        Boolean bl = blogLink.isDisplayed();
        return bl;
    }
    //Go to Sports page
    public void goToSportsPage() {
        sports.click();
    }
    //T3TWI_HP_TC05 Get items from Sortby drop box
    public void getDropBoxList(){
        moreDropBox.click();
        List<String> moreDropBox = new ArrayList<>();
        List<WebElement> more = driver.findElements(By.className("StreamsCategoryBar-dropdownMenuContent"));
        for (WebElement we : more) {
            moreDropBox.add(we.getText());
        }
        int i=0;
        for (String st: moreDropBox){
            System.out.println(st);
            i++;
        }
        System.out.println("Total number of items in SortBy drop box with size(): "+i+ " and "+moreDropBox.size());
    }
    //T3TWI_HP_TC06 verify HomePage text
    public String verifyHomePageText(){
        String str = HomePageText.getText();
        return str;
    }
    //Go to Settings page
    public void goToSettingsPage(){
        settingsLink.click();
    }
    //Go to LogIn Page
    public void goToLoginPage() {
        login.click();
    }
}
