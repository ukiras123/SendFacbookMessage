package facebook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendMessage extends SendMessages {
	WebDriver driver;

	public SendMessage(WebDriver driver) {
		this.driver = driver;
	}

	public void sendMessage() {
		String message = "I love you :)"; // message you want to send.
		String to = "user name of your friend";
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mercurymessages")));
		driver.findElement(By.name("mercurymessages")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("u_0_4")));
		driver.findElement(By.id("u_0_4")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='inputtext textInput']")));
		WebElement friend = driver.findElement(By.xpath("//input[@class='inputtext textInput']"));
		friend.sendKeys(to);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='user selected']")));
		friend.sendKeys(Keys.TAB);
		WebElement messagebox = driver.findElement(By.xpath("//textarea[@class = 'uiTextareaAutogrow _552m']"));
		messagebox.sendKeys(message);
		messagebox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.close();
		driver.quit();
	}

}
