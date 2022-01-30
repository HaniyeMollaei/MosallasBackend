package com.haniyemollaei.mosallas.controller;


import com.haniyemollaei.mosallas.domain.Product;
import com.haniyemollaei.mosallas.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "product")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping("/")
    public List<Product> list() {
        return productRepository.findAll();
    }


    @GetMapping("/find-by-id")
    @ResponseBody
    public ResponseEntity<Product> getUser(@RequestParam("id") Long id) {
        List<Product> productList = productRepository.findAll();
        Product product = null;
        for (int i = 0 ; i < productList.size() ; i++) {
            if(productList.get(i).getId()==id){
                product = productList.get(i);
            }
        }
        return ResponseEntity.ok(product);
    }



    public String registerUserService(Product product)
    {
        try
        {
            productRepository.save(product);
        }
        catch (Exception e)
        {
            return  "An error occurred User not saved!";
        }

        return "User saved";
    }


    @PostMapping("/add-product")
    public ResponseEntity<?> registerUser(@RequestBody Product product) throws Exception
    {
        HashMap<String, String> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        //Objects.requireNonNull(user);

        String result = registerUserService(product);

        if (result.equals("User saved"))
        {
            map.put("id", String.valueOf(product.getId()));
            return ResponseEntity.ok(objectMapper.writeValueAsString(map));

        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while saving user");
    }

}
