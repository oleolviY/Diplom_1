import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static java.lang.Enum.valueOf;
import static org.junit.Assert.*;
import static praktikum.Constants.FILLING_NAME;
import static praktikum.Constants.FILLING_PRICE;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(FILLING, FILLING_NAME, FILLING_PRICE);
    }

    @Test
    public void getTypeTest() {
        IngredientType actualType = ingredient.getType();
        assertEquals(FILLING, actualType);
    }
    @Test
    public void getNameTest(){
        String actualName = ingredient.getName();
        assertEquals(FILLING_NAME, actualName);
    }

    @Test
    public void getPriceTest() {
        float actualPrice = ingredient.getPrice();
        assertEquals(FILLING_PRICE, actualPrice, 0.0);
    }

}
