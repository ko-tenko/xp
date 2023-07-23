package commondb.dao;


public interface ICommonDAO<T> {

    T getById(int id);

    void remove(int id);
}
