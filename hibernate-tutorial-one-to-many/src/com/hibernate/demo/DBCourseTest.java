package src.com.hibernate.demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import src.com.hibernate.demo.entity.Course;
import src.com.hibernate.demo.entity.Instructor;
import src.com.hibernate.demo.entity.InstructorDetail;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DBCourseTest {
    private DBSession session;
    private Instructor instructor;
    private InstructorDetail instructorDetail;
    private List<Course> courses;


    @Before
    public void setUp(){
        session = new AnnotationConfigApplicationContext(HibernateDemoConfig.class)
                .getBean("getSession", DBSession.class);
        instructor = new Instructor("Pablo", "Do arrocha", "homemnaochora@bol.com.br");
        courses = Arrays.asList(new Course("inglês", instructor), new Course("espanhol", instructor));
        instructorDetail = new InstructorDetail("Pablo do Arrocha Vevo", "sofrer");
        instructor.setInstructorDetail(instructorDetail);
        instructor.setCourses(courses);
        instructorDetail.setInstructor(instructor);
    }

    @Test
    public void addCourse(){
        session.addObject(instructor);
        assertEquals(instructor, session.getObject(instructor.getId(), Instructor.class));
        session.addObject(courses.get(0));
        assertEquals(courses.get(0), session.getObject(courses.get(0).getId(), Course.class));
    }



}
