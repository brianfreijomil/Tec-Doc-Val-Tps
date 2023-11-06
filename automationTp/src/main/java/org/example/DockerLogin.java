package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DockerLogin {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Duration time;
    private WebElement username, password, sigInBtn, continueBtn;

    public DockerLogin(WebDriver driver) {
        this.driver = driver;
        this.time = Duration.ofMillis(8000);
        this.wait = new WebDriverWait(this.driver, this.time);
    }

    public void login(String user, String pass) {

        //ingreso al login
        this.sigInBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top-menu\"]/li/a")));
        this.sigInBtn.click();

        //username
        this.username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
        this.username.clear();
        this.username.sendKeys(user);

        //btn continue
        this.continueBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div/div/div/div[1]/div/form/div[2]/button")));
        this.continueBtn.submit();

        //password
        this.password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
        this.password.clear();
        this.password.sendKeys(pass);

        //btn continue (cambio el xpath)
        this.continueBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div/div/div/form/div[3]/button")));
        this.continueBtn.submit();

    }
}
