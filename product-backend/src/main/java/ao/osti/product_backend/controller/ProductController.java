package ao.osti.product_backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ao.osti.product_backend.models.Product;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin
public class ProductController {

    /*
     * 
     *  public Product(int id, String name, String description, int idCategory, boolean promotion, boolean newProduct,
            double price) {
     * 
     */
    private List<Product> products = Arrays.asList(
            new Product(1, "p1roduct Name 1","Nova descrição 1",1,false,false, 250.60),
            new Product(2, "Product Name 2","Nova descrição 2",2,false,true, 74650.60),
            new Product(3, "Product Name 3","Nova descrição 3",1,false,false, 9936.60),
            new Product(4, "Product Name 4","Nova descrição 4",1,true,true, 600036.60),
            new Product(5, "Product Name 5","Nova descrição 5",1,true,false, 890036.60));

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
