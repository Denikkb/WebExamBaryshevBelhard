package com.baryshev.WebExamBaryshevBelhard.DAO;

import com.baryshev.WebExamBaryshevBelhard.DTO.ProductDto;

import java.util.List;

public interface ProductDAO {
    List<ProductDto> getAllProducts ();
    ProductDto getProductById (int id);
    void save (ProductDto productDto);
    void update (int id, ProductDto updateProductDto);
    void delete (int id);


}
