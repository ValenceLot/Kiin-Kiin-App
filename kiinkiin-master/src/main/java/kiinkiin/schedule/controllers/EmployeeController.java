package kiinkiin.schedule.controllers;

import kiinkiin.schedule.models.Employee;
import kiinkiin.schedule.models.Schedule;
import kiinkiin.schedule.repositories.EmployeeRepository;
import kiinkiin.schedule.repositories.Repository;
import kiinkiin.schedule.repositories.ScheduleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class EmployeeController {

    private Repository<Employee> employeeRepository;
    private Employee currentEmployee;
    private Repository<Schedule> scheduleRepository;

    public EmployeeController() throws SQLException {
        employeeRepository = new EmployeeRepository();
        scheduleRepository = new ScheduleRepository();
    }


    @GetMapping("employee/loginEmployee")
    public String login() {
        return "employee/loginEmployee";
    }

    @PostMapping("employee/loginEmployee")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        ArrayList<Employee> employees = employeeRepository.getAll();
        for (Employee epl : employees) {
            if (epl.getUsername().equals(username) && epl.getPassword().equals(password)) {
                currentEmployee = epl;
                return "redirect:/employee/scheduleTable";
            }
        }
        return "employee/loginEmployee";
    }

    @GetMapping("/employee/scheduleTable")
    public String scheduleTable(Model model) {
        ArrayList<Employee> employees = employeeRepository.getAll();
        ArrayList<Schedule> schedule = scheduleRepository.getAll();
        System.out.println(employees.size());

        for (int i = 0; i < employees.size(); i++) {
            for(int j = 0; j < schedule.size(); j++)
                if (employees.get(i).getEmployeeId() == schedule.get(j).getEmployeeId())
                    employees.get(i).addShifts(schedule.get(j));
        }
        System.out.println(employees.get(1).toString());

        model.addAttribute("employees", employees);
        return "employee/scheduleTable";
    }

    @PostMapping("/employee/scheduleTable")
    public String scheduleTable(Model model, @ModelAttribute("employee") Employee employee) {
        model.addAttribute("employees", employeeRepository.getAll());

        return "employees/scheduleTable";
    }
}




