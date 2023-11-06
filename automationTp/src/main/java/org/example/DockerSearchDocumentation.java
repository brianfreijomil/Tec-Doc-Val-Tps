package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DockerSearchDocumentation {

    private WebDriver driver;
    private final Duration time;
    private final WebDriverWait wait;
    private WebElement helpBtn, documentationBtn;

    public DockerSearchDocumentation(WebDriver driver) {
        this.driver = driver;
        this.time = Duration.ofMillis(8000);
        this.wait = new WebDriverWait(this.driver, this.time);
    }

    public void searchAndGoToDocumentation() {
        //click en help
        this.helpBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mainContainer\"]/header/div/div/nav/div[1]/button")));
        this.helpBtn.click();

        //click en opcion documentation
        this.documentationBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/ul/a[1]")));
        this.documentationBtn.click();
    }
}
