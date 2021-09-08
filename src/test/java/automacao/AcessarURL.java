package automacao;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AcessarURL {
	private static WebDriver driver;
	
	@BeforeClass
	public static void abrirNavegador() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe"); // instalar o chromedriver e inserir na ra�z do projeto
		driver = new ChromeDriver();
		driver.get("https://www.linkedin.com/");
	}
	
	@AfterClass
	public static void fecharNavegador() {
		//driver.quit();
	}
	
	@Test
	public void fazerLogin() {
		
		// Clica no bot�o "Entrar", na home da p�gina
		WebElement btnEntrar = driver.findElement(By.xpath("/html/body/nav/div/a[2]"));
		btnEntrar.click();

		// Preenche o campo Email
		WebElement btnUser = driver.findElement(By.id("username"));
		btnUser.sendKeys("your username"); // substituir a string pelo nome de usu�rio
		
		// Preenche o campo Senha
		WebElement btnPass = driver.findElement(By.id("password"));
		btnPass.sendKeys("your password"); // substituir a string pelo nome de usu�rio
		
		// Clica no bot�o "Entrar"
		WebElement btnLoginEntrar = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div[1]/form/div[3]/button"));
		btnLoginEntrar.click();
		
		// Clica na �rea de "postagem"
		WebElement btnPostagem = driver.findElement(By.cssSelector(".artdeco-button.artdeco-button--muted.artdeco-button--4.artdeco-button--tertiary.ember-view.share-box-feed-entry__trigger"));
		btnPostagem.click();
		
		// Add o texto
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".ql-editor")).sendKeys("Ol�, esta � minha primeira automatiza��o de postagem em Java :)");
		
		// Clica no bot�o publicar
		WebElement btnPublicar = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div/div[2]/div[2]/div[3]/button/span"));
		btnPublicar.click();
	}
	

}