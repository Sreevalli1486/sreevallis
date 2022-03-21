package com.whatsapp2.controller;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.whatsapp2.entity.TimelineDetails;
import com.whatsapp2.entity.WhatsappUserDetails;
import com.whatsapp2.service.WhatsappServiceInterface;
import com.whatsapp2.utility.EntityFactory;
import com.whatsapp2.utility.ServiceFactory;

public class WhatsappController implements WhatsappControllerInterface {
	WhatsappServiceInterface ws=null;
	Logger log =Logger.getLogger("WhatsappController");
	Scanner sc = new Scanner(System.in);
	static String userid;
	
	static int i;
	
	public WhatsappController() {
		ws= ServiceFactory.serviceObject();
	}
	
	
	
	/*public int createProfile() {
		/*
		 Function-Name 	: createProfile
		 Params 		: None
		 Description 	: Function task is to create profile of the user using their name,password,email and address
		 Output 		: Profile created or not
		 Return-type 	: Integer
		 
		 written by :Sreevalli
		 
		
		log.info("enter your name");
		String name = sc.next();
		
		log.info("enter your password");
		String password = sc.next();
		
		log.info("enter your email");
		String email = sc.next();
		
		log.info("enter your address");
		String address = sc.next();
		
		WhatsappUserDetails wud = EntityFactory.entityObject();
		
		wud.setName(name);
		wud.setPassword(password);
		wud.setEmail(email);
		wud.setAddress(address);
		
		
				
		
		i = ws.createProfile(wud);
		
		if(i>0) {
			System.out.println("profile created");
		}
		else {
			System.out.println("profile not created");
		}
		return i;
	}*/

	public void viewAllProfile() {
		
		/*
		 Function-Name 	: viewprofile
		 Params 		: None
		 Description 	: Function task is to view all profiles in the database.
		 Output			: All profiles in the database
		 Return-type 	: None
		 
		 written by :Sreevalli
		 */
		
		
		
		List<WhatsappUserDetails> l1= ws.viewAllprofile();
		l1.forEach(i->{
			System.out.println("******************");
			System.out.println("First name is "+i.getFirstname());
			System.out.println("Name is "+i.getLastname());
			System.out.println("User-Id is "+i.getUserid());
			System.out.println("Email is "+i.getEmail());
			System.out.println("Password is "+i.getPassword());
			
			});
		/*for(WhatsappUserDetails i:l1) {
			System.out.println("******************");
			System.out.println("Name is "+i.getName());
			System.out.println("Email is "+i.getPassword());
			System.out.println("Password is "+i.getEmail());
			System.out.println("Address is "+i.getAddress());
			
		}*/
		//System.out.println("after sorting");
		
		//Collections.sort(l1, new SortByFirstName());
	}

	public void viewProfile() {
		
		/*
		 Function-Name 	: viewprofile
		 Params 		: None
		 Description 	: Function task is to view profile of the user based on the email given by the user.
		 Output			: Profile of a user
		 Return-type 	: None
		 
		 written by :Sreevalli
		 */
		
		
		
		System.out.println("enter email to see profile of that email");
		String email = sc.next();
		
		WhatsappUserDetails wud = EntityFactory.entityObject();
		wud.setEmail(email);
		
		WhatsappUserDetails s1=ws.viewProfile(wud);
		
		if(s1!=null) {
			System.out.println("***************************************************");
			System.out.println("FirstName \t LastName \t Email \t password");
			System.out.println("---------------------------------------------------");
			System.out.println(s1.getFirstname()+"\t"+s1.getLastname()+"\t"+s1.getEmail()+"\t"+s1.getPassword());
			System.out.println("***************************************************");
		}
		else {
			System.out.println("Profile not found");
		}
		
		
	}

	public void deleteProfile() {
		
		/*
		 Function-Name 		: createProfile
		 Params 			: None
		 Description 		: Function task is to delete profile of the user based on the email given by the user.
		 Output				: Profile deleted or not.
		 Return-type 		: None
		 
		 written by : Mallela Divya
		 */
		
		System.out.println("enter email to delete the profile");
		String email = sc.next();
		
		
		WhatsappUserDetails wud = EntityFactory.entityObject();
		wud.setEmail(email);
		
		
		i = ws.deleteProfile(wud);
		
		if(i>0) { 
			System.out.println("profile deleted");
		}
		else {
			System.out.println("profile not deleted");
		}
	}

	public void editProfile() {
		
		/*
		 Function-Name 		: editProfile
		 Params 			: None
		 Description 		: Function task is to edit profile of the user based on the email given by the user.
		 						based on their choice..
		 						1. If they want to edit name press 1
		 						2. If they want to edit password press 2
		 						3. If they want to edit address press 3
		 Output				: Profile edited or not.
		 Return-type 		: None
		 
		 written by : Mallela Divya
		 */
		
		System.out.println("enter email to edit the profile");
		String email = sc.next();
		
		
		
		WhatsappUserDetails wud = EntityFactory.entityObject();
		wud.setEmail(email);
		
		WhatsappUserDetails s1=ws.viewProfile(wud);
		
		System.out.println("Profile details");
		if(s1!=null) {
			System.out.println("***************************************************");
			System.out.println("FirstName \t LastName \t Password \t Email");
			System.out.println("---------------------------------------------------");
			System.out.println(s1.getFirstname()+"\t"+s1.getLastname()+"\t"+s1.getPassword()+"\t"+s1.getEmail());
			System.out.println("***************************************************");
			
			System.out.println("enter your choice to edit particular field");
			System.out.println("press 1 to edit First Name \n"
								+"press 2 to edit Password \n"
								+"press 3 to edit Last name");
			int ch=sc.nextInt();
			
			switch(ch) {
				case 1: System.out.println("enter new firstname");
						String newfirstname = sc.next();
						wud.setNewfirstname(newfirstname);
						i = ws.editFirstName(wud);
						
						if(i>0) { 
							System.out.println("First Name edited");
						}
						else {
							System.out.println("oops! Name not updated");
						}
				
				case 2: System.out.println("enter new password");
						String newpassword = sc.next();
						wud.setNewpassword(newpassword);
						i = ws.editPassword(wud);
						
						if(i>0) { 
							System.out.println("Password updated");
						}
						else {
							System.out.println("oops! Address not updated");
						}
				
				case 3: System.out.println("enter new last name");
						String newlastname = sc.next();
						wud.setNewlastname(newlastname);
						i = ws.editLastName(wud);
						
						if(i>0) { 
							System.out.println("Last name updated");
						}
						else {
							System.out.println("oops! Address not updated");
						}
					}
				
				 }
		else {
			System.out.println("Profile not found");
		}	
	}



	@Override
	public int signUp() {
		System.out.println("Enter your First name");
		String firstname = sc.next();
		
		System.out.println("Enter your Last name");
		String lastname = sc.next();
		
		System.out.println("Enter userid with special characters and numbers");
		userid = sc.next();
		
		System.out.println("Enter email");
		String email = sc.next();
		
		System.out.println("Enter password");
		String password = sc.next();
		
		
		
		
		WhatsappUserDetails wud = EntityFactory.entityObject();
		
		wud.setUserid(userid);
		wud.setFirstname(firstname);
		wud.setLastname(lastname);
		wud.setEmail(email);
		wud.setPassword(password);
		
		
		i = ws.signUp(wud);
		
		if(i>0) {
			System.out.println("Profile Created");
		}
		else {
			System.out.println("oops! something went wrong");
		}
		return i;
	}



	@Override
	public WhatsappUserDetails signIn() {
		System.out.println("Enter email");
		String email = sc.next();
		
		System.out.println("Enter password");
		String password = sc.next();
		
		WhatsappUserDetails wud = EntityFactory.entityObject();
		
		wud.setEmail(email);
		wud.setPassword(password);
		
		
		WhatsappUserDetails s1=ws.validation(wud);
		
		return s1;
		
	}



	@Override
	public int timeline() {

		System.out.println("enter message id");
		String messageid = sc.next();
		
		System.out.println("enter sender userid");
		String sender = sc.next();
		
		//receiver id should be in userdetails table
		System.out.println("enter reciver id");
		String receiver = sc.next();
		
		System.out.println("enter message");
		String message = sc.next();
		
		System.out.println("enter date");
		String date = sc.next();
		
		
		
		
		
		TimelineDetails tld = new TimelineDetails();
		tld.setMessageid(messageid);
		tld.setSender(sender);
		tld.setMassage(message);
		tld.setDate1(date);
		tld.setReceiver(receiver);
	
		
		int i= ws.timeline(tld);
		
		if(i>0) {
			System.out.println("timeline updated");
		}
		else {
			System.out.println("oops! something went wrong");
		}
		return i;
	}



	@Override
	public void searchProfile() {
		System.out.println("Enter first name");
		String firstname = sc.next();
		
		WhatsappUserDetails wud = EntityFactory.entityObject();
		
		wud.setFirstname(firstname);
		List<WhatsappUserDetails> l1= ws.searchProfile(wud);
		l1.forEach(i->{
			System.out.println("******************");
			System.out.println("First name is "+i.getFirstname());
			System.out.println("Name is "+i.getLastname());
			System.out.println("Email is "+i.getPassword());
			System.out.println("Password is "+i.getEmail());
			
			});
		
	}

		
	}


	

