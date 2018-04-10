package ShoppingCartPack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();
    private List<Offer> offers = new ArrayList<>();

    private double getBestPriceForProduct(Product product){
        double originalPrice = product.getTotalPriece();
        List<Double> prices = new ArrayList<>();
        offers.forEach(item -> {
            product.setTotalPriece(originalPrice);
            item.applyOffer(product);
            prices.add(product.getTotalPriece());
        });
        return Collections.min(prices);
    }

    public int getProductCount() {
        return products.size();
    }

    public double getTotalCartValue() {
        double sum = 0;
        for (Product product : products)  sum += product.getTotalPriece();
        return sum;
    }

    public int getTotalQuantity() {
        int sum = 0;
        for (Product product : products) sum += product.getQuantity();
        return sum;
    }

    public void addOffer(Offer offer) {
        offers.add(offer);
    }

    public void addProduct(Product product) {
        if (product.isValid()){
            if(offers.size() != 0) {
                product.setTotalPriece(getBestPriceForProduct(product));
            }
            products.add(product);
        }
    }

}
