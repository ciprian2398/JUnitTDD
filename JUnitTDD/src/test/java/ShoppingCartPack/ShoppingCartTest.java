package ShoppingCartPack;

import ShoppingCartPack.ShoppingCart;
import org.junit.*;
import org.junit.rules.Timeout;
import org.junit.runners.Parameterized;

public class ShoppingCartTest {
    
    private ShoppingCart cart;
    
    @Before
    public void init(){
        cart = new ShoppingCart();
    }
    
    @Rule
    public Timeout globalTimeout = Timeout.millis(5000);

    @Test
    public void testAddProductToChart(){
        
        ShoppingCartPack.Product businessLunch =
                new ShoppingCartPack.Product("business lunch",30, 1);
        cart.addProduct(businessLunch);
        Assert.assertEquals(1, cart.getProductCount());
    }

    @Test
    public void testProductsToChart(){
        
        ShoppingCartPack.Product businessLunch =
                new ShoppingCartPack.Product("business lunch",30, 1);
        cart.addProduct(businessLunch);
        ShoppingCartPack.Product tea =
                new ShoppingCartPack.Product("tea",100, 1);
        cart.addProduct(tea);
        Assert.assertEquals(2, cart.getProductCount());
    }

    @Test
    public void testTotalCartValue(){
        
        ShoppingCartPack.Product businessLunch =
                new ShoppingCartPack.Product("business lunch",30, 1);
        cart.addProduct(businessLunch);
        ShoppingCartPack.Product tea =
                new ShoppingCartPack.Product("tea",100, 2);
        cart.addProduct(tea);
        Assert.assertEquals(2, cart.getProductCount());
        Assert.assertEquals(130.0, cart.getTotalCartValue(), 0.0);
    }


    @Test
    public void testTotalQuantity(){
        
        ShoppingCartPack.Product businessLunch =
                new ShoppingCartPack.Product("business lunch",30, 1);
        cart.addProduct(businessLunch);
        ShoppingCartPack.Product tea =
                new ShoppingCartPack.Product("tea",100, 2);
        cart.addProduct(tea);
        Assert.assertEquals(2, cart.getProductCount());
        Assert.assertEquals(130.0, cart.getTotalCartValue(), 0.0);
        Assert.assertEquals(3, cart.getTotalQuantity());
    }

    @Test
    public void testOfferForYoung(){
        

        ShoppingCartPack.Person personIon = new ShoppingCartPack.Person(10,"Ion" );
        ShoppingCartPack.Offer byAgeOffer = new ShoppingCartPack.ByAgeOffer(personIon);
        cart.addOffer(byAgeOffer);

        ShoppingCartPack.Product businessLunch =
                new ShoppingCartPack.Product("business lunch",30, 1);
        cart.addProduct(businessLunch);

        Assert.assertEquals(25.5, cart.getTotalCartValue(), 0.0);
    }


    @Test
    public void testOfferForOld(){
        

        ShoppingCartPack.Person personIon = new ShoppingCartPack.Person(65,"Ion" );
        ShoppingCartPack.Offer byAgeOffer = new ShoppingCartPack.ByAgeOffer(personIon);
        cart.addOffer(byAgeOffer);

        ShoppingCartPack.Product businessLunch =
                new ShoppingCartPack.Product("business lunch",30, 1);
        cart.addProduct(businessLunch);

        Assert.assertEquals(24.00, cart.getTotalCartValue(), 0.0);
    }

    @Test
    public void testOfferForRegular(){
        

        ShoppingCartPack.Person personIon = new ShoppingCartPack.Person(40,"Ion" );
        ShoppingCartPack.Offer byAgeOffer = new ShoppingCartPack.ByAgeOffer(personIon);
        cart.addOffer(byAgeOffer);

        ShoppingCartPack.Product businessLunch =
                new ShoppingCartPack.Product("business lunch",30, 1);
        cart.addProduct(businessLunch);

        Assert.assertEquals(30, cart.getTotalCartValue(), 0.0);
    }

    @Test
    public void testApplyOfferDay(){

        
        ShoppingCartPack.Offer byTimeOffer = new ShoppingCartPack.ByTimeOffer(2);

        ShoppingCartPack.Product businessLunch =
                new ShoppingCartPack.Product("business lunch",30, 1);

        cart.addOffer(byTimeOffer);

        byTimeOffer.applyOffer(businessLunch);
        Assert.assertEquals(30, businessLunch.getTotalPriece(), 0);
    }

    @Test
    public void testApplyOfferEvening(){

        
        ShoppingCartPack.Offer byTimeOffer = new ShoppingCartPack.ByTimeOffer(19);

        ShoppingCartPack.Product businessLunch =
                new ShoppingCartPack.Product("business lunch",30, 1);

        cart.addOffer(byTimeOffer);
        byTimeOffer.applyOffer(businessLunch);
        Assert.assertEquals(24, businessLunch.getTotalPriece(), 0);
    }

    //begin testing with more offers

    @Test
    public void testApplyBestPriceOffer(){

        ShoppingCartPack.Offer byAgeOffer = new ShoppingCartPack.ByAgeOffer(new ShoppingCartPack.Person(40,"Ion" ));
        cart.addOffer(byAgeOffer);

        ShoppingCartPack.Offer byTimeOffer = new ShoppingCartPack.ByTimeOffer(19);
        cart.addOffer(byTimeOffer);

        ShoppingCartPack.Product businessLunch =
                new ShoppingCartPack.Product("business lunch",30, 1);

        cart.addProduct(businessLunch);
        Assert.assertEquals(24, cart.getTotalCartValue(), 0);
    }


    @Test
    public void testApplyBestPriceOfferForOldAtNight(){


        cart.addOffer(new ShoppingCartPack.ByAgeOffer(new ShoppingCartPack.Person(14,"Ion" )));
        cart.addOffer(new ShoppingCartPack.ByTimeOffer(19));

        ShoppingCartPack.Product businessLunch =
                new ShoppingCartPack.Product("business lunch",100, 1);

        cart.addProduct(businessLunch);

        Assert.assertEquals(80, cart.getTotalCartValue(), 0);
    }


    @Test
    public void testApplyBestPriceOfferForRegularDay(){
        

        cart.addOffer(new ShoppingCartPack.ByAgeOffer(new ShoppingCartPack.Person(40,"Ion" )));
        cart.addOffer(new ShoppingCartPack.ByTimeOffer(13));

        ShoppingCartPack.Product businessLunch =
                new ShoppingCartPack.Product("business lunch",100, 1);

        cart.addProduct(businessLunch);

        Assert.assertEquals(100, cart.getTotalCartValue(), 0);
    }

    @Test
    public void testIsValidNotPerson(){
        Person person = new Person( -1,"");
        Assert.assertEquals(false, person.isValid());
    }

    @Test
    public void testIsValidNotConditionalPerson(){
        Person person = new Person( 0,"SS");
        Assert.assertEquals(false, person.isValid());
    }

    @Test
    public void testIsValidNotConditionalPerson1(){
        Person person = new Person( 200,"SS");
        Assert.assertEquals(false, person.isValid());
    }

    @Test
    public void testPersonGetName(){
        String ss = "SS";
        Person person = new Person( 200,"SS");

        Assert.assertEquals(ss, person.getName());
    }

    @Test
    public void testGetProductName(){
        String ss = "SS";
        Product product = new Product(ss,1,1);

        Assert.assertEquals(ss, product.getProductName());
    }

    @Test
    public void testIsValidProduct(){
        Product product = new Product("n",1,1);
        Assert.assertEquals(true, product.isValid());
    }

    @Test
    public void testIsValidProduct1(){
        Product product = new Product("n",1,1);
        Assert.assertEquals(true, product.isValid());
    }

    @Test
    public void testIsValidProduct2(){
        Product product = new Product("",1,1);
        Assert.assertEquals(false, product.isValid());
    }

    @Test
    public void testIsValidProduct3(){
        Product product = new Product("n",0,1);
        Assert.assertEquals(false, product.isValid());
    }

    @Test
    public void testIsValidProduct4(){
        Product product = new Product("n",1,0);
        Assert.assertEquals(false, product.isValid());
    }

    @Test
    public void testIsValidProduct5(){
        Product product = new Product("",0,1);
        Assert.assertEquals(false, product.isValid());
    }

    @Test
    public void testIsValidProduct6(){
        Product product = new Product("n",0,0);
        Assert.assertEquals(false, product.isValid());
    }




}
