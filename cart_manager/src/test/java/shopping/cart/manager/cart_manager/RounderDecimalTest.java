package shopping.cart.manager.cart_manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import shopping.cart.utils.RounderDecimal;

@SpringBootTest
public class RounderDecimalTest {
    
    @Autowired
    private RounderDecimal rounderDecimal;
    
    @Test
    public void RounderDecimal_DecimalNumber_RoundedDOWN() throws Exception {
        //arrange
        double doubleNumberToRound = 0.123999;
        String stringNumberRounded; 

        //act 
        stringNumberRounded = String.valueOf( rounderDecimal.formatDecimals(doubleNumberToRound) ); 

        //assert
        assertEquals("0.12",stringNumberRounded);
    }

    @Test
    public void RounderDecimal_DecimalNumber_RoundedUP() throws Exception {
        //arrange
        double doubleNumberToRound = 0.1251111;
        String stringNumberRounded; 

        //act 
        stringNumberRounded = String.valueOf( rounderDecimal.formatDecimals(doubleNumberToRound) ); 

        //assert
        assertEquals("0.13",stringNumberRounded);
    }
    
    @Test
    public void RounderDecimal_DecimalNumber_RoundedDownUnit() throws Exception {
        //arrange
        double doubleNumberToRound = 1.000999;
        String stringNumberRounded; 

        //act 
        stringNumberRounded = String.valueOf( rounderDecimal.formatDecimals(doubleNumberToRound) ); 

        //assert
        assertEquals("1.0",stringNumberRounded);
    }

    @Test
    public void RounderDecimal_DecimalNumber_RoundedDownHundred() throws Exception {
        //arrange
        double doubleNumberToRound = 100.000999;
        String stringNumberRounded; 

        //act 
        stringNumberRounded = String.valueOf( rounderDecimal.formatDecimals(doubleNumberToRound) ); 

        //assert
        assertEquals("100.0",stringNumberRounded);
    }

    @Test
    public void RounderDecimal_DecimalNumber_RoundedDownZero() throws Exception {
        //arrange
        double doubleNumberToRound = 0.0;
        String stringNumberRounded; 

        //act 
        stringNumberRounded = String.valueOf( rounderDecimal.formatDecimals(doubleNumberToRound) ); 

        //assert
        assertEquals("0.0",stringNumberRounded);
    }

    @Test
    public void RounderDecimal_DecimalNumber_RoundedDownZeroUp() throws Exception {
        //arrange
        double doubleNumberToRound = 0.0059;
        String stringNumberRounded; 

        //act 
        stringNumberRounded = String.valueOf( rounderDecimal.formatDecimals(doubleNumberToRound) ); 

        //assert
        assertEquals("0.01",stringNumberRounded);
    }    


    @Test
    public void RounderDecimal_DecimalNumber_RoundedDownZeroDown() throws Exception {
        //arrange
        double doubleNumberToRound = 0.0049;
        String stringNumberRounded; 

        //act 
        stringNumberRounded = String.valueOf( rounderDecimal.formatDecimals(doubleNumberToRound) ); 

        //assert
        assertEquals("0.0",stringNumberRounded);
    } 
}