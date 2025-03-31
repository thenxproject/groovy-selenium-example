package org.example.utility

import org.example.coca_cola.page_objects.CokeHomePage

class BaseObject {
	Browser browser = new Browser()

	CokeHomePage cokeHomePage = new CokeHomePage(browser)
}
