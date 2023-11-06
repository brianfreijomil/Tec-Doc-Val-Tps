package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DockerCreateRepository {

    private WebDriver driver;
    private final WebDriverWait wait1, wait2;
    private final Duration time1;
    private final Duration time2;;
    private WebElement btnCreate, createRepSection, inputName, inputDescription;

    public DockerCreateRepository(WebDriver driver) {
        this.driver = driver;
        time1=Duration.ofMillis(4000);
        time2=Duration.ofMillis(8000);
        wait1 = new WebDriverWait(this.driver, time1);
        wait2 = new WebDriverWait(this.driver, time2);
    }

    public void insideCreateRepositoryAndCreate(String repositoryName, String repositoryDescr) {
        //obtengo boton create a repository
        createRepSection = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("styles-module__cardLink___NwLoW")));
        createRepSection.click();

        // obtengo input de nombre del repositorio
        inputName = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\":rj:\"]")));
        inputName.click();
        inputName.clear();
        inputName.sendKeys(repositoryName);

        //obtengo input de descripcion
        inputDescription = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\":rg:\"]")));
        inputDescription.click();
        inputDescription.clear();
        inputDescription.sendKeys(repositoryDescr);

        //obtengo button create y clickeo
        btnCreate = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mainContainer\"]/div/div[2]/div/div[1]/form/div[2]/div/button")));
        btnCreate.click();
    }

}
