package org.example.coca_cola.page_objects

import org.example.utility.Browser
import org.openqa.selenium.By

class CokeHomePage extends BasePage {
	CokeHomePage(Browser browser) {
		super(browser)
		this.url = "https://coca-cola.com/"
		this.atChecker = By.cssSelector("""[src\$="Coke-company-logo-black.svg"]""")

	}

	By oneTrustCloseButton = By.cssSelector("""#close-pc-btn-handler""")

	void clickOneTrustCloseButton() {
		browser.click(oneTrustCloseButton)
		browser.sleep()
	}

	Boolean isOneTrustModalOpen() {
		return browser.isDisplayed(oneTrustCloseButton)
	}
}
