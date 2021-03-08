package console.app.console;

import console.app.service.DepartmentService;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class AverageSalaryForDepartmentCommandImpl implements Command {
    private final DepartmentService departmentService;

    public AverageSalaryForDepartmentCommandImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter name of department: ");
        String nameDepartment = scanner.nextLine();
        double averageSalaryForDepartment = departmentService
                .getAverageSalaryForDepartment(nameDepartment);
        System.out.println("The average salary for " + nameDepartment + " department statistic: "
                + averageSalaryForDepartment);
    }
}
