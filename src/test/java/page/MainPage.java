package page;

import control.Button;
import control.Modal;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import session.Session;

import java.time.Duration;

public class MainPage {
    public Button navBarButton = new Button(By.id("navbarAccount"));
    public Button loginButton = new Button(By.id("navbarLoginButton"));

    public Modal modalWelcome = new Modal(By.id("mat-dialog-0"));
    public Button dismissButton = new Button(By.xpath("//button[@aria-label='Close Welcome Banner' and contains(@class, 'close-dialog')]"));

    public void cerrarModalPrimerIngreso() {
        try {
            WebDriverWait wait = new WebDriverWait(Session.getSession().getBrowser(), Duration.ofMillis(300));
            wait.until(ExpectedConditions.visibilityOfElementLocated(modalWelcome.locator));

            if (modalWelcome.isControlDisplayed()) {
                dismissButton.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(modalWelcome.locator));
            }
        } catch (Exception e) {
            System.out.println("El modal de bienvenida no apareció o ya estaba cerrado: " + e.getMessage());
        }
    }
}

