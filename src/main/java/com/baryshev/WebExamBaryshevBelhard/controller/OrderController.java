package com.baryshev.WebExamBaryshevBelhard.controller;


import com.baryshev.WebExamBaryshevBelhard.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;

@Controller
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

   /* @GetMapping("/orders")
    public void getAllOrders () {
        System.out.println(orderService.getAllOrders());
    }

    @GetMapping("/order")
    public void getOrderById (int id){ System.out.println(orderService.getOrderById(id));
    }

    @GetMapping("/order_with_product")
    public void getOrderByIdWihtProductByOrderId (int id) {
        System.out.println (orderService.getOrderByIdWihtProductByOrderId(id));
    }*/

    @GetMapping("/order/{id}/getAllOrdersWithPeopleAndProductsById")
    public String getAllOrdersWithPeopleAndProductsById (@PathVariable("id") int id, Model model) throws SQLException {

        model.addAttribute("order",orderService.getAllOrdersWithPeopleAndProductsById(id));
        return "Orders_With_People_And_Products";
    }
    @GetMapping("/orders")
    public String getAllOrdersWithPeopleAndProducts ( Model model) throws SQLException {

        model.addAttribute("orders",orderService.getAllOrdersWithPeopleAndProducts());
        return "showAllOrders";
    }
}
