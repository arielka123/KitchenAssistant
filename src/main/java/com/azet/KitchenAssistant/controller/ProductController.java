package com.azet.KitchenAssistant.controller;

import com.azet.KitchenAssistant.Entity.Product;
import com.azet.KitchenAssistant.dao.ProductRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    public final ProductRepository productRepository;

    ProductController(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Product> addNewProduct(@RequestBody @Valid Product newProduct){

        Product result =productRepository.save(newProduct);
        logger.info("saved new Product");
        return ResponseEntity.created(URI.create("/" + result.getId())).body(newProduct);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Product>> readAllProducts(Pageable page){

        logger.info("custom pageable for all products");
        return ResponseEntity.ok(productRepository.findAll(page).getContent());
        //http://localhost:8080/products?page=0&size=10
    }

    @RequestMapping(method = RequestMethod.GET, params="categoryId" ,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Product>> readProductsByCategory(@RequestParam("categoryId") Long id, Pageable page){

        logger.info("custom pageable for products in selected category");

        //TODO info when id not exist

        return ResponseEntity.ok(productRepository.findByCategoryId(id, page).getContent());
        //http://localhost:8080/products?categoryId=5&page=0&size=10
    }

    @RequestMapping(method = RequestMethod.GET, params = "search", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Product>> readProductsByName(@RequestParam("search") String textToSearch, Pageable page){

        logger.info("searching by name of product");
        //TODO info when text is not present anywhere

        return ResponseEntity.ok(productRepository.findByNameContaining(textToSearch, page).getContent());
        //http://localhost:8080/products?search=ml&page=0&size=10
    }

}
