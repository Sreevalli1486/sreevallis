package com.whatsapp2.controller;

import com.whatsapp2.entity.WhatsappUserDetails;

public interface WhatsappControllerInterface {
	//int createProfile();

	int viewAllProfile();

	int viewProfile();

	int deleteProfile();

	int editProfile();

	int signUp();

	WhatsappUserDetails signIn();

	int timeline();

	int searchProfile();

	

}
