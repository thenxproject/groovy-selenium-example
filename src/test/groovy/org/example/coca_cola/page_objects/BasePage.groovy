package org.example.coca_cola.page_objects

import org.example.utility.Browser
import org.openqa.selenium.By

class BasePage {
	BasePage(Browser browser) {
		this.browser = browser
	}
	Browser browser

	protected String url = ""
	protected By atChecker

	Boolean at() {
		return browser.isDisplayed(atChecker)
	}

	void go() {
		browser.openUrl(url)
	}
}
