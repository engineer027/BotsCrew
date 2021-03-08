package console.app.dao;

import console.app.model.Degree;
import console.app.model.Department;
import java.util.Map;
import java.util.Optional;

public interface DepartmentDao {
    public Department add(Department department);

    Map<Degree, Double> getDepartmentStatistic(String departmentName);

    Long getCountOfEmployee(String departmentName);

    Double getAverageSalaryForDepartment(String departmentName);

    Optional<Department> findByName(String departmentName);
}
