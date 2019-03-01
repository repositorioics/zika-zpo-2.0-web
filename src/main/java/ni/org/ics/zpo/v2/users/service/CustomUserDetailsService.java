package ni.org.ics.zpo.v2.users.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import ni.org.ics.zpo.v2.users.model.Authority;
import ni.org.ics.zpo.v2.users.model.UserSistema;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customUserDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM UserSistema u where " +
				"u.username = '" + username + "'");
		UserSistema userSistema = (UserSistema) query.uniqueResult();
		if (userSistema!=null){
			List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
			query = session.createQuery("FROM Authority auth " +
					"where auth.authId.username =:username and auth.pasive ='0'");
			query.setParameter("username",username);
			@SuppressWarnings("unchecked")
			List<Authority> rolesusuario = query.list();
			for (Authority auth : rolesusuario) {
				authList.add(new SimpleGrantedAuthority(auth.toString()));
			}
			UserDetails user = new User(userSistema.getUsername(), userSistema.getPassword(),userSistema.getEnabled(), 
					userSistema.getAccountNonExpired(), userSistema.getCredentialsNonExpired(), userSistema.getAccountNonLocked(), 
					authList);
			return user;
		}
		else{
			throw new UsernameNotFoundException(username);
		}
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}