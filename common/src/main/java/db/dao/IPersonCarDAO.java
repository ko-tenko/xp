package db.dao;

import db.models.PersonCar;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.customizer.Bind;

import java.util.List;

public interface IPersonCarDAO extends ICommonDAO<PersonCar> {

    @SqlQuery("""
            SELECT *
              FROM personcars
              """)
    @RegisterBeanMapper(PersonCar.class)
    List<PersonCar> getAll();

    @SqlQuery("""
            SELECT *
              FROM personcars
             WHERE person_id = :id
             """)
    @RegisterBeanMapper(PersonCar.class)
    PersonCar getById(@Bind("id") int id);
}