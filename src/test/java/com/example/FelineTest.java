package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void testEatMeatReturnsCorrectFoodList() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals("Метод eatMeat() должен возвращать список мяса для хищников",
                expectedFood, actualFood);
    }

    @Test
    public void testGetFamilyReturnsCorrectValue() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals("Метод getFamily() должен возвращать 'Кошачьи'",
                expectedFamily, actualFamily);
    }

    @Test
    public void testGetKittensWithoutParametersReturnsOne() {
        Feline feline = new Feline();
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        assertEquals("Метод getKittens() без параметров должен возвращать 1",
                expectedKittens, actualKittens);
    }

    @Test
    public void testGetKittensWithParameterReturnsSameValue() {
        Feline feline = new Feline();
        int testCount = 3;
        int actualKittens = feline.getKittens(testCount);
        assertEquals("Метод getKittens(count) должен возвращать переданное значение",
                testCount, actualKittens);
    }

    @Test
    public void testGetKittensCallsOverloadedMethod() {
        Feline feline = new Feline() {
            @Override
            public int getKittens(int kittensCount) {
                return kittensCount * 2; // Модифицируем для теста
            }
        };
        int result = feline.getKittens();
        assertEquals("Метод getKittens() должен вызывать getKittens(1)",
                2, result); // 1*2=2
    }
}