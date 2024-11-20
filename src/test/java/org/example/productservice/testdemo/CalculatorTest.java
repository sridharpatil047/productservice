package org.example.productservice.testdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void add() {

        // Arrange
        int a = 10;
        int b = 10;

        // Act
        int result = calculator.add(a,b);

        // Assert
        Assertions.assertEquals(result,30);
    }

    @Test
    void divide(){
        // Arrange
        int a = 20;
        int b = 0;

        // Act
//        int result = calculator.divide(a, b);

        // Assert
//        Assertions.assertEquals(2, result);

        Assertions.assertThrows(Exception.class, () -> { calculator.divide(a, b); });

    }
}