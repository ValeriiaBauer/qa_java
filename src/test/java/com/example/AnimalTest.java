package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;


public class AnimalTest {

    private final Animal animal = new Animal();

    @Test
    public void getFoodForPredatorShouldReturnMeatList() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = animal.getFood("Хищник");
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodForHerbivoreShouldReturnPlantsList() throws Exception {
        List<String> expected = List.of("Трава", "Различные растения");
        List<String> actual = animal.getFood("Травоядное");
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodForUnknownTypeShouldThrowException() {
        Exception exception = assertThrows(Exception.class,
                () -> animal.getFood("Неизвестный"));

        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }

    @Test
    public void getFamilyShouldReturnCorrectDescription() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, " +
                "кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        assertEquals(expected, actual);
    }
}