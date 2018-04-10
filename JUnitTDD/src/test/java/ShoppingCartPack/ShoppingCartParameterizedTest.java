package ShoppingCartPack;

import ShoppingCartPack.Person;
import ShoppingCartPack.ShoppingCart;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)

public class ShoppingCartParameterizedTest {

    private double totalPrice;
    private int personAge;
    private double offerPrice;

    public ShoppingCartParameterizedTest(double totalPrice, int personAge, double offerPrice) {
        this.totalPrice = totalPrice;
        this.personAge = personAge;
        this.offerPrice = offerPrice;
    }

    @Parameterized.Parameters(name = " {index}: totalPrice:{0} personAge:{1}  offerPrice:{2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {100, 10, 85},
                {100, 40, 100},
                {100, 70, 80},
                {100, 1, 85},
                {0, 70, 0},
                {0, 0, 0}
        });
    }

    @Test
    public void testApplyBestPriceOfferParameterized(){
        ShoppingCart cart = new ShoppingCart();

        cart.addOffer(new ShoppingCartPack.ByAgeOffer(new Person(personAge,"Ion" )));

        ShoppingCartPack.Product businessLunch =
                new ShoppingCartPack.Product("business lunch",totalPrice, 1);

        cart.addProduct(businessLunch);

        Assert.assertEquals(offerPrice , cart.getTotalCartValue(), 0);
    }

}
