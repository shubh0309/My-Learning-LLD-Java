package ObserablePatternNotifyMe.Oberver;

public interface StockNotificationObserver {
    void update();
    String getNotificationMethod();
    String getUserId();
}
