package com.baryshev.WebExamBaryshevBelhard.rowMapper;

import com.baryshev.WebExamBaryshevBelhard.DTO.ProductDto;
import com.baryshev.WebExamBaryshevBelhard.Model.Person;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeopleWithProductRowMapper implements ResultSetExtractor<List<Person>> {


    @Override
    public List<Person> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<Person> personList = new ArrayList<>();
        while(rs.next()){
            Person person = new Person();

                person.setPersonId(rs.getInt("PersonId"));
                person.setFirstName(rs.getString("FirstName"));
                person.setLastName(rs.getString("LastName"));


            ProductDto productDto = new ProductDto();
            productDto.setNameProduct(rs.getString("NameProduct"));
            productDto.setPrice(rs.getInt("Price"));
            productDto.setQuantity(rs.getInt("Quantity"));

            person.setProducts(productDto);
            personList.add(person);
        }
        return personList;
    }
}
