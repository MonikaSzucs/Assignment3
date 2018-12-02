
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
    private ArrayList<Warehouse> warehouse;
    private int numPackages;
    private int valuePackage;

    /**
     * Constructor for objects of class Warehouse
     */
    public Warehouse(Package[] packs)
    {
        // initialise instance variables
        packages = new ArrayList<Package>();
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
        return numPackages;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getTotalPackageValue()
    {
        // put your code here
        return valuePackage;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Package[] findPackagesByPriority(int packagePriority)
    {
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
            if(priority != null && priority.getPriority() == packagePriority)
                priorityPackage[index] = priority;
            index++;
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
        int     index = 0; 
        int     numPackageAboveWeightPriority = 0;

        Package[] priorityPackage;

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
            return null;
        }

        for(Package weight : packages)
        {
            if(weight != null && weight.getPriority()>packageAboveWeight)
                priorityPackage[index] = weight;
            index++;
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
        int     index = 0; 
        int     numPackageBelowWeightPriority = 0;

        Package[] priorityPackage;

        for(Package weight : packages)
        {
            if(weight != null && weight.getWeight()>packageBelowWeight)
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
            if(weight != null && weight.getPriority()>packageBelowWeight)
                priorityPackage[index] = weight;
            index++;
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
     * A method to remove a packaage from the warehouse based on:
     */
    public Package shipPackagesByDestinationCity(String destinationCity)
    {
        if(destinationCity == null){
            throw new IllegalArgumentException("The Destination City is not valid.");
        }else if(destinationCity.equals("")){
            throw new IllegalArgumentException("The Destination City is not set.");
        }
        
        ArrayList<Package> shippingPackage = new ArrayList<Package>();
        
        if(packages==null)
        {
            throw new IllegalArgumentException("The Packages cannot be null.");
        }
        
        Iterator<Package> it = packages.iterator();
        while(it.hasNext()) {
            Package tracking = it.next();
            if(tracking.getDestCity().equals(destinationCity))
            {
                packages.remove(tracking);
                return tracking;
            }
        }
        
       
        throw new IllegalArgumentException("The Destination City is not valid.");
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Package addPackage(String destinationCity)
    {
        ArrayList<Package> shippingPackage = new ArrayList<Package>();

        for(Package tracking : packages)
        {
            if((packages!=null) && !(destinationCity.equals("")))
            {
                shippingPackage.remove(destinationCity);
            }
        }  
        Package packaging = shippingPackage.get(0);
        return packaging;
    }
}

