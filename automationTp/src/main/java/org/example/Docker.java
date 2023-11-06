package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Docker {

    private WebDriver driver;
    private DockerLogin dockerLogin;
    private DockerCreateRepository dockerCreateRepository;
    private DockerSearchDocumentation dockerSearchDocumentation;

    @BeforeClass
    public void initPageFactory() {
        this.driver = new ChromeDriver();
        this.dockerLogin = PageFactory.initElements(this.driver, DockerLogin.class);
        this.dockerCreateRepository = PageFactory.initElements(this.driver, DockerCreateRepository.class);
        this.dockerSearchDocumentation = PageFactory.initElements(this.driver, DockerSearchDocumentation.class);
    }

    @Test(priority = 1)
    public void testLoadPage() {
        this.driver.navigate().to("https://www.docker.com/");
        String titulo = driver.getTitle();
        String expectedTitle = "Docker";
        System.out.println(titulo);
        assertEquals(titulo, expectedTitle);
    }

    @Test(priority = 2)
    public void testLogin() {
        String username = "brianfreijomil";
        String passw = "lobolobo000";
        this.dockerLogin.login(username, passw);
    }

    @Test(priority = 3)
    public void testCreateRepository() {
        this.dockerCreateRepository.insideCreateRepositoryAndCreate("repositorioprueba2", "descripcion de prueba");
    }

    @Test(priority = 4)
    public void testSearchDocumentation() {
        this.dockerSearchDocumentation.searchAndGoToDocumentation();
    }

    @Test (priority=5)
    public void closeDriver() {
        if(this.driver!=null) {
            this.driver.close();
            this.driver=null;
        }
        System.out.println("Docker terminó satisfactoriamente");
        Assert.assertNull(this.driver);
    }

}
