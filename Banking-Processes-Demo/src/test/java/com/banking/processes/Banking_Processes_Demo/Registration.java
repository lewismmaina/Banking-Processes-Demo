package com.banking.processes.Banking_Processes_Demo;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Registration {
	final static String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	final static java.util.Random rand = new java.util.Random();
	final static Set<String> identifiers = new HashSet<String>();

	@Test
	public void PositiveRegistration() {
		// create a driver
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// open paramount test page
		String loginURL = "https://parabank.parasoft.com/parabank/index.htm";
		driver.get(loginURL);
		driver.manage().window().maximize();
		sleep(3000);

		// click on Register Link
		WebElement registerLink = driver.findElement(By.xpath("//*[@id='loginPanel']/p[2]/a"));
		registerLink.click();
		sleep(3000);
		// Input valid first name
		WebElement firstName = driver.findElement(By.xpath("//*[@id='customer.firstName']"));
		// random identifier method generates unique names for registration.
		String fName = randomIdentifier();
		firstName.sendKeys(fName);
		String generatedFName = "Generated First Name is " + fName;
		System.out.println(generatedFName);

		// input valid last name
		WebElement lastName = driver.findElement(By.xpath("//*[@id='customer.lastName']"));
		// random identifier method generates unique names for registration.
		String lName = randomIdentifier();
		lastName.sendKeys(lName);
		String generatedLName = "Generated Last Name is " + lName;
		System.out.println(generatedLName);
		sleep(3000);

		// input valid address
		WebElement address = driver.findElement(By.xpath("//*[@id='customer.address.street']"));
		String usedAddress = "P.O Box 193";
		address.sendKeys(usedAddress);
		String displayedAddress = "Generated Address is " + usedAddress;
		System.out.println(displayedAddress);
		sleep(3000);

		// input valid city
		WebElement city = driver.findElement(By.xpath("//*[@id='customer.address.city']"));
		String usedCity = "Gaborone";
		city.sendKeys(usedCity);
		String displayedCity = "Generated City is " + usedCity;
		System.out.println(displayedCity);
		sleep(3000);

		// input valid state
		WebElement state = driver.findElement(By.xpath("//*[@id='customer.address.state']"));
		String usedState = "Ramotswa";
		state.sendKeys(usedState);
		String displayedState = "Generated State is " + usedState;
		System.out.println(displayedState);
		sleep(3000);

		// input valid ZIP Code
		WebElement zipCode = driver.findElement(By.xpath("//*[@id='customer.address.zipCode']"));
		String usedZipCode = "00200";
		zipCode.sendKeys(usedZipCode);
		String displayedZipCode = "Generated ZIP Code is " + usedZipCode;
		System.out.println(displayedZipCode);
		sleep(3000);

		// input valid Phone -Number
		WebElement phoneNumber = driver.findElement(By.xpath("//*[@id='customer.phoneNumber']"));
		// generated random phone numbers
		Random r = new Random(System.currentTimeMillis());
		int randomSixNumber = ((1 + r.nextInt(2)) * 100000 + r.nextInt(100000));

		String sixPhoneNumber = Integer.toString(randomSixNumber);
		String phoneNumberPrefix = "+276763";
		String generatedPNumber = phoneNumberPrefix + sixPhoneNumber;

		phoneNumber.sendKeys(generatedPNumber);
		String displayedPNumber = "Generated Phone Number is " + generatedPNumber;
		System.out.println(displayedPNumber);
		sleep(3000);

		// input valid SSN
		WebElement ssn = driver.findElement(By.xpath("//*[@id='customer.ssn']"));
		ssn.sendKeys(sixPhoneNumber);
		String displayedSSN = "Generated SSN is " + sixPhoneNumber;
		System.out.println(displayedSSN);
		sleep(3000);

		// input valid username
		WebElement userName = driver.findElement(By.xpath("//*[@id='customer.username']"));
		String generatedUserName = fName + "." + lName;
		userName.sendKeys(generatedUserName);
		String displayedUserName = "Generated UserName is " + generatedUserName;
		System.out.println(displayedUserName);
		sleep(3000);

		// input valid password
		WebElement password = driver.findElement(By.xpath("//*[@id='customer.password']"));
		String generatedPassword = "981@RAil" + sixPhoneNumber + ".";
		password.sendKeys(generatedPassword);
		String displayedPassword = "Generated Password is ******";
		System.out.println(displayedPassword);
		sleep(3000);

		// input corresponding password
		WebElement confirmPassword = driver.findElement(By.xpath("//*[@id='repeatedPassword']"));
		String generatedConfirmPassword = "981@RAil" + sixPhoneNumber + ".";
		confirmPassword.sendKeys(generatedConfirmPassword);
		String displayedConfirmPassword = "Generated Confirm Password is ******";
		System.out.println(displayedConfirmPassword);
		sleep(3000);
		// Click Register
		WebElement registerButton = driver
				.findElement(By.xpath("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input"));
		registerButton.click();
		sleep(5000);

		// Proceed to open account 1
		WebElement openAccountLink = driver.findElement(By.xpath("//*[@id='leftPanel']/ul/li[1]/a"));
		openAccountLink.click();
		sleep(3000);
		// Verification of successful redirection to open account URL
		String expectedUrl = "https://parabank.parasoft.com/parabank/openaccount.htm";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

		// Open Account 1
		// Select Account Type Account 1
		Select accountType = new Select(driver.findElement(By.xpath("//*[@id='type']")));
		accountType.selectByIndex(0);
		sleep(3000);
		// Select Transfer From
		Select fromAccountID = new Select(driver.findElement(By.xpath("//*[@id='fromAccountId']")));
		fromAccountID.selectByIndex(0);
		sleep(3000);
		// Click Open Account
		WebElement openAccountButton = driver.findElement(By.xpath("//*[@id='rightPanel']/div/div/form/div/input"));
		openAccountButton.click();
		sleep(3000);
		// Notify user that First Account was opened successful
		System.out.println("First Account is Opened!!");

		// Proceed to open account 2
		WebElement openAccountLink2 = driver.findElement(By.xpath("//*[@id='leftPanel']/ul/li[1]/a"));
		openAccountLink2.click();
		sleep(3000);
		// Verification of successful redirection to open account URL
		String expectedUrl2 = "https://parabank.parasoft.com/parabank/openaccount.htm";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl2);
		// Open Account 2
		// Select Account Type Account 2
		Select accountType2 = new Select(driver.findElement(By.xpath("//*[@id='type']")));
		accountType2.selectByIndex(0);
		sleep(3000);
		// Select Transfer From
		Select fromAccountID2 = new Select(driver.findElement(By.xpath("//*[@id='fromAccountId']")));
		fromAccountID2.selectByIndex(1);
		sleep(3000);
		// Click Open Account
		WebElement openAccountButton2 = driver.findElement(By.xpath("//*[@id='rightPanel']/div/div/form/div/input"));
		openAccountButton2.click();
		sleep(3000);
		// Notify user that Second Account was opened successful
		System.out.println("Second Account is Opened!!");

		// Proceed to open account 3
		WebElement openAccountLink3 = driver.findElement(By.xpath("//*[@id='leftPanel']/ul/li[1]/a"));
		openAccountLink3.click();
		sleep(3000);
		// Verification of successful redirection to open account URL
		String expectedUrl3 = "https://parabank.parasoft.com/parabank/openaccount.htm";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl3);
		// Open Account 3
		// Select Account Type Account 3
		Select accountType3 = new Select(driver.findElement(By.xpath("//*[@id='type']")));
		accountType3.selectByIndex(1);
		sleep(3000);
		// Select Transfer From
		Select fromAccountID3 = new Select(driver.findElement(By.xpath("//*[@id='fromAccountId']")));
		fromAccountID3.selectByIndex(2);
		sleep(3000);
		// Click Open Account
		WebElement openAccountButton3 = driver.findElement(By.xpath("//*[@id='rightPanel']/div/div/form/div/input"));
		openAccountButton3.click();
		sleep(3000);
		// Notify user that Third Account was opened successful
		System.out.println("Third Account is Opened!!");

		// Request Loan
		WebElement loanLink = driver.findElement(By.xpath("//*[@id='leftPanel']/ul/li[7]/a"));
		loanLink.click();
		sleep(3000);
		
		WebElement borrowAmount = driver.findElement(By.xpath("//*[@id='amount']"));
		String loanAmount = "2000";
		borrowAmount.sendKeys(loanAmount);
		String borrowedAmount = "Loan amount is " + loanAmount;
		System.out.println(borrowedAmount);
		sleep(3000);
				
		WebElement downPayment = driver.findElement(By.xpath("//*[@id='downPayment']"));
		String downPaymentAmount = "500";
		downPayment.sendKeys(downPaymentAmount);
		String downPAmount = "Down Payment amount is " + downPaymentAmount;
		System.out.println(downPAmount);
		sleep(3000);
		
		Select loanAccountID = new Select(driver.findElement(By.xpath("//*[@id='fromAccountId']")));
		loanAccountID.selectByIndex(2);
		sleep(3000);
		
		
		WebElement applyNow = driver.findElement(By.xpath("//*[@id='rightPanel']/div/div/form/table/tbody/tr[4]/td[2]/input"));
		applyNow.click();
		sleep(3000);
		System.out.println("Loan Application was Successful");
		
		//Transfer Funds between accounts
		WebElement transferFundsLink = driver.findElement(By.xpath("//*[@id='leftPanel']/ul/li[3]/a"));
		transferFundsLink.click();
		sleep(3000);
		
		WebElement transferAmount = driver.findElement(By.xpath("//*[@id='amount']"));
		String tAmount = "30";
		transferAmount.sendKeys(tAmount);
		String transferedAmount = "Amount to be transfered is " + tAmount;
		System.out.println(transferedAmount);
		sleep(3000);
		
		Select sourceAccountID = new Select(driver.findElement(By.xpath("//*[@id='fromAccountId']")));
		sourceAccountID.selectByIndex(0);
		sleep(3000);
		
		Select destinationAccountID = new Select(driver.findElement(By.xpath("//*[@id='toAccountId']")));
		destinationAccountID.selectByIndex(1);
		sleep(3000);
				
		WebElement transferButton = driver.findElement(By.xpath("//*[@id='rightPanel']/div/div/form/div[2]/input"));
		transferButton.click();
		sleep(3000);
		
		System.out.println("Amount Transfer was successful");
		// close browser
		driver.quit();
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String randomIdentifier() {
		StringBuilder builder = new StringBuilder();
		while (builder.toString().length() == 0) {
			int length = rand.nextInt(5) + 5;
			for (int i = 0; i < length; i++) {
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			}
			if (identifiers.contains(builder.toString())) {
				builder = new StringBuilder();
			}
		}
		return builder.toString();
	}
}
