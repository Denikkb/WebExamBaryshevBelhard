package com.baryshev.WebExamBaryshevBelhard.Service;

import com.baryshev.WebExamBaryshevBelhard.DAO.ProductDAO;
import com.baryshev.WebExamBaryshevBelhard.DTO.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }



    @Override
    public List<ProductDto> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public ProductDto getProductById(int id) {
        return productDAO.getProductById(id);
    }

    @Override
    public void save(ProductDto productDto) {
        productDAO.save(productDto);
    }

    @Override
    public void update(int id, ProductDto updateProductDto) {
        productDAO.update(id, updateProductDto);
    }

    @Override
    public void delete(int id) {
        productDAO.delete(id);
    }


}
