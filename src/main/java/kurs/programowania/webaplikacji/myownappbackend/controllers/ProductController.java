package kurs.programowania.webaplikacji.myownappbackend.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import kurs.programowania.webaplikacji.myownappbackend.models.records.CreateProductRequest;
import kurs.programowania.webaplikacji.myownappbackend.models.records.ProductResponse;
import kurs.programowania.webaplikacji.myownappbackend.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid CreateProductRequest productData) {
        //Check which user sent request
        return ResponseEntity.ok(
            new ProductResponse(
                productService.createProduct(
                    productData.name(),
                    productData.description(),
                    productData.price(),
                    productData.forSale(),
                    "testUserId"
                )
            )
        );
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getLoggedInUserProducts() {
        //Check which user sent request
        return ResponseEntity.ok(
            productService.getUserProducts("testUserId").stream().map(ProductResponse::new).toList()
        );
    }

    @GetMapping("/forSale")
    public ResponseEntity<List<ProductResponse>> getProductsForSale() {
        return ResponseEntity.ok(
            productService.getProductsForSale().stream().map(ProductResponse::new).toList()
        );
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<ProductResponse> closeOrder(@PathVariable @NotBlank String productId) {
        //Check which user sent request
        productService.deleteProduct(productId, "testUserId");
        return ResponseEntity.ok().build();
    }

}
