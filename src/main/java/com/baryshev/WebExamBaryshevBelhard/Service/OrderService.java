package com.baryshev.WebExamBaryshevBelhard.Service;

import com.baryshev.WebExamBaryshevBelhard.DTO.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrdersWithPeopleAndProductsById(int id);
    List<OrderDto> getAllOrdersWithPeopleAndProducts ();
   //OrderDto getOrderById (int id);
    //OrderDto getOrderByIdWihtProductByOrderId(int id);
}
