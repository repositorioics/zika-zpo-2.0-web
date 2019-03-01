package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.Zpo00Screening;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Servicio para el objeto Zpo00Screening
 * Created by FIRSTICT on 10/11/2016.
 * V1.0
 */
@Service("zpo00ScreeningService")
@Transactional
public class Zpo00ScreeningService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios Zpo00Screening
     * @return una lista de Zpo00Screening
     */
    @SuppressWarnings("unchecked")
    public List<Zpo00Screening> getZpo00Screening(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Zpo00Screening");
        return query.list();
    }
    
    /**
     * Retorna todos los formularios Zpo00Screening
     * @return una lista de Zpo00Screening
     */
    @SuppressWarnings("unchecked")
    public List<Zpo00Screening> getZpo00ScreeningByUser(String username){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Zpo00Screening zpo00 where zpo00.pasive = '0'");
        //query.setParameter("usuarioactual",username);
        return query.list();
    }

    /**
     * Retorna un formulario Zpo00Screening
     * @param recordId del Zpo00Screening a retornar
     * @return un Zpo00Screening
     */
    public Zpo00Screening getZpo00Screening(String recordId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Zpo00Screening where recordId = :recordId");
        query.setParameter("recordId",recordId);
        return (Zpo00Screening)query.uniqueResult();
    }

    /**
     * Guardar un formulario Zpo00Screening
     * @param zpo00Screening a guardar
     */
    public void saveZpo00Screening(Zpo00Screening zpo00Screening){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpo00Screening);
    }
}
