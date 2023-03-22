
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import praktikum.Bun;
import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class BunParametrizedTest {
    private final String  name;
    private final float price;

    public BunParametrizedTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] dataBase(){
        return  new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {"", -100},
                {null, 0},
                {"!@#$%^&*", 100},
                {"black bun", 101},
                {"black bun", 99},
        };
    }
    @Test
    public void getValidName(){
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        assertEquals(name, actualName);
    }
    @Test
    public  void getValidPrice(){
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        assertEquals(price, actualPrice, 0);
    }
}