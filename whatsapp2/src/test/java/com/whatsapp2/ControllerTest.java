package com.whatsapp2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whatsapp2.controller.WhatsappController;
import com.whatsapp2.controller.WhatsappControllerInterface;
import com.whatsapp2.entity.WhatsappUserDetails;
import com.whatsapp2.service.WhatsappServiceInterface;

public class ControllerTest {
	WhatsappControllerInterface wc=null;

	@Before
	public void setUp() throws Exception {
		wc=new WhatsappController();
	}

	@After
	public void tearDown() throws Exception {
		wc=null;
		
	}

	
	/*public void testWhatsappController() {
		
	
		fail("Not yet implemented");
	}*/

	@Test
	public void testViewAllProfile() {
		int i=wc.viewAllProfile();
		assert i>0: ("fail to viewAll profile");
	}

	@Test
	public void testViewProfile() { 
		int i=wc.viewProfile();
		assert i>0: ("fail to view profile");
		
	}

	@Test
	public void testDeleteProfile() {
		int i=wc.deleteProfile();
		assert i>0: ("fail to delete profile");
	}

	@Test
	public void testEditProfile() {
		int i=wc.editProfile();
		assert i>0: ("fail to edit profile");
	}

	@Test
	public void testSignUp() {
		int i=wc.signUp();
		assert i>0: ("fail to signup profile");
	}


	@Test
	public void testSignIn() {
		WhatsappUserDetails i=wc.signIn();
		assert i != null: ("fail to signIn profile");
		
	}

	@Test
	public void testTimeline() {
		int i=wc.timeline();
		assert i>0: ("fail to update timeline profile");
		
	}

	@Test
	public void testSearchProfile() {
		int i=wc.searchProfile();
		assert i>0: ("fail to search profile");
		
	}

}
