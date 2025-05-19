package ru.praktikum;


import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CatTest {

    @Test
    void testGetSound() {
        Feline feline = mock(Feline.class);
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void testGetFood() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Cat cat = new Cat(feline);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
        verify(feline).eatMeat();
    }
}