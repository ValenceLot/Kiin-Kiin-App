package kiinkiin.schedule.repositories;

import kiinkiin.schedule.models.Manager;
import kiinkiin.schedule.repositories.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManagerRepository implements Repository {

    private Connection conn;
    private PreparedStatement preparedStatement;
    private ResultSet result;

    public ManagerRepository() throws SQLException {
        this.conn = DatabaseConnection.getConnection();
    }


    @Override
    public Object get(int id) {
        try{
            preparedStatement = conn.prepareStatement("SELECT * FROM manager WHERE managerId=?");
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            return new Manager(
                    result.getInt("managerId"),
                    result.getString("Name"),
                    result.getString("Username"),
                    result.getString("Password"),
                    result.getString("Cpr"),
                    result.getString("Position"));


        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList getAll() {
        ArrayList<Manager> manager = new ArrayList<>();
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM manager");
            result = preparedStatement.executeQuery();

            while(result.next()){
                manager.add(new Manager(result.getInt("managerId"),result.getString("fullName"), result.getString("username"),result.getString("password"), result.getString("cpr"), result.getString("position")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manager;
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
