package ObserablePatternNotifyMe.Oberable;

import ObserablePatternNotifyMe.Oberver.StockNotificationObserver;

public interface InterfaceOverable {
    void addStockObserver(StockNotificationObserver observer);
    void removeStockOberver(StockNotificationObserver observer);
    void notifyStockObserver();
    boolean purchase(int quantity);
    void restock(int quantity);

}
