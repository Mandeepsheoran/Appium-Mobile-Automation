package org.appium.facadepages;

import org.appium.pages.HomePage;

public class DragDropFacade {
	
	public void navigateToDragAndDropPage() {
		new HomePage().clickViews().clickDetailsMenu("Drag and Drop");
	}
	

}
