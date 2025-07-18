package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BuyProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") int productID, Model model) {
        // creates an Optional<Product> in case productID is not found in the repository
        Optional<Product> maybeProduct = productRepository.findById((long)productID);

        // If product is in repository, get the product and check inventory status
        // Otherwise, display purchaseErrorNotAProduct page
        if (maybeProduct.isPresent()) {
            Product product = maybeProduct.get();

            // If the product has inventory (> 0),
            //      deduct 1 from the current inventory
            //      resave the product to the repository
            //      display the purchaseConfirmation page
            if (product.getInv() > 0) {
                product.setInv(product.getInv() - 1);
                System.out.println(product.getInv());
                productRepository.save(product);
                return "purchaseConfirmation";
            }
            // If the product has no inventory (== 0), display purchaseErrorNoInventory page
            else {
                return "purchaseErrorNoInventory";
            }
        }
        else {
            return "purchaseErrorNotAProduct";
        }
    }
}
