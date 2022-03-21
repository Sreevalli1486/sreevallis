package com.whatsapp2.utility;

import com.whatsapp2.controller.WhatsappController;
import com.whatsapp2.controller.WhatsappControllerInterface;

public class ControllerFactory {

	public static WhatsappControllerInterface controllerObject() {
		
		return  new WhatsappController();
	}

}
