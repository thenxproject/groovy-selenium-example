package org.example.coca_cola

import org.example.BaseSeleniumTest
import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class DemoTest extends BaseSeleniumTest {
	@Test
	void faqLink() {
		// Goes to Coca-cola website and verifies you get there
		cokeHomePage.go()
		assert cokeHomePage.at()

		// Closes the cookie modal then verifies it is closed
		cokeHomePage.clickOneTrustCloseButton()
		assert !cokeHomePage.isOneTrustModalOpen()

		// Click the FAQs link
		cokeHomePage.clickFaqsLink()

		// Verifies you get to the FAQs page
		assert cokeFaqPage.at()
	}

	@Test
	void oneTrustModal() {
		// Goes to Coca-cola website and verifies you get there
		cokeHomePage.go()
		assert cokeHomePage.at()

		// Verifies the cookie modal is open
		assert cokeHomePage.isOneTrustModalOpen()

		// Closes the cookie modal then verifies it is closed
		cokeHomePage.clickOneTrustCloseButton()
		assert !cokeHomePage.isOneTrustModalOpen()
	}
}
