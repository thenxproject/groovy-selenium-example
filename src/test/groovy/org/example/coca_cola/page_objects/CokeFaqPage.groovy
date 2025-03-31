package org.example.coca_cola.page_objects

import org.example.utility.Browser
import org.openqa.selenium.By

class CokeFaqPage extends BasePage {
	CokeFaqPage(Browser browser) {
		super(browser)
		this.url = "https://www.coca-cola.com/us/en/about-us/faq"
		this.atChecker = By.cssSelector(""".button [href\$="contact-us"]""")
	}

}
