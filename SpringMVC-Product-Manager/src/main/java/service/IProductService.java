package service;

import model.Product;

import java.util.List;

public interface IProductService extends BaseService<Product>{
    public List<Product> findAllByCategory(int id);
}
