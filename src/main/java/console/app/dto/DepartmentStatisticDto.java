package console.app.dto;

import console.app.model.Degree;
import console.app.model.Department;
import java.util.Map;
import lombok.Data;

@Data
public class DepartmentStatisticDto {
    private Department department;
    private Map<Degree, Double> mapStatistic;
}
