package ShoppingCartPack;

public class Product {
    private String productName;
    private double totalPriece;
    private int quantity;

    public Product(String productName, double totalPriece, int quantity) {
        this.productName = productName;
        this.totalPriece = totalPriece;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public double getTotalPriece() {
        return totalPriece;
    }

    public void setTotalPriece(double totalPriece) {
        this.totalPriece = totalPriece;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isValid(){
        if(!productName.isEmpty() && totalPriece>0 && quantity>0) return true;
        return false;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
