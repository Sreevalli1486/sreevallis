package com.whatsapp2.service;

import java.util.ArrayList;
import java.util.List;

import com.whatsapp2.dao.DAOFactory;
import com.whatsapp2.dao.WhatsappDAOinterface;
import com.whatsapp2.entity.TimelineDetails;
import com.whatsapp2.entity.WhatsappUserDetails;

public class WhatsappService implements WhatsappServiceInterface {

	/*public int createProfile(WhatsappUserDetails wud) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		int i = dao.createProfile(wud);
		return i;
	}*/

	@Override
	public ArrayList<WhatsappUserDetails> viewAllprofile() {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		ArrayList<WhatsappUserDetails> s = dao.viewAllProfile();
		return s;
	}

	@Override
	public WhatsappUserDetails viewProfile(WhatsappUserDetails wud) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		WhatsappUserDetails s=dao.viewProfile(wud);
		return s;
	}

	@Override
	public int deleteProfile(WhatsappUserDetails wud) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		int i = dao.deleteProfile(wud);
		return i;
	}

	@Override
	public int editFirstName(WhatsappUserDetails wud) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		int i = dao.editFirstName(wud);
		return i;
	}

	@Override
	public int editPassword(WhatsappUserDetails wud) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		int i = dao.editPassword(wud);
		return i;
	}

	@Override
	public int editLastName(WhatsappUserDetails wud) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		int i = dao.editLastName(wud);
		return i;
	}

	@Override
	public int signUp(WhatsappUserDetails wud) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		int i = dao.signUp(wud);
		return i;
	}

	@Override
	public WhatsappUserDetails validation(WhatsappUserDetails wud) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		WhatsappUserDetails s=dao.validation(wud);
		return s;
	}

	@Override
	public int timeline(TimelineDetails tld) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		int t=dao.timeline(tld);
		return t;
	}

	@Override
	public List<WhatsappUserDetails> searchProfile(WhatsappUserDetails wud) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		List<WhatsappUserDetails> s = dao.searchProfile(wud);
		return s;
	}
	/*public int editProfile(WhatsappUserDetails wud) {
	WhatsappDAOinterface dao = new WhatsappDAO();
	int i = dao.editProfile(wud);
	return i;
	
}*/


}
