package com.dice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup(); // set up ChromeDriver path
		WebDriver driver = new ChromeDriver(); // invoke Selenium WebDriver
		driver.manage().window().fullscreen(); // to make screen full screen
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // set universal wait time in case web page is
																		// slow
		String url = "https://www.dice.com";
		driver.get(url); // navigate to https://www.dice.com

		String actualTitle = driver.getTitle();
		String expectedTitle = "Job Search for Technology Professionals | Dice.com";
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Dice homepage successfully loaded");
		} else {
			System.out.println("Dice homepage successfully loaded");
			throw new RuntimeException("Dice homepage successfully loaded");
		}
		String job = "Javascript Developer";
		driver.findElement(By.id("search-field-keyword")).sendKeys(job);
		String location = "77064";
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		driver.findElement(By.id("findTechJobs")).click();
		String count = driver.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
		int countResult = Integer.parseInt(count.replaceAll(",", "")); 
		if(countResult>0) {
			System.out.println("Step PASS: Job: " +job +" search returned " + countResult + " result in " + location);
		}else {
			System.out.println("Step FAIL: Job: " +job +" search returned " + countResult + " result in " + location);
		}
		driver.close();
		System.out.println("Test completed - " + LocalDateTime.now());
	}
	
}
