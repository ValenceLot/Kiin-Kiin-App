package kiinkiin.schedule.repositories;


import java.util.ArrayList;

public interface Repository <T> {

    T get(int id);

    ArrayList<T> getAll();

    void delete(T object);

    void update(T object);

    void create(T object);

}
