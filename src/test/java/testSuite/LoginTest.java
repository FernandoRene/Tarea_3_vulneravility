package testSuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.LoginSection;
import page.MainPage;
import page.MenuSection;
import session.Session;


public class LoginTest {

    MenuSection menuSection = new MenuSection();
    LoginSection loginSection = new LoginSection();
    //MainPage mainPage = new MainPage();

    @BeforeEach
    public void openBrowser(){
        Session.getSession().getBrowser().get("https://todoist.com/app/");
    }

    @Test
    public void loginTest() throws InterruptedException {
        //mainPage.cerrarModalPrimerIngreso(); // Cerrar el modal de bienvenida si aparece
        //mainPage.navBarButton.click();
        //mainPage.loginButton.click();
        Assertions.assertTrue(loginSection.emailTxtBox.isControlDisplayed(), "La página de inicio de sesión no se cargó correctamente");
        loginSection.emailTxtBox.setText("fernandolluscoblanco@gmail.com");
        loginSection.passwordTxtBox.setText("INvocador2024.");
        loginSection.loginButton.click();

        // Esperar y verificar que se ha iniciado sesión correctamente
        Assertions.assertTrue(menuSection.navBarButton.isControlDisplayed(), "No se pudo iniciar sesión correctamente");
        menuSection.navBarButton.click();

        // Verificar que el botón de cierre de sesión está visible
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(), "El botón de cierre de sesión no está visible");
        menuSection.logoutButton.click();

        // Verificar que se ha cerrado sesión correctamente volviendo a la página de inicio de sesión
        Assertions.assertTrue(loginSection.emailTxtBox.isControlDisplayed(), "No se pudo cerrar sesión correctamente");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getSession().closeSession();

    }
}