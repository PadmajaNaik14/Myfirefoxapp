package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        // ---------------- TAB 1 ----------------
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        System.out.println("SauceDemo Login Done");

        Thread.sleep(3000);

        // ---------------- TAB 2 ----------------
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);

        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        System.out.println("PracticeTestAutomation Login Done");

        Thread.sleep(3000);

        // ---------------- TAB 3 ----------------
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);

        driver.get("https://automationexercise.com/");

        Thread.sleep(5000);

        // Close popup (if exists)
        try {
            driver.findElement(By.cssSelector(".grippy-host")).click();
        } catch (Exception e) {
            System.out.println("Popup not found");
        }

        Thread.sleep(1000);

        // Add first product
        driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]")).click();

        Thread.sleep(4000);

        driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();

        System.out.println("Product added to cart");

        // Optional: close browser
        // driver.quit();
    }
}
