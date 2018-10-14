package mkswami.crud.HibernateCRUDOpt.dao;

import mkswami.crud.HibernateCRUDOpt.pojo.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentDao extends CrudRepository<Student,Long> {
    Student findByUuid(@Param("uuid") String uuid);

}
