
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class Warehouse here.
 *
 * @author Monika Szucs
 * @version November 22, 2018
 */
public class Warehouse
{
    // instance variables 
    private ArrayList<Package> packages;
    
    private int numPackages;
    private double valuePackage;

    /**
     * Constructor for objects of class Warehouse
     * 
     * Contains an array of Packages
     * 
     */
    public Warehouse(Package[] packs)
    {
        // initialise instance variables
        packages = new ArrayList<Package>();
        
        if(packs == null){
            throw new IllegalArgumentException("List of Packages cannot be null.");
        }
        
        for(Package priority : packs)
        {
            if(priority == null){
            throw new IllegalArgumentException("List of Packages cannot be null.");
        }
            
            for(Package prior : packages){
                if(priority.getTrackingCode() == prior.getTrackingCode())
                {
                    throw new IllegalArgumentException("Duplicate Tracking Code found: " + priority.getTrackingCode());
                }
            }
            packages.add(priority);
        }  

    }

    /**
     * Getting the number of Packages
     *
     *@return numPackages returns the number of packages
     *
     */
    public int getNumPackages()
    {
        // put your code here
        int numPackages;
        if(packages==null){
            numPackages = 0;
        } else {
            numPackages = packages.size();
        }
        return numPackages;
    }

    /**
     *
     * @return numPackageValue is the total package value.
     */
    public double getTotalPackageValue()
    {
        double  numPackageValue = 0.0;
        //ArrayList<Double> pkg = new ArrayList<Double>();

        for(Package values : packages)
        {
            if(values.getShippingPrice() >0.0){
                numPackageValue += values.getShippingPrice();
            }
                
        }

        return numPackageValue;
    }

    /**
     *
     * @param  packagePriority is the integer of the package priority.
     * @return packagePriority will return a null or the priority of the package.
     * 
     */
    public Package[] findPackagesByPriority(int packagePriority)
    {
        if(packagePriority<Package.MIN_PRIORITY){
            throw new IllegalArgumentException("Priority must be either " + Package.MIN_PRIORITY + ", " + Package.MID_PRIORITY + " or " + Package.MAX_PRIORITY +".");
        } else if(packagePriority>Package.MAX_PRIORITY){
            throw new IllegalArgumentException("Priority must be either " + Package.MIN_PRIORITY + ", " + Package.MID_PRIORITY + " or " + Package.MAX_PRIORITY +".");
        }
        
        int     index = 0; 
        int     numPriority = 0;

        Package[] priorityPackage;

        for(Package priority : packages)
        {
            if(priority != null && priority.getPriority() == packagePriority)
            {
                numPriority++;
            }
        }  

        if(numPriority > 0){
            priorityPackage = new Package[numPriority];
        }
        else{
            return null;
        }

        for(Package priority : packages)
        {
            if(priority != null && priority.getPriority() == packagePriority){
                priorityPackage[index] = priority;
                index++;
            }
                
        }

        return priorityPackage;
    }  
    
    /**
     * Method
     *
     * @param   packageAboveWeight is checking if the weight is above a certain number.
     * @return  newPackage the new packages in the array.
     * @return  priorityPackage is the packages that have the most priority.
     * 
     */
    public Package[] findPackagesAboveWeight(double packageAboveWeight)
    {
        if(packageAboveWeight<Package.MIN_WEIGHT || packageAboveWeight>Package.MAX_WEIGHT){
            throw new IllegalArgumentException("Weight must be between " + Package.MIN_WEIGHT +" and " + Package.MAX_WEIGHT + "lbs.");
        }
        
        int     index = 0; 
        int     numPackageAboveWeightPriority = 0;

        Package[] priorityPackage;
        Package[] newPackage = new Package[0];
        
        for(Package weight : packages)
        {
            if(weight != null && weight.getWeight()>packageAboveWeight)
            {
                numPackageAboveWeightPriority++;
            }
        }  

        if(numPackageAboveWeightPriority > 0){
            priorityPackage = new Package[numPackageAboveWeightPriority];
        }
        else{
            return newPackage;
        }

        for(Package weight : packages)
        {
            if(weight != null && weight.getWeight()>packageAboveWeight){
                priorityPackage[index] = weight;
                index++;
            }
                
        }

        return priorityPackage;
    } 
    
    /**
     * Method
     *
     * @param   packageBelowWeight is checking if the weight is above a certain number.
     * @return  null if the number of packages is below the weight priority.
     * @return  priorityPackage is the packages that have the most priority.
     * 
     */
    public Package[] findPackagesBelowWeight(double packageBelowWeight)
    {
        if(packageBelowWeight<Package.MIN_WEIGHT || packageBelowWeight>Package.MAX_WEIGHT){
            throw new IllegalArgumentException("Weight must be between " + Package.MIN_WEIGHT +" and " + Package.MAX_WEIGHT + "lbs.");
        }
        
        int     index = 0; 
        int     numPackageBelowWeightPriority = 0;

        Package[] priorityPackage;

        for(Package weight : packages)
        {
            if(weight != null && weight.getWeight()<packageBelowWeight)
            {
                numPackageBelowWeightPriority++;
            }
        }  

        if(numPackageBelowWeightPriority > 0){
            priorityPackage = new Package[numPackageBelowWeightPriority];
        }
        else{
            return null;
        }

        for(Package weight : packages)
        {
            if(weight != null && weight.getWeight()<packageBelowWeight){
                priorityPackage[index] = weight;
                index++;
            }
            
        }

        return priorityPackage;
    } 
    
    /**
     * Method
     *
     * @param   packageBelowWeight is checking if the weight is above a certain number.
     * @return  null if no tracking code was found that matches.
     * @return  sendablePackage if the trackingNumber matches the TrackingCode saved in packages.
     * 
     */
    public Package shipPackageByTrackingCode(int trackingNumber)
    {
        if(trackingNumber>=Package.MAX_TRACKING_CODE){
            throw new IllegalArgumentException("Sorry, tracking code " + trackingNumber + " is too large.");
        } else if(trackingNumber<=Package.MIN_TRACKING_CODE){
            throw new IllegalArgumentException("Sorry, tracking code " + trackingNumber + " cannot be negative.");
        }

        Iterator<Package> it = packages.iterator();
        
        while(it.hasNext()) {
            Package sendablePackage = it.next();

            if(trackingNumber == sendablePackage.getTrackingCode())
            {
                it.remove();
                return sendablePackage;
            }
        }
        
        return null;
    }
    
    /**
     * Method
     *
     * @param   destinationCity is the destination city.
     * @return  sent which is the packages that has been sent.
     * 
     */
    public Package[] shipPackagesByDestinationCity(String destinationCity)
    {
        if(destinationCity == null){
            throw new IllegalArgumentException("The Destination City is not valid.");
        }else if(destinationCity.equals("")){
            throw new IllegalArgumentException("The Destination City is not set.");
        }
        
        if(packages==null)
        {
            throw new IllegalArgumentException("The Packages cannot be null.");
        }
        
        ArrayList<Package> sentPackages = new ArrayList<Package>();
        Iterator<Package> it = packages.iterator();

        while(it.hasNext()) {
            Package sendablePackage = it.next();
            if(sendablePackage.getDestCity().equals(destinationCity))
            {
                sentPackages.add(sendablePackage);
                it.remove();
            }
        }
        
        Package [] sent = sentPackages.toArray(new Package[sentPackages.size()]);
        
        return sent;
        
    }
    
    /**
     * Method
     *
     * @param   pkg is the value entered in by the user to search through Package.
     * @return  will return nothing.
     * 
     */
    public void addPackage(Package pkg)
    {
        
        
        if(pkg==null){
            throw new IllegalArgumentException("cannot be null");
        }
        else{
            for(Package testPackage : packages)
            {
                if(pkg.getTrackingCode() == testPackage.getTrackingCode())
                {
                    throw new IllegalArgumentException("Tracking Code is not unique.");
                }
            }  
        }
        
        packages.add(pkg);
        return;
    }
}

