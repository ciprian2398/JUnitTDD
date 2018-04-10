package ShoppingCartPack;

public class ByTimeOffer implements ShoppingCartPack.Offer {

    private int hourOfDay;

    public ByTimeOffer(int hourOfDay) {
        this.hourOfDay = hourOfDay;
    }

    @Override
    public void applyOffer(ShoppingCartPack.Product product) {
        double discount = hourOfDay >= 18 ? 20 : 0;
        product.setTotalPriece( (100-discount) / 100 * product.getTotalPriece() );
    }
}
