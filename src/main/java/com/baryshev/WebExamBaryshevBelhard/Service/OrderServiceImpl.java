package com.baryshev.WebExamBaryshevBelhard.Service;

import com.baryshev.WebExamBaryshevBelhard.DAO.OrderDao;

import com.baryshev.WebExamBaryshevBelhard.DTO.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderDao orderDao;

        @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }


    @Override
    public List<OrderDto> getAllOrdersWithPeopleAndProductsById(int id) {
        return orderDao.getAllOrdersWithPeopleAndProductsById(id);
    }

    @Override
    public List<OrderDto> getAllOrdersWithPeopleAndProducts() {
        return orderDao.getAllOrdersWithPeopleAndProducts();
    }


}
