package src.com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import src.com.hibernate.demo.entity.InstructorDetail;

import javax.annotation.PreDestroy;
import java.io.Serializable;
import java.util.List;

public class DBSession<T> {

    @Autowired
    private SessionFactory factory;
    private Session session;
    private final Class<T> type;

    public DBSession(Class<T> type) {
        this.type = type;
    }

    public T getObject(int id){
        beginTransaction();
        try{
            return session.get(type, id);
        }catch (Exception e){
            throw new RuntimeException("Student with id = " + id + " not found\n"+e.getMessage());
        }finally {
            session.close();
        }
    }

    public InstructorDetail getInstructorDetail(int id){
        beginTransaction();
        try{
            return session.get(InstructorDetail.class, id);
        }catch (Exception e){
            throw new RuntimeException("Student with id = " + id + " not found\n"+e.getMessage());
        }finally {
            session.close();
        }
    }
    public void addObject(T object){
        beginTransaction();
        Serializable id;
        try{
            session.save(object);
            session.getTransaction().commit();
        }catch (Exception e){
            throw new RuntimeException("Unable to persist object " + object.toString());
        }finally {
            session.close();
        }
    }

    public List getAllObjects(){
        beginTransaction();
        try{
            return session.createQuery("from Student").getResultList();
        }catch (Exception e){
            throw new RuntimeException("Unable to run query");
        }finally {
            session.close();
        }
    }

    public void updateObject(T obj){
        beginTransaction();
        try {
            session.update(obj);
            session.getTransaction().commit();
        }catch (Exception e){
            throw new RuntimeException("unable to update");
        }
    }

    public void deleteObject(int id){
        T obj = getObject(id);
        beginTransaction();
        try {
            session.delete(obj);
            //session.createQuery("delete from instructor s where s.id="+id).executeUpdate();
            session.getTransaction().commit();
        }catch (Exception e){
            throw new RuntimeException("unable to update "+e.getMessage());
        }
    }

    public T getByInstructorDetail(int id){
        beginTransaction();
        try{
            return (T)session.get(InstructorDetail.class, id).getInstructor();
        }catch (Exception e){
            throw new RuntimeException("Student with id = " + id + " not found\n"+e.getMessage());
        }finally {
            session.close();
        }
    }

    private void beginTransaction(){
        session = factory.getCurrentSession();
        session.beginTransaction();
    }

    public void clearTable(){
        beginTransaction();
        try{
            session.createQuery("delete from Instructor").executeUpdate();
            session.getTransaction().commit();
        }catch (Exception e){ throw new RuntimeException(e);}

    }

    public void deleteByInstructorDetail(int id) {
        InstructorDetail instructorDetail = getInstructorDetail(id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        updateObject((T)instructorDetail.getInstructor());
        beginTransaction();
        try {
            session.delete(instructorDetail);
            session.getTransaction().commit();

        }catch (Exception e){ throw new RuntimeException(e);}
    }
    @PreDestroy
    public void close(){
        System.out.println("close session");
        if(session != null) session.close();
    }
}
