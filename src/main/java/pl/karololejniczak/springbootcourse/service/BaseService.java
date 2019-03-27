package pl.karololejniczak.springbootcourse.service;

import java.util.List;

public interface BaseService<T> {
    //CRUD

    public void save (T t);

    public T read(int id);

    public T readall(List<Integer> list);

    public void update(T t);

    public void delete(T t);

    public void delete(int id);



}
