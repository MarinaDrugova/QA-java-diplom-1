import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private IngredientType type;
    private String name;
    private float price;

    @Test
    public void getIngredientType(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualIngredient = ingredient.getType();
        IngredientType expectedIngredient = type;
        Assert.assertEquals(expectedIngredient, actualIngredient);
    }
    @Test
    public void getIngredientName(){
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualIngredientName = ingredient.getName();
        String expectedIngredientName = name;
        Assert.assertEquals(expectedIngredientName, actualIngredientName);
    }
    @Test
    public void getIngredientPrice(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualIngredientPrice = ingredient.getPrice();
        float expectedIngredientPrice = price;
        Assert.assertEquals(expectedIngredientPrice, actualIngredientPrice, 0);
    }
}
