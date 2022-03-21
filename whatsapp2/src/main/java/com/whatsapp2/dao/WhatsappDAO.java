package com.whatsapp2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.whatsapp2.entity.TimelineDetails;
import com.whatsapp2.entity.WhatsappUserDetails;

public class WhatsappDAO implements WhatsappDAOinterface {
	Connection con =null;
	int i=0;
	public WhatsappDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sreevalli");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*public int createProfile(WhatsappUserDetails wud) {
		PreparedStatement ps = null;
		try {
			if(wud.getName().equals("government")) {
				throw new UserDefineException();
			}
			ps = con.prepareStatement("insert into whatsappuser values(?,?,?,?)");
			ps.setString(1,wud.getName());
			ps.setString(2, wud.getPassword());
			ps.setString(3, wud.getEmail());
			ps.setString(4, wud.getAddress());
			
			i=ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(UserDefineException e) {
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
					try {
						ps.close();}
				catch (SQLException e) {
					e.printStackTrace();}
				}
			}
		return i;
	}*/

	public ArrayList<WhatsappUserDetails> viewAllProfile() {
		WhatsappUserDetails l2=null;
		ArrayList<WhatsappUserDetails> list=new ArrayList<WhatsappUserDetails>();
		try {
			
			PreparedStatement ps = con.prepareStatement("select * from userdetails");
			
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				String fn=res.getString(1);
				String ln=res.getString(2);
				String u=res.getString(3);
				String e=res.getString(4);
				String p=res.getString(5);
				
				l2=new WhatsappUserDetails();
				l2.setFirstname(fn);
				l2.setLastname(ln);
				l2.setUserid(u);
				l2.setEmail(e);
				l2.setPassword(p);
				
				
				list.add(l2);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	

	public WhatsappUserDetails viewProfile(WhatsappUserDetails wud) {
		WhatsappUserDetails data = null;
		try {
			
			PreparedStatement ps = con.prepareStatement("select * from userdetails where email=?");
			
			ps.setString(1, wud.getEmail());
			
			ResultSet s1 =ps.executeQuery();
			if(s1.next()){
				String fn=s1.getString(1);
				String ln=s1.getString(2);
				String e=s1.getString(4);
				String p=s1.getString(5);
				
				data=new WhatsappUserDetails();
				data.setFirstname(fn);
				data.setLastname(ln);
				data.setEmail(e);
				data.setPassword(p);
			}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public int deleteProfile(WhatsappUserDetails wud) {
try {
			
			PreparedStatement ps = con.prepareStatement("delete from userdetails where email=?");
			
			ps.setString(1, wud.getEmail());
			
			
			i=ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		return i;
		
		
	}

	public int editFirstName(WhatsappUserDetails wud) {
PreparedStatement ps = null;
		
		try {
			
			ps = con.prepareStatement("UPDATE userdetails SET firstname=? WHERE email=?");
			ps.setString(1, wud.getNewfirstname());
			ps.setString(2, wud.getEmail());
			i=ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
					try {
						ps.close();}
				catch (SQLException e) {
					e.printStackTrace();}
				}
			}
		return i;
		
	}

	public int editPassword(WhatsappUserDetails wud) {
PreparedStatement ps = null;
		
		try {
			System.out.println(wud.getNewpassword());
			ps = con.prepareStatement("UPDATE userdetails SET password=? WHERE email=?");
			ps.setString(1,wud.getNewpassword());
			ps.setString(2, wud.getEmail());
			i=ps.executeUpdate();
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
					try {
						ps.close();}
				catch (SQLException e) {
					e.printStackTrace();}
				}
			}
		return i;
		
	}

	public int editLastName(WhatsappUserDetails wud) {
PreparedStatement ps = null;
		
		try {
			
			ps = con.prepareStatement("UPDATE userdetails SET lastname=? WHERE email=?");
			ps.setString(1,wud.getNewlastname());
			ps.setString(2, wud.getEmail());
			i=ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
					try {
						ps.close();}
				catch (SQLException e) {
					e.printStackTrace();}
				}
			}
		return i;
		
	}

	public int signUp(WhatsappUserDetails wud) {
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into userdetails values(?,?,?,?,?)");
			
			ps.setString(1, wud.getFirstname());
			ps.setString(2, wud.getLastname());
			ps.setString(3, wud.getUserid());
			ps.setString(4, wud.getEmail());
			ps.setString(5, wud.getPassword());
			
			
			i=ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
					try {
						ps.close();}
				catch (SQLException e) {
					e.printStackTrace();}
				}
			}
		return i;
		
	}

	public WhatsappUserDetails validation(WhatsappUserDetails wud) {
		WhatsappUserDetails data = null;
		try {
			
			PreparedStatement ps = con.prepareStatement("select * from userdetails where email=?");
			
			ps.setString(1, wud.getEmail());
			
			ResultSet s1 =ps.executeQuery();
			if(s1.next()){
				
				String p=s1.getString(2);
				String e=s1.getString(3);
				
				
				data=new WhatsappUserDetails();
				
				data.setPassword(p);
				data.setEmail(e);
				
			}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return data;
		
	}

	public int timeline(TimelineDetails tld) {
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into timelinedetails values(?,?,?,?,?)");
			
			ps.setString(1, tld.getMessageid());
			ps.setString(2, tld.getSender());	
			ps.setString(3, tld.getMassage());
			ps.setString(4, tld.getDate1());
			ps.setString(5, tld.getReceiver());
			
			
			
			i=ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
					try {
						ps.close();}
				catch (SQLException e) {
					e.printStackTrace();}
				}
			}
		return i;
		
		
	}
	/*public int editAddress(WhatsappUserDetails wud) {
	
	PreparedStatement ps = null;
	
	try {
		
		ps = con.prepareStatement("UPDATE userdetails SET address=? WHERE email=?");
		ps.setString(1,wud.getNewaddress());
		ps.setString(2, wud.getEmail());
		i=ps.executeUpdate();
	}
	
	catch(SQLException e) {
		e.printStackTrace();
	}
	finally {
		if(ps!=null) {
				try {
					ps.close();}
			catch (SQLException e) {
				e.printStackTrace();}
			}
		}
	return i;
}*/

	public List<WhatsappUserDetails> searchProfile(WhatsappUserDetails wud) {
		WhatsappUserDetails l2=null;
		ArrayList<WhatsappUserDetails> list=new ArrayList<WhatsappUserDetails>();
		try {
			
			PreparedStatement ps = con.prepareStatement("select * from userdetails where firstname=?");
			ps.setString(1, wud.getFirstname());
			
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				String fn=res.getString(1);
				String ln=res.getString(2);
				String e=res.getString(4);
				String p=res.getString(5);
				
				l2=new WhatsappUserDetails();
				l2.setFirstname(fn);
				l2.setLastname(ln);
				l2.setEmail(e);
				l2.setPassword(p);
				
				
				list.add(l2);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
		
	}

}



