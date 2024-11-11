package ao.osti.product_backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ao.osti.product_backend.models.Product;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ProductController {

    private List<Product> products = Arrays.asList(
            new Product(1, "p1roduct Name 1", 250.60),
            new Product(2, "Product Name 2", 74650.60),
            new Product(3, "Product Name 3", 9936.60),
            new Product(4, "Product Name 4", 600036.60));

   /*  @PostConstruct
    public void init() {

        Product p1 = new Product(1, "p1roduct Name 1", 250.60);
        Product p2 = new Product(2, "Product Name 2", 74650.60);
        Product p3 = new Product(3, "Product Name 3", 9936.60);
        Product p4 = new Product(4, "Product Name 4", 600036.60);

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

    }*/

    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        // Product product = products.get(id - 1);

        // if (id <= products.size()) {
        // return ResponseEntity.ok(products.get(id - 1));
        // } else {
        // throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not
        // found..!");
        // }
        Product product = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found..!"));

        return ResponseEntity.ok(product);
    }

    @GetMapping("products")
    public List<Product> getProducts() {
        return products;
    }

}
