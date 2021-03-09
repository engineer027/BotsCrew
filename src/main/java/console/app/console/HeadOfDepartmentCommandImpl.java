package console.app.console;

import console.app.model.Lecturer;
import console.app.service.DepartmentService;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class HeadOfDepartmentCommandImpl implements Command {
    private final DepartmentService departmentService;

    public HeadOfDepartmentCommandImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter name of department: ");
        String nameDepartment = scanner.nextLine();
        Lecturer headOfDepartment = departmentService.getHeadOfDepartment(nameDepartment);
        System.out.println("The head of "
                + nameDepartment + " department: "
                + headOfDepartment.getSurname() + " "
                + headOfDepartment.getLastname());
    }
}
