package src.com.hibernate.demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import src.com.HibernateDemoConfig;
import src.com.hibernate.demo.entity.Student;
import src.com.hibernate.demo.service.DBSession;

import static org.junit.Assert.*;

public class DBStudentTest {
    private AnnotationConfigApplicationContext context;
    private DBSession session;
    private Student student;

    @Before
    public void setUp(){
        context = new AnnotationConfigApplicationContext(HibernateDemoConfig.class);
        session = context.getBean("getSession", DBSession.class);
        student = new Student("Joao", "das couves", "joao@bol.com.br");

    }
    @Test
    public void testCreate(){
        try {
            int id = addStudent(student);
            assertFalse(id == 0);
        }catch (Exception e){
            fail();
        }
    }
    @Test
    public void testGet(){
        try {
            int id = addStudent(student);
            Student resquestedStudent = (Student) session.getObject(id);
            assertEquals(resquestedStudent, student);
        }catch (Exception e){
            fail();
        }

    }
    @Test
    public void testUpdate(){
        try{
            int id = addStudent(student);
            String newLastName = "das alfaces";
            student.setLastName(newLastName);
            session.updateObject(student);
            assertEquals(((Student) session.getObject(id)).getLastName(), newLastName);
        }catch (Exception e){
            fail();
        }
    }

    @Test
    public void testDelete(){
        try{
            int id = addStudent(student);
            session.deleteObject(id);
            assertEquals(null, session.getObject(id));
        }catch (Exception e){
            fail();
        }
    }

    private int addStudent(Student student){
        session.addObject(student);
        return student.getId();
    }
}
