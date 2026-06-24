package com.sample;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AAAPattern {

    private AAAPattern posChecker;

    @Before
    public void setUp() {
        posChecker = new AAAPattern();
        System.out.println("Setup completed");
    }

    @After
    public void tearDown() {
        posChecker = null;
        System.out.println("Cleanup completed");
    }

    public boolean isPositive(int num) {
        return num > 0;
    }

    @Test
    public void testPositiveNumber() {

        // Arrange
        int number = 10;

        // Act
        boolean result = posChecker.isPositive(number);

        // Assert
        assertTrue(result);
    }
}