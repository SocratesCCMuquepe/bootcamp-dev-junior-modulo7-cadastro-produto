package ao.osti.product_backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ao.osti.product_backend.models.Product;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@CrossOrigin
public class ProductController {
    /*
    private List<Product> products = Arrays.asList(
            new Product(1, "p1roduct Name 1", "Nova descrição 1", 1, false, false, 250.60),
            new Product(2, "Product Name 2", "Nova descrição 2", 2, false, true, 74650.60),
            new Product(3, "Product Name 3", "Nova descrição 3", 1, false, false, 9936.60),
            new Product(4, "Product Name 4", "Nova descrição 4", 1, true, true, 600036.60),
            new Product(5, "Product Name 5", "Nova descrição 5", 1, true, false, 890036.60));
    */

    private List<Product> products = new ArrayList<>();


    @PostMapping("product")
    public ResponseEntity<Product> save(@RequestBody Product product) {

        product.setId(products.size() + 1);
        products.add(product);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(location).body(product);
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
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
