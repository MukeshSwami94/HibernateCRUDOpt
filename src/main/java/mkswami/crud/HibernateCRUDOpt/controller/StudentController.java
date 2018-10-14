package mkswami.crud.HibernateCRUDOpt.controller;

import mkswami.crud.HibernateCRUDOpt.bean.BeanStudent;
import mkswami.crud.HibernateCRUDOpt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {


    @Autowired
    StudentService studentService;


    @GetMapping(name = "/studentList")
    public String  listShow(Model model){
        try {
            model.addAttribute("studentList",studentService.getEntitysList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "studentList";
    }
    @GetMapping(value = "/addStudent")
    public String addEntity(Model model){
        model.addAttribute("beanStudent",new BeanStudent());
        return "addEditStudent";
    }

    @GetMapping(value = "/editStudent/{uuid}")
    public String editStudent(Model model, @PathVariable String uuid){
        try {
            model.addAttribute("beanStudent",studentService.getStudnetByUuid(uuid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "addEditStudent";
    }

    @PostMapping(value = "/addEditStudent")
    public String addEntityPost(Model model, @ModelAttribute BeanStudent beanStudent){
        System.out.println("StudentController.addEntityPost");
        if(beanStudent.getUuid().equals("")){
            studentService.saveEntity(beanStudent);
            return  "redirect:/studentList";

        }else{
            studentService.updateEntity(beanStudent);
            return  "redirect:/studentList";
        }
    }
    @GetMapping(value = "/deleteStudent/{uuid}")
    public String deleteStudent(Model model, @PathVariable String uuid){
        try {
            studentService.deleteStudent(uuid);
        } catch (Exception e) {
            e.printStackTrace();

        }

        return "redirect:/studentList";
    }



}
