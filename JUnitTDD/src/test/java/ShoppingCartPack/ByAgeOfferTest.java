package ShoppingCartPack;

import ShoppingCartPack.ByAgeOffer;
import ShoppingCartPack.Offer;
import ShoppingCartPack.Person;
import ShoppingCartPack.Product;
import org.junit.Assert;
import org.junit.Test;

public class ByAgeOfferTest {

    @Test
    public void testApplyOfferToYoung(){
        Person personIon = new Person(16 , "Ion");
        Offer byAgeOffer = new ByAgeOffer(personIon);

        Product businessLunch =
                new Product("business lunch",30, 1);

        byAgeOffer.applyOffer(businessLunch);
        Assert.assertEquals(25.5, businessLunch.getTotalPriece(), 0);
    }

    @Test
    public void testApplyOfferToRegular(){
        Person personIon = new Person(40 , "Ion");
        Offer byAgeOffer = new ByAgeOffer(personIon);

        Product businessLunch =
                new Product("business lunch",30, 1);

        byAgeOffer.applyOffer(businessLunch);
        Assert.assertEquals(30, businessLunch.getTotalPriece(), 0);
    }

    @Test
    public void testApplyOfferToOld(){
        Person personIon = new Person(60 , "Ion");
        Offer byAgeOffer = new ByAgeOffer(personIon);

        Product businessLunch =
                new Product("business lunch",30, 1);

        byAgeOffer.applyOffer(businessLunch);
        Assert.assertEquals(24, businessLunch.getTotalPriece(), 0);
    }

    @Test
    public void testApplyOfferToYoungZeroPrice(){
        Person personIon = new Person(60 , "Ion");
        Offer byAgeOffer = new ByAgeOffer(personIon);

        Product businessLunch =
                new Product("business lunch",0, 1);

        byAgeOffer.applyOffer(businessLunch);
        Assert.assertEquals(0, businessLunch.getTotalPriece(), 0);
    }


}
