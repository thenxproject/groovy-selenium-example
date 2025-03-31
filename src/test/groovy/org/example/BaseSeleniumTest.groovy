package org.example

import org.example.utility.BaseObject
import org.junit.jupiter.api.*

class BaseSeleniumTest extends BaseObject {
	@AfterEach
	void closeBrowser() {
		browser.closeDriver()
	}
}
