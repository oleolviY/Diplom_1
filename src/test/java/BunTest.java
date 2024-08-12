import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
import static praktikum.Constants.BUN_NAME;
import static praktikum.Constants.BUN_PRICE;

public class BunTest {

    @Test
    public void getNameTest() {
        Bun bun = new Bun(BUN_NAME, BUN_PRICE);
        assertEquals(BUN_NAME, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(BUN_NAME, BUN_PRICE);
        assertEquals(BUN_PRICE, bun.getPrice(), 0.0);
    }
}