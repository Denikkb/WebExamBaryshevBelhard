package com.baryshev.WebExamBaryshevBelhard.Model;


import com.baryshev.WebExamBaryshevBelhard.DTO.ProductDto;
import com.mysql.cj.x.protobuf.MysqlxCursor;
import org.springframework.lang.NonNull;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class Person {

    private int PersonId;

    @NotEmpty(message = "Введите имя")
    @Size(min = 2, max = 20, message = "Название имени от 2 до 20 символов")
    @Pattern(regexp = "[a-zA-Zа-яА-Я]*", message = "Название имени должно состоять из букв")
    private String FirstName;

    @NotEmpty(message = "Введите фамилию")
    @Size(min = 2, max = 20, message = "Название фамилии от 2 до 20 символов")
    @Pattern(regexp = "[a-zA-Zа-яА-Я]*", message = "Название фамилии должно состоять из букв")
    private String LastName;

    @OneToOne(fetch = FetchType.LAZY)
    private ProductDto products;

    public Person() {
    }

    public Person(int personId, String firstName, String lastName) {
        PersonId = personId;
        FirstName = firstName;
        LastName = lastName;
    }

    public Person(ProductDto products) {
        this.products = products;
    }

    public ProductDto getProducts() {
        return products;
    }

    public void setProducts(ProductDto products) {
        this.products = products;
    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "PersonId=" + PersonId +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }
}
