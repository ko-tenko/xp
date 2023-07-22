package dao;

import models.PersonCar;
import org.jdbi.v3.core.Handle;


public class PersonCarDAO implements ICommonDAO<PersonCar> {

    private final Handle handle;

//    @Override
//    public PersonCar getById(int id) {
//        String sql = "SELECT * FROM personcars WHERE person_id = :id";
//        return handle.createQuery(sql)
//                .bind("id", id)
//                .map((rs, ctx) -> new PersonCar(
//                        rs.getInt("person_id"),
//                        rs.getString("car_number"),
//                        rs.getString("car_name")))
//                .findOne()
//                .orElse(null);
//    }

    @Override
    public PersonCar getById(int id) {
        String sql = "SELECT * FROM personcars WHERE person_id = :id";

        return handle.createQuery(sql)
                .bind("id", id)
                .mapToBean(PersonCar.class)
                .findOne()
                .orElse(null);
    }

    @Override
    public void remove(int id) {

    }

    public PersonCarDAO(Handle handle) {
        this.handle = handle;
    }
}
