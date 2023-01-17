package src.com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
            throw new RuntimeException("Student with id = " + id + " not found");
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
        beginTransaction();
        try {
            session.createQuery("delete from Student s where s.id="+id).executeUpdate();
            session.getTransaction().commit();
        }catch (Exception e){
            throw new RuntimeException("unable to update");
        }
    }

    private void beginTransaction(){
        session = factory.getCurrentSession();
        session.beginTransaction();
    }

    public void clearTable(){
        beginTransaction();
        try{
            session.createQuery("delete from Student").executeUpdate();
            session.getTransaction().commit();
        }catch (Exception e){ throw new RuntimeException(e);}

    }
}
