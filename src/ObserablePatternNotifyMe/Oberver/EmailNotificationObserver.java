package ObserablePatternNotifyMe.Oberver;
public class EmailNotificationObserver implements StockNotificationObserver  {
    private String userId;
    private String emailId;
    public EmailNotificationObserver(String uerId, String emailId){
        this.userId = userId;
        this.emailId = emailId;
    }

    @Override
    public void update() {
        sendEmail();
    }
    private void sendEmail() {
        System.out.println("!! EMAIL SENT to: " + emailId + " - " + "Product is back in stock! Hurry Up!!");
    }
    @Override
    public String getNotificationMethod() {
        return "Email";
    }
    @Override
    public String getUserId() {
        return userId;
    }


}
