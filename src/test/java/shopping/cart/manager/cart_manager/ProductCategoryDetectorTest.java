package shopping.cart.manager.cart_manager;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import shopping.cart.ProductsUtils.ProductCategoryFactory;
import shopping.cart.model.product_category.Basic;
import shopping.cart.model.product_category.Book;
import shopping.cart.model.product_category.Category;
import shopping.cart.model.product_category.FoodBeverage;

@SpringBootTest
public class ProductCategoryDetectorTest {
    
    @Autowired
    private ProductCategoryFactory productCategoryDetector;
    
    @Test
    public void CategoryDetector_BookName_ReturnBookObject() throws Exception {
        //arrange
        String productNameBook = "book";
        Category bookCategoryResult; 

        //act 
        bookCategoryResult = productCategoryDetector.detectCategoryFrom(productNameBook); 

        //assert
        assertTrue(bookCategoryResult instanceof Book);
        
    }

    @Test
    public void CategoryDetector_FoodBeverageName_FoodBeverageObject() throws Exception {
        //arrange
        String beerName = "beer";
        String cookeName = "coke";
        String cookesName = "cokes";
        String cakeName = "cake";

        Category beerCategoryResult;
        Category cokeCategoryResult; 
        Category cokesCategoryResult; 
        Category cakeCategoryResult; 

        //act 
        beerCategoryResult = productCategoryDetector.detectCategoryFrom(beerName);
        cokeCategoryResult = productCategoryDetector.detectCategoryFrom(cookeName); 
        cokesCategoryResult = productCategoryDetector.detectCategoryFrom(cookesName); 
        cakeCategoryResult = productCategoryDetector.detectCategoryFrom(cakeName); 
 
        //assert
        assertTrue(beerCategoryResult instanceof FoodBeverage);
        assertTrue(cokeCategoryResult instanceof FoodBeverage);
        assertTrue(cokesCategoryResult instanceof FoodBeverage);
        assertTrue(cakeCategoryResult instanceof FoodBeverage);
        
    }

    @Test
    public void CategoryDetector_OtherName_BasicObject() throws Exception {
        //arrange
        String tshirtsName = "t-shirts";
        String penName = "pen";
        String knitwearName = "knitwear";
        String fancyStuffName = "fancy Stuff";

        Category basicCategoryResult;
        Category penResult;
        Category knitwearResult;
        Category fancyStuffResult;

        //act 
        basicCategoryResult = productCategoryDetector.detectCategoryFrom(tshirtsName);
        penResult = productCategoryDetector.detectCategoryFrom(penName);
        knitwearResult = productCategoryDetector.detectCategoryFrom(knitwearName);
        fancyStuffResult = productCategoryDetector.detectCategoryFrom(fancyStuffName);

        //assert
        assertTrue(basicCategoryResult instanceof Basic);
        assertTrue(penResult instanceof Basic);
        assertTrue(knitwearResult instanceof Basic);
        assertTrue(fancyStuffResult instanceof Basic);

    }
}