import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {
    @Test
    public void ingredientCanBeDifferent(){
        assertNotNull(IngredientType.valueOf("SAUCE"));
    }
    @Test
    public void ingredientCanBeDifferentTwo(){
        assertNotNull(IngredientType.valueOf("FILLING"));
    }
}
