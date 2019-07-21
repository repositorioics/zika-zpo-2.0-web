package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoV2CuestionarioDemografico;
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

@Service("zpoCuestDemograficoService")
@Transactional
public class ZpoV2CuestDemograficoService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoV2CuestionarioDemografico
     * @return una lista de ZpoV2CuestionarioDemografico
     */
    @SuppressWarnings("unchecked")
    public List<ZpoV2CuestionarioDemografico> getZpoCuestDemograficos(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2CuestionarioDemografico where pasive = '0' ");
        return query.list();
    }


    /**
     * Retorna un formulario ZpoV2CuestionarioDemografico
     * @param recordId del ZpoV2CuestionarioDemografico a retornar
     * @return un ZpoV2CuestionarioDemografico
     */
    public ZpoV2CuestionarioDemografico getZpoCuestDemografico(String recordId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2CuestionarioDemografico where recordId = :recordId");
        query.setParameter("recordId",recordId);
        return (ZpoV2CuestionarioDemografico) query.uniqueResult();
    }

    /**
     * Guardar un formulario ZpoV2CuestionarioDemografico
     * @param zpoCuestDemografico a guardar
     */
    public void saveZpoCuestDemografico(ZpoV2CuestionarioDemografico zpoCuestDemografico){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoCuestDemografico);
    }

}
