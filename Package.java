
/**
 * Write a description of class Package here.
 *
 * @author Monika Szucs
 * @version November 22, 2018
 */
public class Package
{
    public static final double MIN_WEIGHT = 0.0;
    public static final double MAX_WEIGHT = 100.0;
    public static final int MIN_PRIORITY = 1;
    public static final int MAX_PRIORITY = 3;
    public static final int MIN_TRACKING_CODE = 0;
    public static final int MAX_TRACKING_CODE = 1000000000;
    public static final double MIN_SHIPPING_PRICE = 0;
    
    // instance variables - replace the example below with your own
    private int     trackingCode;
    private int     priority = 2;
    private double  shippingPrice;
    private double  weight = 0.25;
    private String  originCity;
    private String  destCity;
    private String  trackingPage = "http://www.trackpackage.com";
    
    

    /**
     * Constructor for objects of class Package
     */
    public Package(int trackingCode, double shippingPrice, String originCity, String destinationCity)
    {
        // initialise instance variables
        setTrackingCode(trackingCode);
        setShippingPrice(shippingPrice);
        setOriginCity(originCity);
        setDestinationCity(destinationCity);
    }
    
    /**
     * Constructor for objects of class Package
     */
    public Package(int trackingCode, int priority, double shippingPrice, double weightPounds, String originCity, String destinationCity, String trackingWebpage)
    {
        // initialise instance variables
        setTrackingCode(trackingCode);
        setPriority(priority);
        setShippingPrice(shippingPrice);
        setWeightPounds(weightPounds);
        setOriginCity(originCity);
        setDestinationCity(destinationCity);
        setTrackingWebpage(trackingWebpage);
    }
  
    public int getTrackingCode(){
        return trackingCode;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setTrackingCode(int trackingCode)
    {
        if(trackingCode>=0 && trackingCode<=1000000000){
            this.trackingCode = trackingCode;
        }
        else if(trackingCode>1000000000){
            throw new IllegalArgumentException("Sorry, tracking code " + trackingCode + " is too large.");
        }
        else{
            throw new IllegalArgumentException("Sorry, tracking code cannot be negative.");
        }
    }
    
    
    public int getPriority(){
        return priority;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setPriority(int priority)
    {
        if(priority==MIN_PRIORITY || priority==this.priority || priority==MAX_PRIORITY){
            this.priority = priority;
        }
        else{
            throw new IllegalArgumentException("Priority must be either 1, 2 or 3.");
        }
    }
    
    public double getShippingPrice(){
        return shippingPrice;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setShippingPrice(double shippingPrice)
    {
        if(shippingPrice>=0){
            this.shippingPrice = shippingPrice;
        }
        else{
            throw new IllegalArgumentException("Shipping Price cannot be negative.");
        }
    }
    
    public double getWeight(){
        return weight;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setWeightPounds(double weight)
    {
        if(weight>=0.0 && weight<=100.0 ){
            this.weight = weight;
        }
        else{
            throw new IllegalArgumentException("Weight must be between 0.0 and 100.0lbs.");
        }
    }
    
    public String getOriginCity(){
        return originCity;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setOriginCity(String originCity)
    {
        if(originCity!=null && !originCity.equals("")){
            this.originCity = originCity;
        }else if(originCity==null){
            throw new IllegalArgumentException("The Origin City is not valid.");
        }
        else{
            throw new IllegalArgumentException("The Origin City is not set.");
        }
    }
    
    public String getDestCity(){
        return destCity;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setDestinationCity(String destCity)
    {
        if(destCity!=null && !destCity.equals("")){
            this.destCity = destCity;
        }else if(destCity==null){
            throw new IllegalArgumentException("The Destination City is not valid.");
        }
        else{
            throw new IllegalArgumentException("The Destination City is not set.");
        }
    }
    
    public String getTrackingPage(){
        return trackingPage;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setTrackingWebpage(String trackingPage)
    {
        if(trackingPage!=null && !trackingPage.equals("")){
            this.trackingPage = trackingPage;
        }else if(trackingPage==null){
            throw new IllegalArgumentException("The Tracking Page is not valid.");
        }
        else{
            throw new IllegalArgumentException("The Tracking Page is not set.");
        }
    }
    
    public String getPackageDetails(){
        return "Package " + getTrackingCode() + " ships from " + getOriginCity() + " to " + getDestCity() + " for " + getShippingPrice() + 
        " with priority " + getPriority() + " and weight of " + getWeight() + ". Tracking details at " + getTrackingPage();
    }
}
