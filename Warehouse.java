
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
    // instance variables - replace the example below with your own
    //private String[][];
    private ArrayList<Package> packages;

    //private ArrayList<Warehouse> warehouse;
    private int numPackages;
    private double valuePackage;

    /**
     * Constructor for objects of class Warehouse
     */
    public Warehouse(Package[] packs)
    {
        // initialise instance variables
        packages = new ArrayList<Package>();
        
        for(Package priority : packs)
        {
            packages.add(priority);
        }  

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Package[] findPackagesByPriority(int packagePriority)
    {
        if(packagePriority<1){
            throw new IllegalArgumentException("Priority must be either 1, 2 or 3.");
        } else if(packagePriority>3){
            throw new IllegalArgumentException("Priority must be either 1, 2 or 3.");
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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Package[] findPackagesAboveWeight(double packageAboveWeight)
    {
        if(packageAboveWeight<0.0 || packageAboveWeight>100.0){
            throw new IllegalArgumentException("Weight must be between 0.0 and 100.0lbs.");
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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Package[] findPackagesBelowWeight(double packageBelowWeight)
    {
        if(packageBelowWeight<0.0 || packageBelowWeight>100.0){
            throw new IllegalArgumentException("Weight must be between 0.0 and 100.0lbs.");
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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Package shipPackageByTrackingCode(int trackingNumber)
    {
        if(trackingNumber<=0){
            throw new IllegalArgumentException("Sorry, tracking code " +trackingNumber + " cannot be negative.");
        }
        
        ArrayList<Package> shippingPackage = new ArrayList<Package>();

        for(Package tracking : packages)
        {
            if((packages!=null) && (trackingNumber>=0)&&(trackingNumber<=1000000000))
            {
                shippingPackage.remove(trackingNumber);
            }
        }  
        Package packaging = shippingPackage.get(0);
        return packaging;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     * 
     * when we remove we will have to use iterator
     * A method to remove a package from the warehouse based on:
     */
    public Package[] shipPackagesByDestinationCity(String destinationCity)
    {
        if(destinationCity == null){
            throw new IllegalArgumentException("The Destination City is not valid.");
        }else if(destinationCity.equals("")){
            throw new IllegalArgumentException("The Destination City is not set.");
        }
        
        //ArrayList<Package> shippingPackage = new ArrayList<Package>();
        
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
                // TODO: create a copy of the pckage somewhere else (in a list) and return the list
                
                sentPackages.add(sendablePackage);
                
                packages.remove(sendablePackage);
            }
        }
        
        Package [] sent = sentPackages.toArray(new Package[sentPackages.size()]);
        
        return sent;
        
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Package addPackage(Package pkg)
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
        return pkg;
    }
}

