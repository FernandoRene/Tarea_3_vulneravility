package page;

import control.Button;
import org.openqa.selenium.By;

public class MenuSection {

    public Button navBarButton = new Button(By.id(":r0:"));
    public Button logoutButton = new Button(By.xpath("//div[@role='menuitem']//span[contains(text(), 'Cerrar sesi')]/parent::div"));

}