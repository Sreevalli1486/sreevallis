package com.whatsapp2.utility;

import com.whatsapp2.service.WhatsappService;
import com.whatsapp2.service.WhatsappServiceInterface;

public class ServiceFactory {

	public static WhatsappServiceInterface serviceObject() {
		
		return new WhatsappService();
	}

}
