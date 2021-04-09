package tests;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;
import static org.junit.Assert.*;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioPageObjectsTest.csv")
public class InformacoesUsuarioPageObjectsTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp() {
        navegador = Web.createChrome();
//        navegador = Web.createBrowserStack();
    }

    // TESTES PARA ABORDAGEM FUNCIONAL
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(
            @Param(name="login")String login,
            @Param(name="senha")String senha,
            @Param(name="tipo")String tipo,
            @Param(name="contato")String contato,
            @Param(name="mensagem")String mensagemEsperada
    ) {
        String textoToast = new LoginPage(navegador)
                .clicarSignIn()
                .fazerLogin(login, senha)
                .clicarEmMe()
                .clicarAbaMoreDataAboutYou()
                .clicarNoBotaoAddMoreDataAboutYou()
                .adicionarContato(tipo,contato)
                .capturarTextoToast();

        assertEquals(mensagemEsperada, textoToast);

        String screenshotArquivo = "target/test-report/taskit/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador, screenshotArquivo);
    }

    @After
    public void tearDown() {
        navegador.quit();
    }
}
