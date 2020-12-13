# Shopping Cart Application Demo

## Table of Contents

- [Introduction and technology stack](#Introduction-and-Technologies-stack)
- [Versions](#Version)
- [Requirements](#Requirements)
- [Remote API](#Remote-API)
- [Main Features implemented](#Main-Features-implemented)
- [Input](#Input)
- [Output](#Output)
- [Taxes calculator](#Tax-calculator)
- [Testing](#Testing)
- [Feature in backlog](#Feature-In-Backlog)
- [External Resources](#External-resources)
- [License](#License)

## Introduction and Technologies stack
This is an application to manage a Shopping Cart with products, coupons and taxes. 

### Tech stack: 
- Java + Spring Boot
- JUnit
- Visual Studio Code
- Advanced REST Client
- Maven
- Git and Gihub, of course : ) 

## Introduction and Technologies stack

Latest stable version: 1.0  

## Requirements
Create a shopping cart to manage products, coupons and taxes.

- Basic sale tax is generally applicable at a rate of 22% on all goods.
- For books instead you have to apply a rate of 10%.
- For food and beverage instead you have to apply a rate of 4%.
- A user can also add a coupon (with code GIFT5) that applies a discount of 5% to the unit price for every book.

Please round all the prices to 2 decimals.


``` 
SHOPPING CART 1
Input:
    - 2 beer at 5 € once
    - 1 pen at 1.35 €
    - 4 t-shirts at 10 € once

Output:
Shopping cart nr. 1
    - 2 beer | 10 €
    - 1 pen | 1.35 €
    - 4 t-shirts | 40 €
Total taxes: 9.50 €
Total: 60.85 €
```

## Remote API
I chose `Heroku` for the CI/CD service directly connected to the main branch of my repository.

```
https://demo-shopping-cart-manager-app.herokuapp.com/
```

Please note: I am using a free cost service so it takes a few seconds for the first call

## Main Features implemented

- Web welcome page
- Input/Output via REST API
- Subdivision of products categories
- Taxes calculation per product/category
- Discount coupon management GIFT5 for book category
- Calculation of total taxes for each shopping cart
- Total calculation to pay for each shopping cart
- Management of rounding to two decimal places
- Currency selection

## Input / Output

For the submission of a Shopping cart I decided to implement a REST interface for sending data. The output of the service will be the printing of the cart.

Available categories and products:
- Food and Beverage: beer(s), coke(s), wine
- Book: book(s)
- Basic: every other string that is not in previous categories
  

<ins>#ASSUMPTION:</ins> In the requirements sent by the client it is not clear whether the sample input (and output) specifed in text is exactly the desired input or an abstraction of it.  

Since it is easier to separate the backend from the frontend (with React or Angular) with REST calls, I decided for this technology but It would be simple to convert the IOdriver.java class to accept a text file that is a copy of the one written in the requirments  

<br>
Examples of JSON to insert into the BODY of the request:

``` 
{
  "idShoppingCart": "SHOPPING CART 1",
  "goods": [
    {
      "name": "beer",
      "quantity": 2,
      "price": 5
    },
    {
      "name": "pen",
      "quantity": 1,
      "price": 1.35
    },
    {
      "name": "t-shirts",
      "quantity": 4,
      "price": 10
    }
  ]
}
``` 

``` 
{
  "idShoppingCart": "SHOPPING CART 2",
  "codeCoupon": "GIFT5",
  "goods": [
    {
      "name": "cokes",
      "quantity": 2,
      "price": 2.30
    },
    {
      "name": "knitwear",
      "quantity": 1,
      "price": 33
    },
    {
      "name": "books",
      "quantity": 3,
      "price": 12.99
    }
  ]
}
``` 

``` 
{
  "idShoppingCart": "SHOPPING CART 3",
  "codeCoupon": "GIFT5",
  "goods": [
    {
      "name": "cake",
      "quantity": 1,
      "price": 42.50
    },
    {
      "name": "book",
      "quantity": 1,
      "price": 16.57
    },
    {
      "name": "t-shirts",
      "quantity": 7,
      "price": 5.40
    },
    {
      "name": "book",
      "quantity": 1,
      "price": 12.93
    }
  ]
}
``` 

The output will have a format like:

```
{
"idShoppingCart": "Shopping Cart nr. 4",
"products": [
  {
"name": "cake",
"quantity": 1,
"price": 42.5
},
  {
"name": "book",
"quantity": 1,
"price": 15.74
},
  {
"name": "t-shirts",
"quantity": 7,
"price": 37.80
},
  {
"name": "book",
"quantity": 1,
"price": 12.28
}
],
"totalTaxes": 12.82,
"totalAmount": 121.14
}
```

## Taxes calculator
For the tax calculation module, I used polymorphism by creating a class for each category so that I can easily manage the tax percentage:

- Category.java (Interface)
- Basic.java
- Book.java
- FoodBeverage.java

Also for the discount coupons calculation I  used polymorphism, currently the system accepte only one, the "GIFT5" discount for books. 

- Coupon.java (Interface)
- CouponGift5.java
- NoCoupon.java 


## Testing

For the test I used Junit, testing all the critical modules of the system, both with unit tests on low level components and with black box tests of high level. 

## Features in backlog

- Front end in React/Angular
- Authentication flow
- Data History and catalogue with an online Mongodb as a services
- Catalogue product/category


## External Resources
IDE:  
- https://code.visualstudio.com/

Heroku service:  
- https://www.heroku.com/

Testing: 
- http://wiki.c2.com/?ArrangeActAssert 
- https://osherove.com/blog/2005/4/3/naming-standards-for-unit-tests.html
- https://github.com/advanced-rest-client

Java:  
- https://spring.io/

## License
MIT ©