package src.com.hibernate.demo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="student")
public class Student{


    @Id
    @Column(name="id")
    //if it doesn't explicit configured, that's the default behavior
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    public Student(){}

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object that) {
        return (that.getClass() == Student.class && this.id == ((Student) that).getId() &&
                Objects.equals(this.firstName, ((Student) that).getFirstName()) &&
                this.lastName.equals(((Student) that).getLastName()) &&
                this.email.equals(((Student) that).getEmail()));
    }
}
