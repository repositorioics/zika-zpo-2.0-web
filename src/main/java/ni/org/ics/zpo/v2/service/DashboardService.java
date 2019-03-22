package ni.org.ics.zpo.v2.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;


import ni.org.ics.zpo.v2.users.model.UserSistema;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("dashboardService")
@Transactional
public class DashboardService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Object> tamizajesDia(UserSistema usuario, long date1, long date2){
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		date2 = date2 + (24*60*60*1000-1000);
		Timestamp timeStampInicio = new Timestamp(date1);
		Timestamp timeStampFinal = new Timestamp(date2);
		// Create a Hibernate query (HQL)
        Query query = session.createQuery("select zpo00.scrVisitDate as fecha, "+
        		"count(zpo00.scrCs) as total, " +
        		"sum(case zpo00.scrCs when 'CSSFV' then 1 else 0 end) as CSSFV, " +
        		"sum(case zpo00.scrCs when 'CSFB' then 1 else 0 end) as CSFB " +
        		"FROM ZpoScreening zpo00 " +
        		"where zpo00.scrVisitDate between :fechaInicio and :fechaFinal group by zpo00.scrVisitDate order by zpo00.scrVisitDate");
		query.setTimestamp("fechaInicio", timeStampInicio);
		query.setTimestamp("fechaFinal", timeStampFinal);	
		//query.setParameter("usuarioactual",usuario.getUsername());
        // Retrieve all
		return  query.list();
	}
	
}
