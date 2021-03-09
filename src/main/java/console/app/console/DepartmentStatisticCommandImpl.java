package console.app.console;

import console.app.dto.DepartmentStatisticDto;
import console.app.model.Degree;
import console.app.service.DepartmentService;
import java.util.Map;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class DepartmentStatisticCommandImpl implements Command {
    private final DepartmentService departmentService;

    public DepartmentStatisticCommandImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter name of department: ");
        String nameDepartment = scanner.nextLine();
        DepartmentStatisticDto departmentStatisticDto = departmentService
                .getDepartmentStatisticDto(nameDepartment);
        Map<Degree, Double> mapStatistic = departmentStatisticDto.getMapStatistic();
        System.out.println("The " + nameDepartment + " department statistic: ");
        for (Map.Entry<Degree, Double> entry: mapStatistic.entrySet()) {
            System.out.println(entry.getKey().toString() + ": " + entry.getValue().toString());
        }
    }
}
