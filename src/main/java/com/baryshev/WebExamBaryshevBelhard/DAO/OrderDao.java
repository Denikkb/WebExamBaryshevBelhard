package com.baryshev.WebExamBaryshevBelhard.DAO;

import com.baryshev.WebExamBaryshevBelhard.DTO.OrderDto;

import java.util.List;

public interface OrderDao {
    List<OrderDto> getAllOrdersWithPeopleAndProductsById (int id);
    List<OrderDto> getAllOrdersWithPeopleAndProducts ();
    //OrderDto getOrderById (int id);
    //OrderDto getOrderByIdWihtProductByOrderId(int id);

}
