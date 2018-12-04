
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
    private final   int     trackingCode;
    private int     priority = 2;
    private double  shippingPrice;
    private double  weight = 0.25;
    private String  originCity;
    private String  destCity;
    private String  trackingPage = "http://www.trackpackage.com";
    
    

    /**
     * Constructor for objects of class Package
     * 
     * @param trackingCode will contain the tracking code.
     * @param shippingPrice will contain the shipping price.
     * @param originCity will contain the name of the origin city.
     * @param destinationCity will contain the name of the destination city.
     * 
     */
    public Package(int trackingCode, double shippingPrice, String originCity, String destinationCity)
    {
        // initialise instance variables
        if(trackingCode>=MIN_TRACKING_CODE && trackingCode<=MAX_TRACKING_CODE){
            this.trackingCode = trackingCode;
        }else if(trackingCode>MAX_TRACKING_CODE){
            throw new IllegalArgumentException("Sorry, tracking code " + trackingCode + " is too large.");
        }
        else {
            throw new IllegalArgumentException("Sorry, tracking code cannot be negative.");
        }

        setShippingPrice(shippingPrice);
        setOriginCity(originCity);
        setDestinationCity(destinationCity);
    }
    
    /**
     * Constructor for objects of class Package.
     * 
     * @param trackingCode will contain the tracking code.
     * @param priority will contain the number priority 1, 2 or 3.
     * @param shippingPrice will contain the shipping price.
     * @param weightPounds will contain the weight in pounds.
     * @param originCity will contain the name of the origin city.
     * @param destinationCity will contain the name of the destination city.
     * @param trackingWebPage will contain the link to the tracking web page.
     * 
     */
    public Package(int trackingCode, int priority, double shippingPrice, double weightPounds, String originCity, String destinationCity, String trackingWebpage)
    {
        // initialise instance variables
        if(trackingCode>=MIN_TRACKING_CODE && trackingCode<=MAX_TRACKING_CODE){
            this.trackingCode = trackingCode;
        }else if(trackingCode>MAX_TRACKING_CODE){
            throw new IllegalArgumentException("Sorry, tracking code " + trackingCode + " is too large.");
        }
        else{
            throw new IllegalArgumentException("Sorry, tracking code cannot be negative.");
        }

        setPriority(priority);
        setShippingPrice(shippingPrice);
        setWeightPounds(weightPounds);
        setOriginCity(originCity);
        setDestinationCity(destinationCity);
        setTrackingWebpage(trackingWebpage);
    }
    
    /**
     * Accessor
     * @return the tracking code.
     */
    public int getTrackingCode(){
        return trackingCode;
    }
    
    /**
     * Accessor
     * @return the priority.
     */
    public int getPriority(){
        return priority;
    }
    
    /**
     * Mutator Method
     * @param  priority the proiority of the package
     */
    public void setPriority(int priority)
    {
        if(priority==MIN_PRIORITY || priority==this.priority || priority==MAX_PRIORITY){
            this.priority = priority;
        }
        else{
            throw new IllegalArgumentException("Priority must be either " + MIN_PRIORITY + ", " + this.priority + " or " + MAX_PRIORITY + ".");
        }
    }
    
    /**
     * Accessor
     * @return the shipping price.
     */
    public double getShippingPrice(){
        return shippingPrice;
    }
    
    /**
     * Mutator Method
     * @param  shippingPrice is the price for shipping.
     */
    public void setShippingPrice(double shippingPrice)
    {
        if(shippingPrice>=MIN_SHIPPING_PRICE){
            this.shippingPrice = shippingPrice;
        }
        else{
            throw new IllegalArgumentException("Shipping Price cannot be negative.");
        }
    }
    
    /**
     * Accessor
     * @return the weight of the package.
     */
    public double getWeight(){
        return weight;
    }
    
    /**
     * Mutator Method
     * @param  weight is the weight of the package in pounds.
     */
    public void setWeightPounds(double weight)
    {
        if(weight>=MIN_WEIGHT && weight<=MAX_WEIGHT ){
            this.weight = weight;
        }
        else{
            throw new IllegalArgumentException("Weight must be between " + MIN_WEIGHT + " and " + MAX_WEIGHT + "lbs.");
        }
    }
    
    /**
     * Accessor
     * @return the origin city.
     */
    public String getOriginCity(){
        return originCity;
    }
    
    /**
     * Mutator Method
     * @param  originCity is the origin of the city.
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
    
    /**
     * Accessor
     * @return the origin city.
     */
    public String getDestCity(){
        return destCity;
    }
    
    /**
     * Mutator Method
     * @param  destCity is the destination city.
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
    
    /**
     * Accessor
     * @return the tracking page.
     */
    public String getTrackingPage(){
        return trackingPage;
    }
    
    /**
     * Mutator Method
     * @param  destCity is the destination city.
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
    
    /**
     * Mutator Method
     * 
     * returns a sentence containing all the package details.
     * 
     */
    public String getPackageDetails(){
        return "Package " + getTrackingCode() + " ships from " + getOriginCity() + " to " + getDestCity() + " for $" + getShippingPrice() + 
        " with priority " + getPriority() + " and weight of " + getWeight() + "lbs. Tracking details at " + getTrackingPage() + ".";
    }
}
