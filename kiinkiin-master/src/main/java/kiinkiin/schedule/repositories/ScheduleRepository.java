package kiinkiin.schedule.repositories;

import kiinkiin.schedule.models.Schedule;
import kiinkiin.schedule.repositories.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleRepository implements Repository {

    private Connection conn;
    private PreparedStatement preparedStatement;
    private ResultSet result;

    public ScheduleRepository() throws SQLException {
        this.conn = DatabaseConnection.getConnection();
    }

    @Override
    public Object get(int id) {
        try{
            preparedStatement = conn.prepareStatement("SELECT * FROM schedule WHERE fk_idEmployee=?");
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            return new Schedule(
                    result.getInt("Monday"),
                    result.getInt("Tuesday"),
                    result.getInt("Wednesday"),
                    result.getInt("Thursday"),
                    result.getInt("Friday"),
                    result.getInt("Saturday"),
                    result.getInt("Sunday"),
                    result.getInt("fk_idEmployee"));

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }    }

    @Override
    public ArrayList<Schedule> getAll() {
        ArrayList<Schedule> schedules = new ArrayList<>();
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM schedule");
            result = preparedStatement.executeQuery();

            while(result.next()){
                schedules.add(new Schedule(
                        result.getInt("Monday"),
                        result.getInt("Tuesday"),
                        result.getInt("Wednesday"),
                        result.getInt("Thursday"),
                        result.getInt("Friday"),
                        result.getInt("Saturday"),
                        result.getInt("Sunday"),
                        result.getInt("fk_idEmployee")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public void update(Object object) {
    }

    @Override
    public void create(Object object) {

    }
}
