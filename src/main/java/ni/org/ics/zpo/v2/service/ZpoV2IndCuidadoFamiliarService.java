package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoV2IndCuidadoFamilia;
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

@Service("zpoIndCuidadoFamService")
@Transactional
public class ZpoV2IndCuidadoFamiliarService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoV2IndicadoresCuidadoFamiliar
     * @return una lista de ZpoV2IndicadoresCuidadoFamiliar
     */
    @SuppressWarnings("unchecked")
    public List<ZpoV2IndCuidadoFamilia> getZpoIndCuidadFams(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2IndCuidadoFamilia where pasive = '0' ");
        return query.list();
    }


    /**
     * Retorna un formulario ZpoV2IndicadoresCuidadoFamiliar
     * @param recordId del ZpoV2IndicadoresCuidadoFamiliar a retornar
     * @return un ZpoV2IndCuidadoFamilia
     */
    public ZpoV2IndCuidadoFamilia getZpoIndCuidadoFam(String recordId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2IndCuidadoFamilia where recordId = :recordId");
        query.setParameter("recordId",recordId);
        return (ZpoV2IndCuidadoFamilia) query.uniqueResult();
    }

    /**
     * Guardar un formulario ZpoV2IndicadoresCuidadoFamiliar
     * @param zpoIndCuidadoFam a guardar
     */
    public void saveZpoIndCuidadoFamilia(ZpoV2IndCuidadoFamilia zpoIndCuidadoFam){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoIndCuidadoFam);
    }

}
