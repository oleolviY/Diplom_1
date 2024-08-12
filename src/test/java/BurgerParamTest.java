package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class BurgerParamTest {

    @Mock
    private Ingredient ingredients;

    @Mock
    private Bun bun;

    private float ingredientsPrice;

    private float bunPrice;

    private float expectedPrice;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    public BurgerParamTest(float ingredientsPrice, float bunPrice, float expectedPrice) {
        this.ingredientsPrice = ingredientsPrice;
        this.bunPrice = bunPrice;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {10.0f, 10.0f, 30.0f},
                {20.0f, 10.0f, 40.0f}
        };
    }

    @Test
    public void burgerGetPriceTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredients.getPrice()).thenReturn(ingredientsPrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredients);
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.0);
    }
}