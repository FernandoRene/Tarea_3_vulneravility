package page;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class LoginSection {
    public TextBox emailTxtBox = new TextBox(By.id("element-0"));
    public TextBox passwordTxtBox = new TextBox(By.xpath("//input[@type='password' and @autocomplete='current-password' and @minlength='8']"));
    public Button loginButton  = new Button(By.xpath("//button[@data-gtm-id='start-email-login' and @type='submit']"));


}