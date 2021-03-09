package console.app.console;

import console.app.service.DepartmentService;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class CountOfEmployeeCommandImpl implements Command {
    private final DepartmentService departmentService;

    public CountOfEmployeeCommandImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter name of department: ");
        String nameDepartment = scanner.nextLine();
        int countOfEmployee = departmentService.getCountOfEmployee(nameDepartment);
        System.out.println("The count of employee " + nameDepartment + " department statistic: "
                + countOfEmployee);
    }
}
