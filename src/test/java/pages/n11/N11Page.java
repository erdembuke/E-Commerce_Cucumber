package pages.n11;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Parent;
import utilities.GWD;

public class N11Page extends Parent {

    public N11Page() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(linkText = "Giriş Yap")
    public WebElement navLoginBtn;

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(id = "loginButton")
    public WebElement loginBtn;

    @FindBy(className = "error-message")
    public WebElement errorDiv;

    @FindBy(css = "a[title=\"Hesabım\"]")
    public WebElement navUserAccountImg;

}
