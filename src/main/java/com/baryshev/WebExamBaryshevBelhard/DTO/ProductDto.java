package com.baryshev.WebExamBaryshevBelhard.DTO;

import net.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.lang.NonNull;

import javax.validation.constraints.*;

public class ProductDto {


     private int id;
    @NotEmpty(message = "Введите имя")
    @Size(min = 2, max = 20, message = "Название продукта от 2 до 20 символов")
    @Pattern(regexp = "[a-zA-Zа-яА-Я]*", message = "Название продукта должно состоять из букв")

     private String nameProduct;

    @NotNull(message = "Введите цену")
    @Positive (message = "Цена должна быть положительной")

     private int price;

    @NotNull(message = "Введите имя")
    @Positive (message = "Количество должно быть положительным")
     private int quantity;

    public ProductDto() {
    }

    public ProductDto(int id, String nameProduct, int price, int quantity) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
