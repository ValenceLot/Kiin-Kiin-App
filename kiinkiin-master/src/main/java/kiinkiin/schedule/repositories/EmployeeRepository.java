package kiinkiin.schedule.repositories;

import kiinkiin.schedule.models.Employee;
import kiinkiin.schedule.models.Schedule;
import kiinkiin.schedule.repositories.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeRepository implements Repository<Employee> {

    private Connection conn;
    private PreparedStatement preparedStatement;
    private ResultSet result;

    public EmployeeRepository() throws SQLException {
        this.conn = DatabaseConnection.getConnection();
    }

    @Override
    public Employee get(int id) {
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM employees WHERE employeeId=?");
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            return new Employee(
                    result.getInt("employeeId"),
                    result.getString("fullName"),
                    result.getString("username"),
                    result.getString("password"),
                    result.getString("cpr"),
                    result.getString("position"),
                    result.getString("email"),
                    result.getString("bankAccount"),
                    result.getString("address"),
                    result.getString("postcode"),
                    result.getString("city"),
                    result.getString("country"),
                    result.getString("gender"),
                    result.getString("phoneNumber"));


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Employee> getAll() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM employees");
            result = preparedStatement.executeQuery();

            while (result.next()) {
                employees.add(new Employee(result.getInt("employeeId"), result.getString("fullName"), result.getString("username"), result.getString("password"), result.getString("cpr"), result.getString("position"), result.getString("email"), result.getString("bankAccount"),
                        result.getString("address"), result.getString("postcode"), result.getString("city"), result.getString("country"), result.getString("gender"), result.getString("phoneNumber")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void delete(Employee object) {

    }

    @Override
    public void update(Employee object) {
        try {

            preparedStatement = conn.prepareStatement("UPDATE employees SET fullName = ? where employeeId = ?");
            preparedStatement.setString(1,object.getName());
            preparedStatement.setInt(2,object.getEmployeeId());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Employee object) {

    }

}
