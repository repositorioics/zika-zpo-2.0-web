package ni.org.ics.zpo.v2.service;

import java.util.List;

import javax.annotation.Resource;

import ni.org.ics.zpo.v2.domain.catalogs.Cs;
import ni.org.ics.zpo.v2.domain.relationships.UserCenter;
import ni.org.ics.zpo.v2.users.model.Authority;
import ni.org.ics.zpo.v2.users.model.Rol;
import ni.org.ics.zpo.v2.users.model.UserAccess;
import ni.org.ics.zpo.v2.users.model.UserSistema;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto UserSistema
 * 
 * @author William Aviles
 * 
 **/

@Service("usuarioService")
@Transactional
public class UsuarioService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos los usuarios
	 * 
	 * @return una lista de <code>UserSistema</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<UserSistema> getUsers() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM UserSistema");
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa todos los usuarios activos
	 * 
	 * @return una lista de <code>UserSistema</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<UserSistema> getActiveUsers() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM UserSistema us where us.enabled is true");
		// Retrieve all
		return  query.list();
	}
	
	
	/**
	 * Regresa un Usuario
	 * 
	 * @return un <code>UserSistema</code>
	 */

	public UserSistema getUser(String username) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM UserSistema u where " +
				"u.username =:username");
		query.setParameter("username",username);
		UserSistema user = (UserSistema) query.uniqueResult();
		return user;
	}
	
	/**
	 * Regresa un Usuario para Edicion
	 * 
	 * @return un <code>UserSistema</code>
	 */

	public UserSistema getUsuarioEditar(String username) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM UserSistema us where us.username=:username");
		query.setParameter("username",username);
		UserSistema user = (UserSistema) query.uniqueResult();
		return user;
	}
	
	/**
	 * Verifica Credenciales
	 * 
	 * @return boolean
	 */

	public Boolean checkCredential(String username) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM UserSistema u where " +
				"u.username =:username");
		query.setParameter("username",username);
		UserSistema user = (UserSistema) query.uniqueResult();
		return user.getCredentialsNonExpired();
	}
	
	/**
	 * Guarda un usuario
	 * 
	 * 
	 */
	public void saveUser(UserSistema user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}
	
	/**
	 * Regresa los UserAccess
	 * 
	 * @return una lista de <code>UserAccess</code>
	 */

	@SuppressWarnings("unchecked")
	public List<UserAccess> getUserAccess(String username) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM UserAccess u where " +
				"u.usuario.username = '" + username + "' order by u.loginDate DESC");
		return query.list();
	}
	
	/**
	 * Regresa todos los roles de usuarios
	 * 
	 * @return una lista de <code>Rol</code>(es)
	 */

	@SuppressWarnings("unchecked")
	public List<Rol> getRoles() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Rol");
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Guarda un rol del usuario
	 * 
	 * 
	 */
	public void saveRoleUser(Authority rol) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(rol);
	}
	
	/**
	 * Regresa todos los roles de usuarios
	 * 
	 * @return una lista de <code>Rol</code>(es)
	 */

	@SuppressWarnings("unchecked")
	public List<Authority> getRolesUsuario(String username) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Authority auth " +
				"where auth.authId.username =:username and auth.pasive ='0'");
		query.setParameter("username",username);
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa un rol del usuario
	 * 
	 * @return un <code>Authority</code>
	 */

	public Authority getRolUsuario(String username, String rol) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Authority auth " +
				"where auth.authId.username =:username and auth.authId.authority =:rol");
		query.setParameter("username",username);
		query.setParameter("rol",rol);
		Authority rolUsuario = (Authority) query.uniqueResult();
		// Retrieve 
		return  rolUsuario;
	}
	
	/**
	 * Regresa todos los roles del usuario
	 * 
	 * @return una lista de <code>Rol</code>(es)
	 */

	@SuppressWarnings("unchecked")
	public List<Authority> getRolesUsuarioTodos(String username) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Authority auth " +
				"where auth.authId.username =:username");
		query.setParameter("username",username);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cs> getCenters() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Cs");
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserCenter> getCentersUser(String username) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM UserCenter uc where " +
				"uc.userCenterId.username =:username and uc.pasive ='0'");
		query.setParameter("username",username);
		List<UserCenter> userscentro = query.list();
		return userscentro;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserCenter> getAllCentersUser(String username) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM UserCenter uc where " +
				"uc.userCenterId.username =:username");
		query.setParameter("username",username);
		List<UserCenter> userscentro = query.list();
		return userscentro;
	}
	
	/**
	 * Guarda un centro del usuario
	 * 
	 * 
	 */
	public void saveCenterUser(UserCenter uc) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(uc);
	}
	
	/**
	 * Regresa un centro del usuario
	 * 
	 * @return un <code>UserCenter</code>
	 */

	public UserCenter getCentroUsuario(String username, String centro) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM UserCenter uc " +
				"where uc.userCenterId.username =:username and uc.userCenterId.center =:centro");
		query.setParameter("username",username);
		query.setParameter("centro",centro);
		UserCenter centroUsuario = (UserCenter) query.uniqueResult();
		// Retrieve 
		return  centroUsuario;
	}
	
}
