package ShoppingCartPack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ByAgeOfferTest.class,
        ByTimeOfferTest.class,
        ShoppingCartTest.class,
        ShoppingCartParameterizedTest.class,
        ShoppingCartFullParameterizedTest.class
})

public class JUnitTestSuite {
    @Test
    public void test(){

    }
}
