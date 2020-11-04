package service;

import model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryService implements BaseService<Category>{
    private static Map<Integer, Category> categories;

    static {

        categories = new HashMap<>();
        categories.put(1, new Category(1, "Train"));
        categories.put(2, new Category(2, "Car"));
        categories.put(3, new Category(3, "Bicycle"));
        categories.put(4, new Category(4, "Truck"));
    }

    @Override
    public void add(Category category) {
        categories.put(category.getId(), category);
    }

    @Override
    public void delete(Category category) {
        categories.remove(category.getId());
    }

    @Override
    public void update(Category category) {
        categories.put(category.getId(), category);
    }

    @Override
    public Category selectById(int id) {
        return categories.get(id);
    }

    @Override
    public List findAll() {
        return new ArrayList<>(categories.values());
    }
}