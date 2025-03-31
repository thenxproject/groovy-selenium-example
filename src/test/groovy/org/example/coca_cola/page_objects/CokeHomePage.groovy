package org.example.coca_cola.page_objects

import org.example.utility.Browser
import org.openqa.selenium.By

class CokeHomePage extends BasePage {
	CokeHomePage(Browser browser) {
		super(browser)
		this.url = "https://coca-cola.com/"
		this.atChecker = By.cssSelector("""[src\$="Coke-company-logo-black.svg"]""")
	}

	private By oneTrustCloseButton = By.cssSelector("""#close-pc-btn-handler""")
	private By faqLink = By.cssSelector("""[href="/us/en/about-us/faq"]""")

	void clickOneTrustCloseButton() {
		browser.click(oneTrustCloseButton)
		browser.sleep()
	}

	Boolean isOneTrustModalOpen() {
		return browser.isDisplayed(oneTrustCloseButton)
	}

	void clickFaqsLink() {
		browser.click(faqLink)
	}
}
