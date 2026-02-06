package NotifyMe;

import NotifyMe.Oberable.IphoneProductObservable;
import NotifyMe.Oberver.EmailNotificationObserver;

import NotifyMe.Oberver.StockNotificationObserver;

public class ECommerceStockNotificationApp {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("###### E-commerce Store - Stock Availability Notification Feature Demo ######");
        // Create an iPhone product - stock available = 10 units
        IphoneProductObservable iphoneProduct = new IphoneProductObservable("ip15", "iphone 15", 1250, 10);
        StockNotificationObserver  shubham = new EmailNotificationObserver("123", "ShubhamPandey3.9@gmail.com");
        StockNotificationObserver aman = new EmailNotificationObserver("124", "aman3.9@gmail.com");
        iphoneProduct.purchase(10);
        boolean success = iphoneProduct.purchase(1);
        if(!success){
            iphoneProduct.addStockObserver(shubham);
            iphoneProduct.addStockObserver(aman);
        }
        // Restock 20 units of iPhone 15
//        iphoneProduct.restock(20);
//        iphoneProduct.purchase(2);
        System.out.println("Number of iphone left : "+iphoneProduct.getStockQuantity());
        iphoneProduct.restock(10);
    }
}
