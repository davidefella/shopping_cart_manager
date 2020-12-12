package shopping.cart.manager.cart_manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import shopping.cart.model.Product;
import shopping.cart.taxes_calculator.TaxesCalculator;

@SpringBootTest
public class TaxesCalculatorTest {
    
    @Autowired
    private TaxesCalculator taxesCalculator;
    
    @Test
    public void TaxesCalc_BookCategory_Calculate() throws Exception {
        //arrange
        Product bookProductPositive = new Product("book", 3, 3);
        Product bookProductDecimal = new Product("book", 3, 3.5);
        Product booksProductNevative = new Product("books", 3, -3);
        Product booksProductZero = new Product("books", 0, 10);


        double  taxeBookProductPositive; 
        double  taxeBookProductZeroPositive; 
        double  taxeBookProductNegative; 
        double  taxeBookProductDecimal; 

        //act
        taxeBookProductPositive = taxesCalculator.calculateTax(bookProductPositive);
        taxeBookProductZeroPositive = taxesCalculator.calculateTax(booksProductZero);
        taxeBookProductNegative = taxesCalculator.calculateTax(booksProductNevative);
        taxeBookProductDecimal = taxesCalculator.calculateTax(bookProductDecimal);

        //result
        assertEquals("0.9", String.valueOf(taxeBookProductPositive));
        assertEquals("-0.9", String.valueOf(taxeBookProductNegative));
        assertEquals("0.0", String.valueOf(taxeBookProductZeroPositive));
        assertEquals("1.05", String.valueOf(taxeBookProductDecimal));

    }

    @Test
    public void TaxesCalc_FoodBeverageCategory_Calculate() throws Exception {
        //arrange
        Product beerProduct = new Product("beer", 3, 3);
        Product beerProductZero = new Product("beer", 0, 3);
        Product beersProduct = new Product("beers", 3, 3);
        Product cakeProductNevative = new Product("cake", 3, 3);
        Product cakesProductZero = new Product("cakes", 3, 3);

        double  taxeBeerProduct; 
        double  taxebeersProduct; 
        double  taxeCakeProductNevative; 
        double  taxeCakesProductNevative; 
        double  taxeBeerProductZero; 

        //act
        taxeBeerProduct = taxesCalculator.calculateTax(beerProduct);
        taxebeersProduct = taxesCalculator.calculateTax(beersProduct);
        taxeCakeProductNevative = taxesCalculator.calculateTax(cakeProductNevative);
        taxeCakesProductNevative = taxesCalculator.calculateTax(cakesProductZero);
        taxeBeerProductZero = taxesCalculator.calculateTax(beerProductZero);

        //result
        assertEquals("0.36", String.valueOf(taxeBeerProduct));
        assertEquals("0.36", String.valueOf(taxebeersProduct));
        assertEquals("0.36", String.valueOf(taxeCakeProductNevative));
        assertEquals("0.36", String.valueOf(taxeCakesProductNevative));
        assertEquals("0.0", String.valueOf(taxeBeerProductZero));
    }

    @Test
    public void TaxesCalc_BasicCategory_Calculate() throws Exception {
        //arrange
        Product penProduct = new Product("pen", 2, 7.35); //OK
        Product pensProduct = new Product("pens", 0, 1); //OK
        Product pencileProduct = new Product("pencil", 5, 9.99); //Ok
        Product tshirtProduct = new Product("t-shirt", 5, 0.01); //OK
        Product tshirtsProduct = new Product("t-shirts", 1, 10); //OK
        Product knitwearProduct = new Product("knitwear", 8, 2); //OK
        Product fancyStuffProduct = new Product("fancy stuff", 4, 2); //OK

        double  taxePenProduct; 
        double  taxePensProduct; 
        double  taxePencileProduct; 
        double  taxeTshirtProduct; 
        double  taxeTshirtsProduct; 
        double  taxeKnitwearProduct; 
        double  taxeFancyStuffProduct; 

        //act
        taxePenProduct = taxesCalculator.calculateTax(penProduct);
        taxePensProduct = taxesCalculator.calculateTax(pensProduct);
        taxePencileProduct = taxesCalculator.calculateTax(pencileProduct);
        taxeTshirtProduct = taxesCalculator.calculateTax(tshirtProduct);
        taxeTshirtsProduct = taxesCalculator.calculateTax(tshirtsProduct);
        taxeKnitwearProduct = taxesCalculator.calculateTax(knitwearProduct);
        taxeFancyStuffProduct = taxesCalculator.calculateTax(fancyStuffProduct);

        //result
        assertEquals("3.23", String.valueOf(taxePenProduct));
        assertEquals("0.0", String.valueOf(taxePensProduct));
        assertEquals("10.99", String.valueOf(taxePencileProduct));
        assertEquals("0.01", String.valueOf(taxeTshirtProduct));
        assertEquals("2.2", String.valueOf(taxeTshirtsProduct));
        assertEquals("3.52", String.valueOf(taxeKnitwearProduct));
        assertEquals("1.76", String.valueOf(taxeFancyStuffProduct));

    }
}
