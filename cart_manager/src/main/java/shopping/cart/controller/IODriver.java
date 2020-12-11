package shopping.cart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import shopping.cart.manager.ShoppingCartManager;
import shopping.cart.model.CartResult;
import shopping.cart.model.ShoppingCart;

@RestController
public class IODriver {
  
    @RequestMapping(value = "/buy_goods", method = RequestMethod.POST)
    public ResponseEntity<CartResult> buyGoods(@RequestBody ShoppingCart shoppingCart) {

        ShoppingCartManager shoppingCartManager = new ShoppingCartManager();

        return new ResponseEntity<>( shoppingCartManager.buyGoods(shoppingCart), HttpStatus.OK);
    }
}