package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoVisitaFallida;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Miguel Salinas on 11/29/2017.
 * V1.0
 */
@Service("zpoVisitaFallidaService")
@Transactional
public class ZpoVisitaFallidaService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public List<ZpoVisitaFallida> getZpoVisitasFallidas(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ZpoVisitaFallida");
        return query.list();
    }

    /**
     * Guardar un formulario ZpoVisitaFallida
     * @param zpoVisitaFallida a guardar
     */
    public void saveZpoVisitaFallida(ZpoVisitaFallida zpoVisitaFallida){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoVisitaFallida);
    }
}
