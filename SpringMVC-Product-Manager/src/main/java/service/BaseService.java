package service;

import java.util.List;

public interface BaseService<T> {

    public List<T> findAll();

    public void add(T t);

    public void delete(T t);

    public void update(T t);

    public T selectById(int id);
}
