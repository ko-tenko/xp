package db.dao;


public interface ICommonDAO<T> {

    T getById(int id);

    void remove(int id);
}
