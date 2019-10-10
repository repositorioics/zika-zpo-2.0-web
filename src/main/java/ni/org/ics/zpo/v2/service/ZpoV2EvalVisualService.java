package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoV2EvaluacionVisual;
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

@Service("zpoEvalVisualService")
@Transactional
public class ZpoV2EvalVisualService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoV2EvaluacionVisual
     * @return una lista de ZpoV2EvaluacionVisual
     */
    @SuppressWarnings("unchecked")
    public List<ZpoV2EvaluacionVisual> getZpoEvalVisuales(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2EvaluacionVisual where pasive = '0' ");
        return query.list();
    }


    /**
     * Retorna un formulario ZpoV2EvaluacionVisual
     * @param recordId del ZpoV2EvaluacionVisual a retornar
     * @return un ZpoV2EvaluacionVisual
     */
    public ZpoV2EvaluacionVisual getZpoEvalVisual(String recordId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2EvaluacionVisual where recordId = :recordId");
        query.setParameter("recordId",recordId);
        return (ZpoV2EvaluacionVisual) query.uniqueResult();
    }

    /**
     * Guardar un formulario ZpoV2EvaluacionVisual
     * @param zpoV2EvalVisual a guardar
     */
    public void saveZpoEvalVisual(ZpoV2EvaluacionVisual zpoV2EvalVisual){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoV2EvalVisual);
    }

}
