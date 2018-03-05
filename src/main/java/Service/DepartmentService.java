package Service;

import Entity.Degree;
import Entity.Lector;
import dao.DepartmentDao;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentService {

    private DepartmentDao dao = new DepartmentDao();

    public String getDepartmentStatistic(String department) {
        List<Degree> lectorsDegree = dao.getAllLectors(department).stream().map(Lector::getDegree).collect(Collectors.toList());
        long assistants = lectorsDegree.stream().filter(k -> k == Degree.ASSISTANT).count();
        long associateProfessors = lectorsDegree.stream().filter(k -> k == Degree.ASOCIATE_PROFESSOR).count();
        long professors = lectorsDegree.stream().filter(k -> k == Degree.PROFESSOR).count();

        return "assistants - " + assistants + "\n" +
                "associate professors - " + associateProfessors + "\n" +
                "professors - " + professors;
    }

    public String getTheHeadOfTheDepartment(String department) {
        return dao.getTheHeadOfTheDepartment(department);
    }
    public int getAverangeSalary(String department){
        return (int) dao.getAllLectors(department).stream().mapToInt(Lector::getSalary).average().getAsDouble();
    }

    public int getCountOfEmployee(String department) {
        return dao.getAllLectors(department).size();
    }
}
