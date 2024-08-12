package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class EnumTest {
    @Test
    public void testEnum(){
        Assert.assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }
}
