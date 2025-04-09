package com.example.TanKhoaLearningCenterBE.web.rest.old;

import com.example.TanKhoaLearningCenterBE.entity.old.ProductEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderController {

    @GetMapping("/header")
    public String getReagionalResponse(@RequestHeader(required = false, defaultValue = "US") String region){
        if (region.equals("US")) return "BALD EAGLE FREEDOM";
        if (region.equals("CAN")) return "MAPLE SYRUP";
        return "Country not supported";
    }

    @GetMapping(value = "/header/product", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProductEntity> getProduct(){
        ProductEntity product = new ProductEntity();
        product.setId(1);
        product.setName("super great product");
        product.setDescription("The greatest product you'll ever see ever");
        product.setPrice(2.5657);

        return ResponseEntity.ok(product);
    }
}
