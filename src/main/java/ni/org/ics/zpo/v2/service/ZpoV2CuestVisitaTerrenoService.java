package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoV2CuestVisitaTerreno;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ics
 */

@Service("zpoCuestVisitaTerrenoService")
@Transactional
public class ZpoV2CuestVisitaTerrenoService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoV2CuestVisitaTerreno
     * @return una lista de ZpoV2CuestVisitaTerreno
     */
    @SuppressWarnings("unchecked")
    public List<ZpoV2CuestVisitaTerreno> getZpoCuestionariosVisitaTerreno(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2CuestVisitaTerreno where pasive = '0' ");
        return query.list();
    }


    /**
     * Retorna un formulario ZpoV2CuestVisitaTerreno
     * @param recordId del ZpoV2CuestVisitaTerreno a retornar
     * @return un ZpoV2CuestVisitaTerreno
     */
    public ZpoV2CuestVisitaTerreno getZpoV2CuestVisitaTerreno(String recordId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2CuestVisitaTerreno where recordId = :recordId");
        query.setParameter("recordId",recordId);
        return (ZpoV2CuestVisitaTerreno) query.uniqueResult();
    }

    /**
     * Guardar un formulario ZpoV2CuestVisitaTerreno
     * @param zpoCuestVisTer a guardar
     */
    public void saveZpoV2CuestVisitaTerreno (ZpoV2CuestVisitaTerreno zpoCuestVisTer){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoCuestVisTer);
    }

}
