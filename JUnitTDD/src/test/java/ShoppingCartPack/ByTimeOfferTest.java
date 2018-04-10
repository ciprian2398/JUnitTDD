package ShoppingCartPack;

import ShoppingCartPack.ByTimeOffer;
import ShoppingCartPack.Offer;
import ShoppingCartPack.Product;
import org.junit.Assert;
import org.junit.Test;

public class ByTimeOfferTest {
    @Test
    public void testApplyOfferDay(){
        Offer byTimeOffer = new ByTimeOffer(2);
        Product businessLunch =
                new Product("business lunch",30, 1);

        byTimeOffer.applyOffer(businessLunch);
        Assert.assertEquals(30, businessLunch.getTotalPriece(), 0);
    }

    @Test
    public void testApplyOfferEvening(){
        Offer byTimeOffer = new ByTimeOffer(18);
        Product businessLunch =
                new Product("business lunch",30, 1);

        byTimeOffer.applyOffer(businessLunch);
        Assert.assertEquals(24, businessLunch.getTotalPriece(), 0);
    }
}
