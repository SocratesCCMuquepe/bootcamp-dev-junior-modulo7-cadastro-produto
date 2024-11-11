package ao.osti.product_backend.controller;

import org.springframework.web.bind.annotation.RestController;

import ao.osti.product_backend.models.Product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ProductController {

   

    @GetMapping("product")
    public Product getProduct() {
       Product p = new Product();
       
       p.setId(26);
       p.setName("Product Name");
       p.setPrice(250.60);
       
       return p;
    }

    @GetMapping("products")
    public List<Product> listProduts() {

        Product p = new Product();
        p.setId(26);
        p.setName("Product Name");
        p.setPrice(250.60);
        
        Product p1 = new Product();
        p1.setId(31);
        p1.setName("Product Name 31");
        p1.setPrice(74650.60);

        Product p2 = new Product();
        p2.setId(12);
        p2.setName("Product Name 12");
        p2.setPrice(9936.60);

        ArrayList<Product> listProduct = new ArrayList<>();
        listProduct.add(p);
        listProduct.add(p1);
        listProduct.add(p2);

        return listProduct;
    }
    
}
