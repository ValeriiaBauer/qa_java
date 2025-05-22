package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @InjectMocks
    private Cat cat;

    @Test
    public void getSoundShouldReturnMeow() {
        String actualSound = cat.getSound();
        assertEquals("Мяу", actualSound);
    }

    @Test
    public void getFoodShouldCallEatMeatOnFeline() throws Exception {
        cat.getFood();
        verify(feline).eatMeat();
    }

    @Test
    public void getFoodShouldReturnCorrectFoodList() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void getFoodShouldPropagateExceptionFromFeline() throws Exception {
        when(feline.eatMeat()).thenThrow(new Exception("Ошибка Feline"));
        cat.getFood();
    }
}