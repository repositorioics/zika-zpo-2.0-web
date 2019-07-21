package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoV2CuestSaludInfantil;
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

@Service("zpoCuestSaludInfantilService")
@Transactional
public class ZpoV2CuestSaludInfantilService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoV2CuestSaludInfantil
     * @return una lista de ZpoV2CuestSaludInfantil
     */
    @SuppressWarnings("unchecked")
    public List<ZpoV2CuestSaludInfantil> getZpoCuestSaludInfantil(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2CuestSaludInfantil where pasive = '0' ");
        return query.list();
    }


    /**
     * Retorna un formulario ZpoV2CuestSaludInfantil
     * @param recordId del ZpoV2CuestSaludInfantil a retornar
     * @return un ZpoV2CuestSaludInfantil
     */
    public ZpoV2CuestSaludInfantil getZpoCuestSaludInfantil(String recordId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2CuestSaludInfantil where recordId = :recordId");
        query.setParameter("recordId",recordId);
        return (ZpoV2CuestSaludInfantil) query.uniqueResult();
    }

    /**
     * Guardar un formulario ZpoV2CuestSaludInfantil
     * @param zpoCuestSaludInfantil a guardar
     */
    public void saveZpoCuestSaludInfantil(ZpoV2CuestSaludInfantil zpoCuestSaludInfantil){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoCuestSaludInfantil);
    }

}
