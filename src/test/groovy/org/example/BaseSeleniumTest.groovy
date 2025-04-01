package org.example

import org.example.utility.BaseObject
import org.junit.jupiter.api.*

import java.util.concurrent.TimeUnit

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@Timeout(value = 3, unit = TimeUnit.MINUTES)
class BaseSeleniumTest extends BaseObject {

	@AfterEach
	void closeBrowser() {
		browser.closeDriver()
	}
}
