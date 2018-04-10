package ShoppingCartPack;

import ShoppingCartPack.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ShoppingCartFullParameterizedTest {

    private int personAge;
    private int hourOfDay;
    private double totalPriceProduct1;
    private double totalPriceProduct2;
    private double offerPriece;

    public ShoppingCartFullParameterizedTest(int personAge, int hourOfDay, double totalPriceProduct1, double totalPriceProduct2, double offerPriece) {
        this.personAge = personAge;
        this.hourOfDay = hourOfDay;
        this.totalPriceProduct1 = totalPriceProduct1;
        this.totalPriceProduct2 = totalPriceProduct2;
        this.offerPriece = offerPriece;
    }

    @Parameterized.Parameters(name = "testApplyBestPriceOfferForRegularDay{index}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {11, 1, 100, 50, 127.5},
                {11, 21, 100, 50, 120},
                {40, 1, 100, 50, 150},
                {40, 21, 100, 50, 120},
                {80, 1, 100, 50, 120},
                {80, 21, 100, 50, 120}
        });
    }

    @Test
    public void testApplyBestPriceOfferForRegularDay(){
        ShoppingCart cart = new ShoppingCart();

        cart.addOffer(new ByAgeOffer(new Person(personAge,"Ion" )));
        cart.addOffer(new ByTimeOffer(hourOfDay));

        Product businessLunch =
                new Product("business lunch",totalPriceProduct1, 1);
        Product biscuits =
                new Product("biscuits",totalPriceProduct2,1);

        cart.addProduct(businessLunch);
        cart.addProduct(biscuits);

        Assert.assertEquals(offerPriece, cart.getTotalCartValue(), 0);
    }
}
