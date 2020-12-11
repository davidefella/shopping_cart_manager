package shopping.cart.manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import shopping.cart.manager.model.Product;
import shopping.cart.manager.model.ShoppingCart;

@RestController
public class RestInputHandler {
  
    @RequestMapping(value = "/buy_goods", method = RequestMethod.POST)
    public ResponseEntity<ShoppingCart> buyGoods(@RequestBody ShoppingCart shoppingCart) {

        return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
    }
}