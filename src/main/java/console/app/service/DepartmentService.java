package console.app.service;

import console.app.dto.DepartmentStatisticDto;
import console.app.model.Department;
import console.app.model.Lecturer;

public interface DepartmentService {
    DepartmentStatisticDto getDepartmentStatisticDto(String departmentName);

    int getCountOfEmployee(String departmentName);

    double getAverageSalaryForDepartment(String departmentName);

    Lecturer getHeadOfDepartment(String departmentName);

    Department add(Department department);
}
