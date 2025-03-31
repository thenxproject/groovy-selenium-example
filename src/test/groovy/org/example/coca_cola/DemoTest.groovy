package org.example.coca_cola

import org.example.BaseSeleniumTest
import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class DemoTest extends BaseSeleniumTest {
	@Test
	void cokeHomePage() {
		cokeHomePage.go()
		assert cokeHomePage.at()
	}

	@Test
	void oneTrustModal() {
		cokeHomePage.go()
		assert cokeHomePage.at()
		assert cokeHomePage.isOneTrustModalOpen()
		cokeHomePage.clickOneTrustCloseButton()
		assert !cokeHomePage.isOneTrustModalOpen()
	}
}
