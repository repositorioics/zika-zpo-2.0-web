package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoV2FormAudicion;
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

@Service("zpoFormAudicionService")
@Transactional
public class ZpoV2FormAudicionService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoV2FormAudicion
     * @return una lista de ZpoV2FormAudicion
     */
    @SuppressWarnings("unchecked")
    public List<ZpoV2FormAudicion> getZpoFormAudiciones(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2FormAudicion where pasive = '0' ");
        return query.list();
    }


    /**
     * Retorna un formulario ZpoV2FormAudicion
     * @param recordId del ZpoV2FormAudicion a retornar
     * @return un ZpoV2FormAudicion
     */
    public ZpoV2FormAudicion getZpoFormAudicion(String recordId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2FormAudicion where recordId = :recordId");
        query.setParameter("recordId",recordId);
        return (ZpoV2FormAudicion) query.uniqueResult();
    }

    /**
     * Guardar un formulario ZpoV2FormAudicion
     * @param zpoV2FormAudicion a guardar
     */
    public void saveZpoFormAudicion(ZpoV2FormAudicion zpoV2FormAudicion){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoV2FormAudicion);
    }

}
