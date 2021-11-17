package com.baryshev.WebExamBaryshevBelhard.DAO;

import com.baryshev.WebExamBaryshevBelhard.DTO.ProductDto;
import com.baryshev.WebExamBaryshevBelhard.rowMapper.ProductPowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImp implements ProductDAO{

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private String GET_ALL_PRODUCTS = "SELECT * FROM Products";
    private String GET_PRODUCT_BY_ID = "SELECT * FROM Products WHERE id = :id";
    private String SAVE = "INSERT INTO Products( NameProduct, Price, Quantity) VALUES (:NameProduct, :Price, :Quantity)";
    private String UPDATE = "UPDATE Products SET NameProduct=:NameProduct, Price=:Price, Quantity=:Quantity   WHERE Id=:Id";
    private String DELETE = "DELETE FROM Products WHERE Id=:Id";

    @Autowired
    public ProductDaoImp(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return namedParameterJdbcTemplate.query(GET_ALL_PRODUCTS, new ProductPowMapper());
    }

    @Override
    public ProductDto getProductById(int id) {

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcTemplate.queryForObject(GET_PRODUCT_BY_ID, params, new ProductPowMapper());
    }

    @Override
    public void save(ProductDto productDto) {

        Map<String, Object> params = new HashMap<>();

        params.put("NameProduct", productDto.getNameProduct());
        params.put("Price", productDto.getPrice());
        params.put("Quantity", productDto.getQuantity());

        namedParameterJdbcTemplate.update(SAVE, params);

    }

    @Override
    public void update(int id, ProductDto updateProductDto) {
        Map<String, Object> params = new HashMap<>();
params.put("Id", id);
        params.put("NameProduct", updateProductDto.getNameProduct());
        params.put("Price", updateProductDto.getPrice());
        params.put("Quantity", updateProductDto.getQuantity());

        namedParameterJdbcTemplate.update(UPDATE, params);

    }

    @Override
    public void delete(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("Id", id);
        namedParameterJdbcTemplate.update(DELETE, params);

    }


}
