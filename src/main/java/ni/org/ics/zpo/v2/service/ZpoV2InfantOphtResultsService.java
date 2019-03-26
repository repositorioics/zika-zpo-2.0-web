package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoV2InfantOphtResults;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ics on 20/6/2017.
 * V1.0
 */
@Service("zpoV2InfantOphtResultsService")
@Transactional
public class ZpoV2InfantOphtResultsService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoV2InfantOphtResults
     * @return una lista de ZpoV2InfantOphtResults
     */
    @SuppressWarnings("unchecked")
    public List<ZpoV2InfantOphtResults> getZpoV2InfantOphtResults(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2InfantOphtResults");
        return query.list();
    }

    /**
     * Retorna todos los formularios ZpoV2InfantOphtResults
     * @return una lista de ZpoV2InfantOphtResults
     */
    @SuppressWarnings("unchecked")
    public List<ZpoV2InfantOphtResults> getZpoV2InfantOphtResultstByUser(String username){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2InfantOphtResults zpoIOR where zpoIOR.pasive = '0' and zpoIOR.recordId in (select zpo00.recordId from ZpoInfantData zpo00 where zpo00.pasive = '0')");
        //query.setParameter("usuarioactual",username);
        return query.list();
    }

    /**
     * Guardar un formulario ZpoV2InfantOphtResults
     * @param zpoV2InfantOphtResults a guardar
     */
    public void saveZpoV2InfantOphtResults(ZpoV2InfantOphtResults zpoV2InfantOphtResults){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoV2InfantOphtResults);
    }
}
