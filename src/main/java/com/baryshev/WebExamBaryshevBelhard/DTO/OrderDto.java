package com.baryshev.WebExamBaryshevBelhard.DTO;

import com.baryshev.WebExamBaryshevBelhard.Model.Person;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private int id;
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    private ProductDto products;

    @OneToOne(fetch = FetchType.LAZY)
    private Person person;

    public OrderDto() {
    }

    public OrderDto(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public OrderDto(ProductDto products) {
        this.products = products;
    }

    public OrderDto(Person person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ProductDto getProducts() {
        return products;
    }

    public void setProducts(ProductDto products) {
        this.products = products;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", products=" + products +
                ", person=" + person +
                '}';
    }
}
