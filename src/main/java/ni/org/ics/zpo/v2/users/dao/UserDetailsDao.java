package ni.org.ics.zpo.v2.users.dao;

import ni.org.ics.zpo.v2.users.model.UserAttempts;

import org.springframework.security.core.Authentication;


public interface UserDetailsDao {

	void updateFailAttempts(String username);

	void resetFailAttempts(String username);
	
	void insertNewAccess(Authentication auth);
	
	void updateAccessDateLogout(String username, String idSesion, String direccionIp);
	
	void updateAccessUrl(String username, String idSesion, String direccionIp, String url);
	
	void checkCredentialsDate(String username);
	
	UserAttempts getUserAttempts(String username);

}