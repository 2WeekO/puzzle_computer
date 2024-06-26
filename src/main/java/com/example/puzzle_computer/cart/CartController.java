package com.example.puzzle_computer.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<?> addItemToCart(@RequestBody CartRequest cartRequest) {
        try {
            cartService.addItemToCart(cartRequest.getUserId(), cartRequest.getProductId());
            return ResponseEntity.ok("Item added to cart");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add item to cart");
        }
    }
}

@Getter
@Setter
class CartRequest {
    private Long userId;
    private Long productId;
    
    // getters and setters
}

