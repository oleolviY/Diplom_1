import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class EnumTest {
    @Test
    public void testEnum(){
        Assert.assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }
}
