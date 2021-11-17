package com.baryshev.WebExamBaryshevBelhard.DAO;

import com.baryshev.WebExamBaryshevBelhard.DTO.OrderDto;

import com.baryshev.WebExamBaryshevBelhard.rowMapper.AllOrdersWithPeopleAndProductsPowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDaoImpl implements OrderDao{

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //private String GET_ALL_ORDERS = "SELECT * FROM Orders";
    //private String GET_ORDER_BY_ID = "SELECT * FROM Orders WHERE id = :id";
    //private String GET_Order_BY_ID_WITH_PRODUCT_BY_ORDER_ID = "SELECT ORDERS.ID AS ORDER_ID, ORDERS.QUANTITYFORORDER as QUANTITY_FOR_ORDER, " +
           // "PRODUCTS.NAMEPRODUCT  FROM ORDERS INNER JOIN PRODUCTS ON ORDERS.ID_PRODUCT = PRODUCTS.ID WHERE ORDERS.ID=:id";
        private String GET_ALL_ORDERS_WITH_PEOPLE_AND_PRDUCTS_BY_ID = "SELECT PERSONS.PERSONID, PERSONS.FIRSTNAME ,PERSONS.LASTNAME, " +
            "PRODUCTS.NAMEPRODUCT, PRODUCTS.PRICE ,PRODUCTS.QUANTITY ,ORDERS.ID as ORDER_ID, ORDERS.EMAIL   FROM PERSONS\n" +
            "\n" +
            "INNER JOIN PRODUCTS ON PERSONS.PERSONID =PRODUCTS.ID_PERSON \n" +
            "\n" +
            "INNER JOIN ORDERS ON PERSONS.PERSONID =ORDERS .ID_PERSON  \n" +
            "\n" +
            "WHERE PERSONS.PERSONID =:PersonId  ";

    private String GET_ALL_ORDERS_WITH_PEOPLE_AND_PRDUCTS = "SELECT PERSONS.PERSONID, PERSONS.FIRSTNAME ,PERSONS.LASTNAME, " +
            "PRODUCTS.NAMEPRODUCT, PRODUCTS.PRICE ,PRODUCTS.QUANTITY ,ORDERS.ID as ORDER_ID, ORDERS.EMAIL   FROM PERSONS\n" +
            "\n" +
            "INNER JOIN PRODUCTS ON PERSONS.PERSONID =PRODUCTS.ID_PERSON \n" +
            "\n" +
            "INNER JOIN ORDERS ON PERSONS.PERSONID =ORDERS .ID_PERSON";

    @Autowired
    public OrderDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<OrderDto> getAllOrdersWithPeopleAndProductsById(int id) {
        Map<String , Object> param = new HashMap<>();
        param.put("PersonId", id);

        return namedParameterJdbcTemplate.query(GET_ALL_ORDERS_WITH_PEOPLE_AND_PRDUCTS_BY_ID, param, new AllOrdersWithPeopleAndProductsPowMapper());
    }

    @Override
    public List<OrderDto> getAllOrdersWithPeopleAndProducts() {

        return namedParameterJdbcTemplate.query(GET_ALL_ORDERS_WITH_PEOPLE_AND_PRDUCTS,  new AllOrdersWithPeopleAndProductsPowMapper());
    }



   /* @Override
    public List<OrderDto> getAllOrders() {
        return namedParameterJdbcTemplate.query(GET_ALL_ORDERS, new OrderPowMapper());
    }

    @Override
    public OrderDto getOrderById(int id) {

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcTemplate.queryForObject(GET_ORDER_BY_ID, params, new OrderPowMapper());
    }

    @Override
    public OrderDto getOrderByIdWihtProductByOrderId(int id) {
        Map<String , Object> param = new HashMap<>();
        param.put("id", id);
        return namedParameterJdbcTemplate.query(GET_Order_BY_ID_WITH_PRODUCT_BY_ORDER_ID, param,  new OrderWithProductRowMapper());
    }*/


}
