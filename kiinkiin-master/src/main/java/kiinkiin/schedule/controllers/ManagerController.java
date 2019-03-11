package kiinkiin.schedule.controllers;

import kiinkiin.schedule.models.Employee;
import kiinkiin.schedule.models.Manager;
import kiinkiin.schedule.models.Schedule;
import kiinkiin.schedule.repositories.EmployeeRepository;
import kiinkiin.schedule.repositories.ManagerRepository;
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
public class ManagerController {

    private Repository<Manager> managerRepository;
    private Manager currentManager;
    private Repository<Employee> employeeRepository;
    private Repository<Schedule> scheduleRepository;

    public ManagerController() throws SQLException {
        managerRepository = new ManagerRepository();
        employeeRepository = new EmployeeRepository();
        scheduleRepository = new ScheduleRepository();
    }
    @GetMapping("manager/loginManager")
    public String login(){
        return "manager/loginManager";
    }

    @PostMapping("manager/loginManager")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        ArrayList<Manager> managers = managerRepository.getAll();
        for (Manager man : managers) {
            if (man.getUsername().equals(username) && man.getPassword().equals(password)) {
                currentManager = man;
                return "redirect:/manager/schedule";
            }
        }
        return "manager/loginManager";
    }

    @GetMapping("/manager/schedule")
    public String scheduleTable(Model model){

        ArrayList<Employee> employees = employeeRepository.getAll();
        ArrayList<Schedule> schedule = scheduleRepository.getAll();

        for (int i = 0; i < employees.size(); i++) {
            for(int j = 0; j < schedule.size(); j++)
                if (employees.get(i).getEmployeeId() == schedule.get(j).getEmployeeId())
                    employees.get(i).addShifts(schedule.get(j));
        }
        model.addAttribute("employees", employees);
        return "manager/schedule";
    }

    @GetMapping("/manager/updateSchedule")
    public String updateSchedule(@RequestParam("id") int employeeId, Model model){

        Employee employee = employeeRepository.get(employeeId);
        model.addAttribute("employee", employee);

        return "manager/updateSchedule";
    }

    @PostMapping("/manager/updateSchedule")
    public String scheduleTable(@ModelAttribute Employee employee){

        System.out.println(employee);
        employeeRepository.update(employee);
        System.out.println(employee);
        return "redirect:/manager/schedule";
    }

    @GetMapping("/manager/employeesList")
    public String employeesList(Model model){
        model.addAttribute("employees", employeeRepository.getAll());

        return "manager/employeesList";
    }

    @GetMapping("/manager/employeeDetails")
    public String employeeDetails(@RequestParam("id") int employeeId, Model model){
        System.out.println(employeeRepository.get(employeeId));
        model.addAttribute("employee",  employeeRepository.get(employeeId));
        return "manager/employeeDetails";
    }
}

