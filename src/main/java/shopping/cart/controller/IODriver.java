package shopping.cart.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import shopping.cart.manager.ShoppingCartManager;
import shopping.cart.model.CartResult;
import shopping.cart.model.ShoppingCart;

@RestController
public class IODriver {

    @Autowired
    ShoppingCartManager shoppingCartManager;

    @Value("${app.version}")
    private String appVersion;

    @Value("${welcomeMessage}")
    private String welcomeMessage;

    @RequestMapping(value = "/buy_goods", method = RequestMethod.POST)
    public ResponseEntity<CartResult> buyGoods(@RequestBody ShoppingCart shoppingCart) {

        return new ResponseEntity<>(shoppingCartManager.buyGoods(shoppingCart), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/")
    public String getStatus() {

        return welcomeMessage.concat("<br> <br> Application version: " + appVersion);
    }

}