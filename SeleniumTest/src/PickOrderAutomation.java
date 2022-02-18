import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PickOrderAutomation {

	public static void main(String[] args) {

		String chromeDriverLocation = "D:\\WebDriver\\chromedriver_win32\\chromedriver.exe";
		// Add your local chrome webdrier path here
		// Also add all the external jar files to class path

		System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
		WebDriver driver = new ChromeDriver();
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 50);
		Map<String, String> id_pass = new HashMap<String, String>();
		int iterationAmount = 2;

		try {
		// Homepage
		driver.navigate().to("http://automationpractice.com/index.php");
		// Login Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
		
		// Create Account
		for (int i = 1; i <= iterationAmount; i++) {

			CreateNewAccount customerData = new CreateNewAccount();

			id_pass.put(customerData.email, customerData.password);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")))
					.sendKeys(customerData.email);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SubmitCreate"))).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")))
					.sendKeys(customerData.firstName);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_lastname")))
					.sendKeys(customerData.lastName);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwd"))).sendKeys(customerData.password);

			Select dropdown = new Select(driver.findElement(By.id("days")));
			dropdown.selectByIndex(1);
			Select dropdown1 = new Select(driver.findElement(By.id("months")));
			dropdown1.selectByIndex(5);
			Select dropdown2 = new Select(driver.findElement(By.id("years")));
			dropdown2.selectByIndex(23);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address1"))).sendKeys(customerData.address);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city"))).sendKeys(customerData.city);

			Select dropdown3 = new Select(driver.findElement(By.id("id_state")));
			dropdown3.selectByIndex(3);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postcode")))
					.sendKeys(customerData.postalCode);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone_mobile")))
					.sendKeys(customerData.mobileNumber);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alias"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alias"))).sendKeys(customerData.reference);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitAccount"))).click();

			if ((driver.findElement(By.className("logout")).getText().equals("Sign out"))) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logout"))).click();

			}
		}
		
		
		// Shopping
		for (String key : id_pass.keySet()) {

			String currentEmail = key;
			String currentPassword = id_pass.get(key);

			// login
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(currentEmail);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwd"))).sendKeys(currentPassword);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SubmitLogin"))).click();

			// Go to the Dresses section
			driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a")).click();
			// Go to the Casual Dresses section
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div[2]/ul/li[1]/div[1]/a/img"))
					.click();
			// add a dress into the cart
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/div[2]/a[1]/span"))
					.click();
			// Go to the T-shirt section
			driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a")).click();
			// Filter the list with blue color
			driver.findElement(By.xpath("//*[@id=\"color_2\"]")).click();
			// Add a shirt from the filter list
			driver.findElement(By
					.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span"))
					.click();
			// Now goto checkout
			// driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a"))).click();
			// Next
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
			// Next
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span")))
					.click();
			// Checkbox
			driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
			// Next
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/p/button/span"))).click();
			// Payment by check
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a"))).click();
			// Sign out
			driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a")).click();
			// sign in again
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
		}
		} catch(Exception e)
		{
			System.out.print(e);
		}

	}

}
