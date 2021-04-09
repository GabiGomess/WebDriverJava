package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage {
    public MePage(WebDriver navegador) {
        super(navegador);
    }

    public MePage clicarAbaMoreDataAboutYou() { // Ao clicar na Aba, continuamos na mesma página
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        return this; // Continua na mesma página
    }

    public AddContactPage clicarNoBotaoAddMoreDataAboutYou() {
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
        return new AddContactPage(navegador);
    }
}
