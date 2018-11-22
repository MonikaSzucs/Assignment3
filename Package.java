
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
    private double  weightPounds = 0.25;
    private String  originCity;
    private String  destinationCity;
    private String  trackingWebpage = "http://www.trackpackage.com";
    
    

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
        else{
            throw new IllegalArgumentException("Not valid");
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
            throw new IllegalArgumentException("Not valid");
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
            throw new IllegalArgumentException("Not valid");
        }
    }
    
    public double getWeight(){
        return weightPounds;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setWeightPounds(double weightPounds)
    {
        if(weightPounds>=0.0 && weightPounds<=100.0 ){
            this.weightPounds = weightPounds;
        }
        else{
            throw new IllegalArgumentException("Not valid");
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
        if(originCity==null){
            this.originCity = originCity;
        }
        else{
            throw new IllegalArgumentException("Not valid");
        }
    }
    
    public String getDestCity(){
        return destinationCity;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setDestinationCity(String destinationCity)
    {
        if(destinationCity==null){
            this.destinationCity = destinationCity;
        }
        else{
            throw new IllegalArgumentException("Not valid");
        }
    }
    
    public String getTrackingPage(){
        return trackingWebpage;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setTrackingWebpage(String trackingWebpage)
    {
        if(trackingWebpage==null){
            this.trackingWebpage = trackingWebpage;
        }
        else{
            throw new IllegalArgumentException("Not valid");
        }
    }
    
    public String getPackageDetails(){
        return "Package " + getTrackingCode() + " ships from " + getOriginCity() + " to " + getDestCity() + " for " + getShippingPrice() + 
        " with priority " + getPriority() + " and weight of " + getWeight() + ". Tracking details at " + getTrackingPage();
    }
}
