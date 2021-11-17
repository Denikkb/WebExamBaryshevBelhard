package com.baryshev.WebExamBaryshevBelhard.rowMapper;

import com.baryshev.WebExamBaryshevBelhard.DTO.OrderDto;
import com.baryshev.WebExamBaryshevBelhard.DTO.ProductDto;
import com.baryshev.WebExamBaryshevBelhard.Model.Person;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllOrdersWithPeopleAndProductsPowMapper implements ResultSetExtractor<List<OrderDto>> {


    @Override
    public List<OrderDto> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<OrderDto> orderDtoList = new ArrayList<>();

        while(rs.next()){

            OrderDto orderDto = new OrderDto();

            orderDto.setId(rs.getInt("Id"));
            orderDto.setEmail(rs.getString("Email"));


            Person person = new Person();

            person.setPersonId(rs.getInt("PersonId"));
            person.setFirstName(rs.getString("FirstName"));
            person.setLastName(rs.getString("LastName"));


            ProductDto productDto = new ProductDto();
            productDto.setNameProduct(rs.getString("NameProduct"));
            productDto.setPrice(rs.getInt("Price"));
            productDto.setQuantity(rs.getInt("Quantity"));

            orderDto.setPerson(person);
            orderDto.setProducts(productDto);

            orderDtoList.add(orderDto);



        }
        return orderDtoList;
    }
}
