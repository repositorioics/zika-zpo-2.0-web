package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoV2RecoleccionMuestra;
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
@Service("zpoV2RecoleccionMuestraService")
@Transactional
public class ZpoV2RecoleccionMuestraService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoV2RecoleccionMuestra
     * @return una lista de ZpoV2RecoleccionMuestra
     */
    public List<ZpoV2RecoleccionMuestra> getMuestras(){
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("from ZpoV2RecoleccionMuestra  where pasive = '0'");
        return q.list();
    }

    /**
     * Guardar un formulario ZpoV2RecoleccionMuestra
     * @param muestra a guardar
     */
    public void saveOrUpdateMuestra(ZpoV2RecoleccionMuestra muestra){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(muestra);
    }
}
