package ao.osti.product_backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ProductController {
    @GetMapping("product")
    public String getProduct() {
        return "Eu sou um producto!";
    }
}
