package com.whatsapp2.dao;

public class DAOFactory {

	public static WhatsappDAOinterface daoObject() {
		
		return new WhatsappDAO();
	}

}
