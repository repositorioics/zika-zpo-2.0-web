package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoScreening;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Servicio para el objeto ZpoScreening
 * Created by FIRSTICT on 10/11/2016.
 * V1.0
 */
@Service("zpo00ScreeningService")
@Transactional
public class Zpo00ScreeningService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoScreening
     * @return una lista de ZpoScreening
     */
    @SuppressWarnings("unchecked")
    public List<ZpoScreening> getZpo00Screening(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoScreening");
        return query.list();
    }
    
    /**
     * Retorna todos los formularios ZpoScreening
     * @return una lista de ZpoScreening
     */
    @SuppressWarnings("unchecked")
    public List<ZpoScreening> getZpo00ScreeningByUser(String username){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoScreening zpo00 where zpo00.pasive = '0'");
        //query.setParameter("usuarioactual",username);
        return query.list();
    }

    /**
     * Retorna un formulario ZpoScreening
     * @param recordId del ZpoScreening a retornar
     * @return un ZpoScreening
     */
    public ZpoScreening getZpo00Screening(String recordId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoScreening where recordId = :recordId");
        query.setParameter("recordId",recordId);
        return (ZpoScreening)query.uniqueResult();
    }

    /**
     * Guardar un formulario ZpoScreening
     * @param zpo00Screening a guardar
     */
    public void saveZpo00Screening(ZpoScreening zpo00Screening){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpo00Screening);
    }
}
