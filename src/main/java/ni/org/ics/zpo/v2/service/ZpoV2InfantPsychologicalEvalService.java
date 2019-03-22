package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoV2InfantPsychologicalEvaluation;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Miguel Salinas on 22/03/2019.
 * V1.0
 */
@Service("zpoV2InfantPsychologicalEvalService")
@Transactional
public class ZpoV2InfantPsychologicalEvalService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoV2InfantPsychologicalEvaluation
     * @return una lista de ZpoV2InfantPsychologicalEvaluation
     */
    public List<ZpoV2InfantPsychologicalEvaluation> getZpoV2InfantPsychologicalEvaluations(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ZpoV2InfantPsychologicalEvaluation where pasive = '0'");
        return query.list();
    }

    /**
     * Guardar un formulario ZpoV2InfantPsychologicalEvaluation
     * @param evaluation a guardar
     */
    public void saveOrUpdateZpoV2InfantPsychologicalEval(ZpoV2InfantPsychologicalEvaluation evaluation){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(evaluation);
    }

}
