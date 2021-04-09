package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage {
    public LoginFormPage(WebDriver navegador) {
        super(navegador);
    }

    // MONTAGEM ESTRUTURAL - um método para cada um dos campos
    public LoginFormPage digitarLogin(String login) {
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
        return this; //Continuo na mesma página
    }

    public LoginFormPage digitarSenha(String password) {
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
        return this; //Continuo na mesma página
    }

    public SecretaPage clicarSignIn() {
        navegador.findElement(By.linkText("SIGN IN")).click();
        return new SecretaPage(navegador);  // Retorna uma outra página após clicar em login
    }

    // ABORDAGEM FUNCIONAL - Um método por funcionalidade
    public SecretaPage fazerLogin(String login, String senha) {
        digitarLogin(login);
        digitarSenha(senha);
        clicarSignIn();
        return new SecretaPage(navegador);
    }
}
