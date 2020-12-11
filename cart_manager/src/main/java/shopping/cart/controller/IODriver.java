package shopping.cart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import shopping.cart.model.Product;
import shopping.cart.model.ShoppingCart;

@RestController
public class IODriver {
  
    @RequestMapping(value = "/buy_goods", method = RequestMethod.POST)
    public ResponseEntity<ShoppingCart> buyGoods(@RequestBody ShoppingCart shoppingCart) {

        return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
    }
}