package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void maleLionShouldHaveMane() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void femaleLionShouldNotHaveMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void invalidSexShouldThrowException() throws Exception {
        new Lion("Неизвестный", feline);
    }

    @Test
    public void getKittensShouldCallFelineMethod() throws Exception {
        when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);

        int kittens = lion.getKittens();

        assertEquals(1, kittens);
        verify(feline).getKittens();
    }

    @Test
    public void getFoodShouldReturnMeatList() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самка", feline);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
    }
}