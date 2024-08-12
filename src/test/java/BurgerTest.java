import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.Constants.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient ingredientOne;

    @Mock
    Ingredient ingredientTwo;

    @Mock
    Bun bun;

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();

        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);

        Mockito.when(ingredientOne.getName()).thenReturn(SAUCE_NAME);
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientOne.getPrice()).thenReturn(SAUCE_PRICE);

        Mockito.when(ingredientTwo.getName()).thenReturn(FILLING_NAME);
        Mockito.when(ingredientTwo.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(FILLING_PRICE);

        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : burger.ingredients) {
            expectedReceipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        expectedReceipt.append(String.format("(==== %s ====)%n", bun.getName()));
        expectedReceipt.append(String.format("%nPrice: %f%n", BURGER_PRICE));
        Assert.assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.removeIngredient(0);
        assertEquals(ingredientTwo, burger.ingredients.get(0));
        int exIngredientsSize = 1;
        assertEquals(exIngredientsSize, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(0, 1);
        assertEquals(ingredientTwo, burger.ingredients.get(0));
        int exIngredientsSize = 2;
        assertEquals(exIngredientsSize, burger.ingredients.size());
    }
}