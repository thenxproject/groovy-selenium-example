package org.example.utility

import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.safari.SafariDriver
import org.openqa.selenium.support.ui.*

import java.time.Duration
import java.util.logging.*

class Browser {

	protected WebDriver driver
	protected Integer elementWait = System.getProperty("elementWait", "3").toInteger()
	protected static Logger logger = Logger.getLogger(this.getClass().getName())

	Browser() {
		// Creates the chrome driver to use
		switch (System.getProperty("browser", "chrome").toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver()
				break
			case "firefox":
				driver = new FirefoxDriver()
				break
			case "safari":
				driver = new SafariDriver()
				break
			default:
				driver = new ChromeDriver()
				break
		}

		Integer height = System.getProperty("height", "1080").toInteger()
		Integer width = System.getProperty("width", "1920").toInteger()
		Dimension windowSize = new Dimension(width, height)
		driver.manage().window().setSize(windowSize)
	}

	Boolean isDisplayed(By element, Integer timeout = elementWait) throws Exception {
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

	private WebElement findVisibleElement(By by, Integer timeout = elementWait) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout))
		wait.until(ExpectedConditions.visibilityOfElementLocated(by))
	}

	void click(By by, Integer timeout = elementWait) throws Exception {
		findVisibleElement(by, timeout).click()
	}

	static void sleep(Integer seconds = 1) throws Exception {
		Thread.sleep(Duration.ofSeconds(seconds).toMillis())
	}

	String getText(By by, Integer timeout = elementWait) throws Exception {
		return findVisibleElement(by, timeout).getText()
	}

	void setText(By by, String text, Integer timeout = elementWait) throws Exception {
		findVisibleElement(by, timeout).sendKeys(text)
	}

	void selectDropdownValue(By by, String text, Integer timeout = elementWait) throws Exception {
		WebElement element = findVisibleElement(by, timeout)
		Select dropdown = new Select(element)
		dropdown.selectByValue(text)
	}

	void openUrl(String url) throws Exception {
		driver.get(url)
	}

	void closeDriver() {
		driver.close()
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
