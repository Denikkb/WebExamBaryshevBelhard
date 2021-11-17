package com.baryshev.WebExamBaryshevBelhard.rowMapper;

import com.baryshev.WebExamBaryshevBelhard.DTO.ProductDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductPowMapper implements RowMapper <ProductDto> {
    @Override
    public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductDto productDto = new ProductDto();
        productDto.setId(rs.getInt("Id"));
        productDto.setNameProduct(rs.getString("NameProduct"));
        productDto.setPrice(rs.getInt("Price"));
        productDto.setQuantity(rs.getInt("Quantity"));
        return productDto;
    }
}
