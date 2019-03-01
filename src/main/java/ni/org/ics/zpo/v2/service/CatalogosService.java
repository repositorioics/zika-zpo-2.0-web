package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.catalogs.AppointmentType;
import ni.org.ics.zpo.v2.domain.catalogs.Cs;
import ni.org.ics.zpo.v2.domain.catalogs.Provider;
import ni.org.ics.zpo.v2.domain.catalogs.Speciality;
import ni.org.ics.zpo.v2.domain.catalogs.SubjectType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("catalogosService")
@Transactional
public class CatalogosService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Cs> getCss(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Cs");
        return query.list();
    }
    

    public Cs getCs(String cs){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Cs c where c.cs=:cs");
        query.setParameter("cs", cs);
        return (Cs) query.uniqueResult();
    }
    
    public void saveCs(Cs center){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(center);
    }
    
    @SuppressWarnings("unchecked")
    public List<SubjectType> getSubjectTypes(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM SubjectType");
        return query.list();
    }
    
    public void saveSubjectType(SubjectType subject){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(subject);
    }
    
    @SuppressWarnings("unchecked")
    public List<AppointmentType> getAppointmentTypes(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM AppointmentType");
        return query.list();
    }
    
    public void saveAppointmentType(AppointmentType appointmentType){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(appointmentType);
    }
    
    @SuppressWarnings("unchecked")
    public List<Speciality> getSpecialities(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Speciality");
        return query.list();
    }
    
    public Speciality getSpeciality(String speciality){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Speciality s where s.speciality=:speciality");
        query.setParameter("speciality", speciality);
        return (Speciality) query.uniqueResult();
    }
    
    public void saveSpeciality(Speciality speciality){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(speciality);
    }
    
    @SuppressWarnings("unchecked")
    public List<Provider> getProviders(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Provider");
        return query.list();
    }
    

    public Provider getProvider(String id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Provider p where p.id=:id");
        query.setParameter("id", id);
        return (Provider) query.uniqueResult();
    }
    
    public void saveProvider(Provider provider){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(provider);
    }
}
