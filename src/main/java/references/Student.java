package references;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Student {

    private static final Logger logger = LoggerFactory.getLogger(Student.class.getName());

    private long id;
    private String name;

    public Student() {
        super();
    }

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(Student student) {
        this(student.id, student.name);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
