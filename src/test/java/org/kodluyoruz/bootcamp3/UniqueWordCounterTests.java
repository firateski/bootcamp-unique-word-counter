package org.kodluyoruz.bootcamp3;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniqueWordCounterTests {
    @Test
    public void countNumberOfUniqueWords_whenInputIsEmpty_shouldReturnZero() {
        // Arrange
        UniqueWordCounter uniqueWordCounter = new UniqueWordCounter();

        // Act
        int output = uniqueWordCounter.countNumberOfUniqueWords("");

        // Assert
        assertEquals(0, output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testInputData.csv")
    public void countNumberOfUniqueWords_whenAllTestInputsAreValid_shouldPass(String input, int expectedResult){

        // Arrange
        UniqueWordCounter uniqueWordCounter = new UniqueWordCounter();

        // Act
        int output = uniqueWordCounter.countNumberOfUniqueWords(input);

        // Assert
        Assertions.assertEquals(expectedResult, output);
    }
}
