import Service.DepartmentService;
import Service.LectorService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        DepartmentService departmentService = new DepartmentService();
        LectorService lectorService = new LectorService();

        String commands = "1 - Who is head of department {department_name}\n"
                +"2 - Show {department_name} statistic\n"
                +"3 - Show the average salary for department {department_name}\n"
                +"4 - Show count of employee for {department_name}\n"
                +"5 - Global search by {template}\n"
                +"0 - Stop the program";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean shouldStop = false;
            System.out.println(commands);
            while (!shouldStop){
                int selectedCommand = Integer.parseInt(reader.readLine());
                switch (selectedCommand){
                    case 1: {
                        System.out.println("Enter department name");
                        System.out.println(departmentService.getTheHeadOfTheDepartment(reader.readLine()));
                        break;
                    }
                    case 2:{
                        System.out.println("Enter department name");
                        System.out.println(departmentService.getDepartmentStatistic(reader.readLine()));
                        break;
                    }
                    case 3:{
                        System.out.println("Enter department name");
                        System.out.println(departmentService.getAverangeSalary(reader.readLine()));
                        break;
                    }
                    case 4:{
                        System.out.println("Enter department name");
                        System.out.println(departmentService.getCountOfEmployee(reader.readLine()));
                        break;
                    }
                    case 5:{
                        System.out.println("Enter search word");
                        System.out.println(lectorService.getLectorsBySearhString(reader.readLine()));
                        break;
                    }
                    case 0:{
                        shouldStop = true;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
