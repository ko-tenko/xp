package dao;

import models.PersonCarModel;
import org.jdbi.v3.core.Handle;


public class PersonCarDAO implements ICommonDAO<PersonCarModel> {

    private Handle handle;

    @Override
    public PersonCarModel getById(int id) {
        String sql = "SELECT * FROM personcars WHERE person_id = :id";

        return handle.createQuery(sql)
                .bind("id", id)
                .map((rs, ctx) -> new PersonCarModel(
                        rs.getInt("person_id"),
                        rs.getString("car_number"),
                        rs.getString("car_name")))
                .findOne()
                .orElse(null);
    }


//    @Override
//    public Map<String, Object> getById(int id) {
//        String sql = "SELECT * FROM personcars WHERE person_id = :id";
//
//        Query query = handle.createQuery(sql).bind("id", id);
//        PersonCarModel a = query.mapTo(PersonCarModel.class).findFirst().orElse(null);
//
//        // Execute the query and get the results as a map
//        return query.mapToMap().findFirst().orElse(null);

//        // Print the column names from the query result set
//        if (resultMap != null) {
//            System.out.println("entryset: " + resultMap.entrySet());
//            System.out.println("resultmap: " + resultMap);
//            System.out.println("Column Names: " + resultMap.keySet());
//        } else {
//            System.out.println("No results found.");
//        }
//
//        return query
//                .mapToBean(PersonCarModel.class)
//                .findFirst()
//                .orElse(null);
//    }

//    @Override
//    public PersonCars getById(int id) {
//        String sql = "SELECT * FROM personcars WHERE person_id = :id";
//
//        return handle.createQuery(sql)
//                .bind("id", id)
//                .mapToBean(PersonCars.class)
//                .findOne()
//                .orElse(null);
//    }

    @Override
    public void remove(int id) {

    }

    public PersonCarDAO(Handle handle) {
        this.handle = handle;
    }
}
