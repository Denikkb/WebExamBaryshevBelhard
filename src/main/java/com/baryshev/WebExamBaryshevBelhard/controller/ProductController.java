package com.baryshev.WebExamBaryshevBelhard.controller;

import com.baryshev.WebExamBaryshevBelhard.DTO.ProductDto;
import com.baryshev.WebExamBaryshevBelhard.Model.Person;
import com.baryshev.WebExamBaryshevBelhard.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String  getAllProducts (Model model){
        model.addAttribute("products", productService.getAllProducts());

        return "showAllProducts";
    }

    @GetMapping("/product/{id}")
    public String getProduct (@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "showProduct";
    }

    @GetMapping("/product/new")
    public String newProduct (Model model) {
        model.addAttribute("product", new ProductDto());
        return "newProduct";

    }

    @PostMapping("/save_product")
    public String save (@ModelAttribute("product")  @Valid ProductDto productDto, BindingResult bindingResult)  {

        if (bindingResult.hasErrors()) {
            return "newProduct";
        }

        else {
            productService.save(productDto);
            return "redirect:/products";
        }
    }
    @PatchMapping( "/product/{id}")
    public String update (@ModelAttribute("product") @Valid ProductDto productDto, BindingResult bindingResult, @PathVariable("id") int id) throws SQLException {

        if (bindingResult.hasErrors()) {
            return "newProduct";
        }

        else {
            productService.update(id, productDto);
            return "redirect:/products";
        }
    }

    @GetMapping("/product/{id}/updateProduct")
    public String updateProduct (@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "updateProduct";
    }

    @DeleteMapping("/product/{id}")
    public String delete (@PathVariable("id") int id) throws SQLException {
        productService.delete(id);
        return "redirect:/products";
    }
}