package com.whatsapp2.controller;

import com.whatsapp2.entity.WhatsappUserDetails;

public interface WhatsappControllerInterface {
	//int createProfile();

	void viewAllProfile();

	void viewProfile();

	void deleteProfile();

	void editProfile();

	int signUp();

	WhatsappUserDetails signIn();

	int timeline();

	void searchProfile();

	

}
