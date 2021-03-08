package console.app.service;

import console.app.dao.DepartmentDao;
import console.app.dto.DepartmentStatisticDto;
import console.app.excention.DataProcessingException;
import console.app.model.Department;
import console.app.model.Lecturer;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDao departmentDao;

    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public DepartmentStatisticDto getDepartmentStatisticDto(String departmentName) {
        DepartmentStatisticDto departmentStatisticDto = new DepartmentStatisticDto();
        departmentStatisticDto.setDepartment(departmentDao.findByName(departmentName)
                .orElseThrow(() ->new RuntimeException("We don't have department "+ departmentName)));
        departmentStatisticDto.setMapStatistic(departmentDao
                .getDepartmentStatistic(departmentName));
        return departmentStatisticDto;
    }

    @Override
    public int getCountOfEmployee(String departmentName) {
        return Math.toIntExact(departmentDao.getCountOfEmployee(departmentName));
    }

    @Override
    public double getAverageSalaryForDepartment(String departmentName) {
        return departmentDao.getAverageSalaryForDepartment(departmentName);
    }

    @Override
    public Lecturer getHeadOfDepartment(String departmentName) {
        return departmentDao.findByName(departmentName).get().getHeadOfDepartment();
    }

    @Override
    public Department add(Department department) {
        return departmentDao.add(department);
    }
}
