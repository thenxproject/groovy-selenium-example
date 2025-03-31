package org.example.utility

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import java.time.Duration
import java.util.logging.Level
import java.util.logging.Logger

class Browser {

	protected WebDriver driver
	protected Integer elementWait = 5
	protected static Logger logger = Logger.getLogger(this.getClass().getName())
	protected static String browser = getBrowserName()

	Browser() {
		// Creates the chrome driver to use
		switch (getBrowserName()) {
			case "chrome":
				driver = new ChromeDriver()
				break
			case "gecko":
				driver = new FirefoxDriver()
				break
			default:
				driver = new ChromeDriver()
				break
		}
	}

	/**
	 * Gets the browsers name.
	 *
	 * @return The name of the browser that was launched.
	 */
	static String getBrowserName() {
		String browser = "chrome"

		try {
			browser = System.getProperty("browser", "chrome").toLowerCase()
		} catch (RuntimeException re) {
			logException(re)
			logger.info("Unable to get browser name.")
		}

		switch (browser) {
			case "firefox":
				browser = "gecko"
				break
			default:
				browser = "chrome"
				break
		}

		return browser
	}

	Boolean isDisplayed(By element, Integer timeout = elementWait) {
		Boolean isVisible = false
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout))
			WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(element))
			isVisible = webElement.isDisplayed()
		}
		catch (Exception ignore){
		}

		return isVisible
	}

	WebElement findVisibleElement(By by, Integer timeout = elementWait) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout))
		wait.until(ExpectedConditions.visibilityOfElementLocated(by))
	}

	void click(By by, Integer timeout = elementWait) {
		findVisibleElement(by, timeout).click()
	}

	static void sleep(Integer seconds = 1) {
		Thread.sleep(Duration.ofSeconds(seconds).toMillis())
	}

	String getText(By by, Integer timeout = elementWait) {
		return findVisibleElement(by, timeout).getText()
	}

	void setText(By by, String text, Integer timeout = elementWait) {
		findVisibleElement(by, elementWait).sendKeys(text)
	}

	void openUrl(String url) {
		driver.get(url)
	}

	void closeDriver() {
		driver.close()
		driver.quit()
	}

	/**
	 * Logs an exception with the logger.
	 *
	 * @param exception The exception to log.
	 */
	private static void logException(Exception exception) {
		logger.log(Level.ALL, exception.toString(), exception)
	}
}
