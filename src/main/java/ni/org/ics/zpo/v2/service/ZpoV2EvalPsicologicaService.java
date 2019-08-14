package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoV2EvaluacionPsicologica;
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

@Service("zpoEvalPsicologicaService")
@Transactional
public class ZpoV2EvalPsicologicaService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoV2EvalPsicologica
     * @return una lista de ZpoV2EvalPsicologica
     */
    @SuppressWarnings("unchecked")
    public List<ZpoV2EvaluacionPsicologica> getZpEvalPsicologicas(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2EvaluacionPsicologica where pasive = '0' ");
        return query.list();
    }


    /**
     * Retorna un formulario ZpoV2EvalPsicologica
     * @param recordId del ZpoV2EvalPsicologica a retornar
     * @return un ZpoV2EvalPsicologica
     */
    public ZpoV2EvaluacionPsicologica getZpoEvalPsicologica(String recordId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2EvaluacionPsicologica where recordId = :recordId");
        query.setParameter("recordId",recordId);
        return (ZpoV2EvaluacionPsicologica) query.uniqueResult();
    }

    /**
     * Guardar un formulario ZpoV2EvalPsicologica
     * @param zpoV2EvaluacionPsicologica a guardar
     */
    public void saveZpoEvalPsicologica(ZpoV2EvaluacionPsicologica zpoV2EvaluacionPsicologica){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoV2EvaluacionPsicologica);
    }

}
