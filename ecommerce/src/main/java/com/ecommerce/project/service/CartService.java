package com.ecommerce.project.service;

import com.ecommerce.project.payload.CartDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
     CartDTO addProductToCart(Long productId, Integer quantity);
     List<CartDTO> getAllCarts();
     CartDTO getCart(String emailId, Long cardId);

     @Transactional
     CartDTO updateProductQuatityInCart(Long productId, Integer quantity);
     String deleteProductFromCart(Long cartId, Long productId);

    void updateProductInCarts(Long cartId, Long productId);
}
