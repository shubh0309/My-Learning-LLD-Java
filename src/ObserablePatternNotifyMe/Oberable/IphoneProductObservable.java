package ObserablePatternNotifyMe.Oberable;

import ObserablePatternNotifyMe.Oberver.StockNotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneProductObservable implements InterfaceOverable{
    public List<StockNotificationObserver> stockObservers ;
    private String productId;
    private String productName;
    private double price;
    private int stockQuantity;

    public IphoneProductObservable( String productId, String productName, double price, int stockQuantity) {
        this.stockObservers = new ArrayList<>();
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    @Override
    public void addStockObserver(StockNotificationObserver observer) {
        stockObservers.add(observer);
    }

    @Override
    public void removeStockOberver(StockNotificationObserver observer) {
        stockObservers.remove(observer);
    }

    @Override
    public void notifyStockObserver() {
//        if(stockQuantity>0 && !stockObservers.isEmpty()){
            List<StockNotificationObserver> observerTobeNotify = new ArrayList<>(stockObservers);
            for(StockNotificationObserver observer : observerTobeNotify){
                observer.update();
            }
//        }
    }

    @Override
    public boolean purchase(int quantity) {
        if(stockQuantity>=quantity){
            stockQuantity -= quantity;
            System.out.println("Purchase Succesfull "+productName+" and number of units "+quantity);
            return true;
        }
        else{
            System.out.println("PURCHASE FAILED: " + productName + " is out of stock! | " + "Available Quantity: " + stockQuantity);
            return false;
        }
    }

    @Override
    public void restock(int quantity) {
//        if(stockQuantity == 0)
            notifyStockObserver();
        stockQuantity += quantity;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}
