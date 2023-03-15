
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private String name;
    private float price;

    @Test
    public void getValidName(){
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        String expectedName = name;
        Assert.assertEquals(expectedName, actualName);
    }
    @Test
    public  void getValidPrice(){
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        float expectedPrice = price;
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }
}