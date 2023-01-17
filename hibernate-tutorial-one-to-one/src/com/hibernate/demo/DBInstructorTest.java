package src.com.hibernate.demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import src.com.hibernate.demo.entity.Instructor;
import src.com.hibernate.demo.entity.InstructorDetail;
import src.com.hibernate.demo.entity.Student;

import static org.junit.Assert.*;

public class DBInstructorTest {
    private AnnotationConfigApplicationContext context;
    private DBSession session;
    private Instructor instructor;
    private InstructorDetail instructorDetail;
    @Before
    public void setUp(){
        context = new AnnotationConfigApplicationContext(HibernateDemoConfig.class);
        session = context.getBean("getSession", DBSession.class);
        instructor = new Instructor("Joao", "das couves", "joao@bol.com.br");
        instructorDetail = new InstructorDetail("joaozinho gameplays", "reclamar de " +
                "menina de cabelo azul");
        instructor.setInstructorDetail(instructorDetail);
    }
    @Test
    public void testCreate(){
        try {
            int id = addInstructor(instructor);
            assertFalse(id == 0);
        }catch (Exception e){
            fail();
        }
    }
    @Test
    public void testGet(){
        try {
            int id = addInstructor(instructor);
            Student resquestedStudent = (Student) session.getObject(id);
            assertEquals(resquestedStudent, instructor);
        }catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testGetByInstructorDetail(){
        try {
            int id = addInstructor(instructor);
            Instructor resquestedInstructor = (Instructor) session.getByInstructorDetail(id);
            assertEquals(resquestedInstructor, instructor);
        }catch (Exception e) {
            fail();
        }
    }
    @Test
    public void testUpdate(){
        try{
            int id = addInstructor(instructor);
            String newLastName = "das alfaces";
            instructor.setLastName(newLastName);
            session.updateObject(instructor);
            assertEquals(((Student) session.getObject(id)).getLastName(), newLastName);
        }catch (Exception e){
            fail();
        }
    }

    @Test
    public void testDelete(){
        try{
            int id = addInstructor(instructor);
            session.deleteObject(id);
            assertNull(session.getObject(id));
        }catch (Exception e){
            fail();
        }
    }

    @Test
    public void testeDeletByInstructorDetail(){
        try{
            int id = addInstructor(instructor);
            InstructorDetail instructorDetail = ((Instructor)session.getObject(id)).getInstructorDetail();
            session.deleteByInstructorDetail(instructorDetail.getId());
            assertNull(session.getObject(id));
        }catch (Exception e){
            fail();
        }
    }

    private int addInstructor(Instructor instructor){
        session.addObject(instructor);
        return instructor.getId();
    }
}
