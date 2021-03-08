package console.app.util;

import console.app.model.Degree;
import console.app.model.Department;
import console.app.model.Lecturer;
import console.app.service.DepartmentService;
import console.app.service.LecturerService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInject {
    private final DepartmentService departmentService;
    private final LecturerService lecturerService;

    public DataInject(DepartmentService departmentService,
                      LecturerService lecturerService) {
        this.departmentService = departmentService;
        this.lecturerService = lecturerService;
    }

    @PostConstruct
    public void add() {
        Lecturer einstein = new Lecturer();
        einstein.setLastname("Einstein");
        einstein.setSurname("Albert");
        einstein.setSalary(2000);
        einstein.setDegree(Degree.PROFESSOR);
        lecturerService.add(einstein);

        Lecturer tesla = new Lecturer();
        tesla.setDegree(Degree.ASSOCIATE_PROFESSOR);
        tesla.setSurname("Nikola");
        tesla.setLastname("Tesla");
        tesla.setSalary(1500);
        lecturerService.add(tesla);

        Lecturer edison = new Lecturer();
        edison.setDegree(Degree.ASSISTANT);
        edison.setSalary(1000);
        edison.setSurname("Thomas");
        edison.setLastname("Edison");
        lecturerService.add(edison);

        Department physics = new Department();
        physics.setLecturers(List.of(edison, tesla, einstein));
        physics.setName("Physics");
        physics.setHeadOfDepartment(edison);
        departmentService.add(physics);

        Department mathematics = new Department();
        mathematics.setLecturers(List.of(tesla, einstein));
        mathematics.setName("Mathematics");
        mathematics.setHeadOfDepartment(einstein);
        departmentService.add(mathematics);
    }
}
