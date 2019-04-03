package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoV2EdadesEtapas;
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

@Service("zpoV2EdadesEtapasService")
@Transactional
public class ZpoV2EdadesEtapasService {


    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoV2EdadesEtapas
     * @return una lista de ZpoV2EdadesEtapas
     */
    public List<ZpoV2EdadesEtapas> getZpoV2EdadesEtapas(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ZpoV2EdadesEtapas where pasive = '0'");
        return query.list();
    }

    /**
     * Guardar un formulario ZpoV2EdadesEtapas
     * @param info a guardar
     */
    public void saverOrUpdateZpoV2EdadesEtapas(ZpoV2EdadesEtapas info){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(info);
    }

}
