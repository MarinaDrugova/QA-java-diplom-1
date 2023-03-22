import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static java.lang.String.format;
import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Before
    public void newBurger() {
        burger = new Burger();
    }
    @Test
public void setBuns(){
        Bun bun = Mockito.mock(Bun.class);
        burger.setBuns(bun);
        Bun actual = burger.bun;
        assertEquals(bun, actual);
    }
    @Test
    public void addIngredientYouCan(){
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }
    @Test
    public void removeIngredientYouCan(){
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        Assert.assertEquals(1,burger.ingredients.size());
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }
    @Test
    public void moveIngredientYouCan(){
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Ingredient springIngredient = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient.getName()).thenReturn("FILLING");
        burger.addIngredient(ingredient);
        burger.addIngredient(springIngredient);
        burger.moveIngredient(1, 0);
        String expectedNewBurger = "FILLING";
        assertEquals(expectedNewBurger, burger.ingredients.get(1).getName());
    }
    @Test
    public void getValidPriceBurger(){
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        Mockito.when(bun.getPrice()).thenReturn(190f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPriceBurger = 480;
        assertEquals(expectedPriceBurger, burger.getPrice(), 0);
    }
    @Test
    public void getValidReceipt(){
        Mockito.when(bun.getName()).thenReturn("Hot Burger");
        Mockito.when(ingredient.getName()).thenReturn("Spicy");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(burger.getPrice()).thenReturn(480f);
        String expectedReceipt = String.format("%s%s%s%s", format("(==== Hot Burger ====)%n", bun.getName()), format("= %s %s =%n",
                burger.ingredients.get(0).getType().toString().toLowerCase(),
                burger.ingredients.get(0).getName()), format("(==== %s ====)%n", "Hot Burger"), format("%nPrice: %f%n", burger.getPrice()));
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}