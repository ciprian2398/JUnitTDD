package ShoppingCartPack;

public class ByAgeOffer implements Offer {
    private Person person;

    public ByAgeOffer(Person person) {
        this.person = person;
    }

    @Override
    public void applyOffer(Product product) {
        if(person.isValid()){
            double youngDiscount = (person.getAge() <= 16) ? 15 : 0;
            double oldDiscount  = (person.getAge() >= 60) ? 20 : 0;

            double discount = youngDiscount  + oldDiscount ;

            product.setTotalPriece( ((100-discount) / 100) * product.getTotalPriece() );
        }

    }
}
