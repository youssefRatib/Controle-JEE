package org.sid.billingservice.feing;

import org.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.QueryParam;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductItemRestClient {
    @GetMapping(name = "/products")
    PagedModel<Product> pageProducts(@RequestParam(name = "page") int page,
                                     @RequestParam(name = "size") int size);
    @GetMapping(name = "/products/{id}")
    Product getProductById(@PathVariable Long id);
}
