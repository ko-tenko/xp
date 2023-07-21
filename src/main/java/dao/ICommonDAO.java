package dao;

import models.PersonCarModel;


public interface ICommonDAO<T> {

    PersonCarModel getById(int id);

    void remove(int id);
}
