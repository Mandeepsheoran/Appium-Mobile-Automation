package org.appium.mobiletest;

import org.appium.facadepages.DragDropFacade;
import org.appium.pages.DragDropPage;
import org.appium.pages.HomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class AppiumTest extends BaseTest{
	
	@Test
	public void clickTest() {
		new HomePage().clickViews().clickDetailsMenu("Drag and Drop");
	}
	
	@Test
	public  void dragDropTest() {
		new DragDropFacade().navigateToDragAndDropPage();
		String droppedmsg =new DragDropPage().performDragDrop().getDroppedMsg();
		Assertions.assertThat(droppedmsg)
		         .isEqualTo("Dropped");
	}

}
