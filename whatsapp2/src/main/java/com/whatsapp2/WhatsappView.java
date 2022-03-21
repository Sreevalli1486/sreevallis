package com.whatsapp2;

import java.util.Scanner;

import com.whatsapp2.controller.WhatsappControllerInterface;
import com.whatsapp2.entity.WhatsappUserDetails;
import com.whatsapp2.utility.ControllerFactory;

public class WhatsappView {
	static int ch ;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		WhatsappControllerInterface wc=ControllerFactory.controllerObject();
		WhatsappUserDetails s1;
		
		String s = "y";
		while(s.equals("y")) {
			System.out.println("**************************************************");
			System.out.println("                                                  ");
			System.out.println("Welcome! Sign-In or Sign-Up to reach our website");
			System.out.println("                                                  ");
			System.out.println("**************************************************");
			System.out.println("press 1 to sign-up");
			System.out.println("press 2 to sign-in");
			
			System.out.println("enter your choice");
			ch = sc.nextInt();
		switch(ch) {
			case 1: wc.signUp();
					break;
			case 2: s1 = wc.signIn();
					if(s1!=null) {
						while(s.equals("y")) {
							
							System.out.println("                         ******Main Menu*******");
							System.out.println("                         press 1 to view all profile");
							System.out.println("                         press 2 to view profile");
							System.out.println("                         press 3 to delete profile");
							System.out.println("                         press 4 to edit profile");
							System.out.println("                         press 5 to create timeline");
							System.out.println("                         press 6 to search profile");
							
							System.out.println("enter your choice");
							
							ch = sc.nextInt();
							
							
							
							
							switch(ch) {
								
								case 1: wc.viewAllProfile();
										break;
								case 2: wc.viewProfile();
										break;
								case 3: wc.deleteProfile();
										break;
								case 4: wc.editProfile();
										break;
								case 5: wc.timeline();
										break;
								case 6: wc.searchProfile();
										break;
							}
							System.out.println("press y/n to continue");
							s=sc.next();
						}
					}
					
					else {
						System.out.println("Opps! You are not registered.. please press 1 to sigh-up");
					}
					break;
		}
		System.out.println("press y/n to continue");
		s=sc.next();
		
		
	}
}
	}

