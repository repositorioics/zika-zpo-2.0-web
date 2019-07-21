package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoV2CuestionarioSaludMaterna;
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

@Service("zpoCuestSaludMaternaService")
@Transactional
public class ZpoV2CuestSaludMaternaService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoV2CuestSaludMaterna
     * @return una lista de ZpoV2CuestSaludMaterna
     */
    @SuppressWarnings("unchecked")
    public List<ZpoV2CuestionarioSaludMaterna> getZpoCuestSaludMaterna(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2CuestionarioSaludMaterna where pasive = '0' ");
        return query.list();
    }


    /**
     * Retorna un formulario ZpoV2CuestSaludMaterna
     * @param recordId del ZpoV2CuestSaludMaterna a retornar
     * @return un ZpoV2CuestSaludMaterna
     */
    public ZpoV2CuestionarioSaludMaterna getZpoCuestSaludMaterna(String recordId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2CuestionarioSaludMaterna where recordId = :recordId");
        query.setParameter("recordId",recordId);
        return (ZpoV2CuestionarioSaludMaterna) query.uniqueResult();
    }

    /**
     * Guardar un formulario ZpoV2CuestSaludMaterna
     * @param zpoCuestSaludMaterna a guardar
     */
    public void saveZpoCuestSaludMaterna(ZpoV2CuestionarioSaludMaterna zpoCuestSaludMaterna){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoCuestSaludMaterna);
    }

}
