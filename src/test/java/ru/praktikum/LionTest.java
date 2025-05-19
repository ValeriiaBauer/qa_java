package ru.praktikum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class LionTest {

    @Test
    void testGetKittens() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.getKittens()).thenReturn(1);

        Lion lion = new Lion(feline, "Самец");
        assertEquals(1, lion.getKittens());
        verify(feline).getKittens();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void testDoesHaveMane(String sex) throws Exception {
        Feline feline = mock(Feline.class);
        Lion lion = new Lion(feline, sex);

        if ("Самец".equals(sex)) {
            assertTrue(lion.doesHaveMane());
        } else {
            assertFalse(lion.doesHaveMane());
        }
    }

    @Test
    void testGetFood() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion(feline, "Самка");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
        verify(feline).eatMeat();
    }

    @Test
    void testInvalidSex() {
        Feline feline = mock(Feline.class);
        assertThrows(Exception.class, () -> new Lion(feline, "Неизвестный пол"));
    }
}