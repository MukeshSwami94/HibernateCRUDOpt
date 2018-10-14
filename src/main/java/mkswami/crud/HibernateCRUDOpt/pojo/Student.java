package mkswami.crud.HibernateCRUDOpt.pojo;

import  javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @Basic(optional = false)
    @Column(name = "uuid")
    protected String uuid = UUID.randomUUID().toString();

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private  int age;

    @Column(name = "marks")
    private long marks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getMarks() {
        return marks;
    }

    public void setMarks(long marks) {
        this.marks = marks;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
