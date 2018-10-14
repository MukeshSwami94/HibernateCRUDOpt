package mkswami.crud.HibernateCRUDOpt.service;

import mkswami.crud.HibernateCRUDOpt.bean.BeanStudent;
import mkswami.crud.HibernateCRUDOpt.dao.StudentDao;
import mkswami.crud.HibernateCRUDOpt.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Component
@Service("studentService ")
public class StudentService {
    @Autowired
    protected StudentDao studentDao;

    public  BeanStudent getStudnetByUuid(String uuid) throws Exception {
        try{
            Student student =studentDao.findByUuid(uuid);
            if(student != null){
                BeanStudent beanStudent = new BeanStudent();
                beanStudent.setUuid(student.getUuid());
                beanStudent.setName(student.getName());
                beanStudent.setAge(student.getAge());
                beanStudent.setMarks(student.getMarks());
                return beanStudent;
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    return null;
    }

    public void saveEntity(BeanStudent beanStudent) {
        Student student = new Student();
        student.setName(beanStudent.getName());
        student.setAge(beanStudent.getAge());
        student.setMarks(beanStudent.getMarks());
        studentDao.save(student);
    }

    public void updateEntity(BeanStudent beanStudent) {
        Student student = studentDao.findByUuid(beanStudent.getUuid());
        if (null != student) {
            student.setName(beanStudent.getName());
            student.setAge(beanStudent.getAge());
            student.setMarks(beanStudent.getMarks());
            studentDao.save(student);
        }
    }


    public ArrayList<BeanStudent> getEntitysList() throws Exception {
        try {
            ArrayList<BeanStudent> beanStudentArrayList = new ArrayList<>();
            Iterable<Student> studentIterable = studentDao.findAll();
            for (Student student : studentIterable) {
                BeanStudent beanStudent = new BeanStudent();
                beanStudent.setUuid(student.getUuid());
                beanStudent.setName(student.getName());
                beanStudent.setAge(student.getAge());
                beanStudent.setMarks(student.getMarks());
                beanStudentArrayList.add(beanStudent);
            }
            return beanStudentArrayList;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }

    }
    public void deleteStudent(String uuid) throws Exception {
        try {
            studentDao.delete(studentDao.findByUuid(uuid));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
