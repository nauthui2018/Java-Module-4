package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Toyota", 1000, 20,  "white", "Made in Japan", 2));
        products.put(2, new Product(2, "Giant", 500, 100,  "Grey", "Made in Indonesia", 1));
        products.put(3, new Product(3, "BMW", 2000, 120,  "Black", "Made in Germany", 2));
    }

    @Override
    public List<Product> findAllByCategory(int id) {
        ArrayList<Product> listValues = new ArrayList<>(products.values());
        ArrayList<Product> listByCategory = new ArrayList<>();
        for (Product item: listValues) {
            if (item.getCategoryID() == id) {
                listByCategory.add(item);
            }
        }
        return listByCategory;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void add(Product product) {
        products.put(product.getCode(), product);
    }

    @Override
    public void delete(Product product) {
        products.remove(product.getCode());
    }

    @Override
    public void update(Product product) {
        products.put(product.getCode(), product);
    }

    @Override
    public Product selectById(int id) {
        return products.get(id);
    }
}
