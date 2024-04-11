
/*
 * Class: CMSC203 CRN: 30340
 * Instructor: Professor Khandan 
 * 
 * Description: 
 * 
	Property Class:
	The Property class represents a real estate property with attributes such as its name, location (city), rental amount, owner, 
	and a plot defining its boundaries. It provides methods to access and modify these attributes, as well as a toString method for 
	displaying property information. This class encapsulates individual properties managed by a management company.

 * Due: 4/10/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
*  independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Dave| Dawit Hailu
*/
public class Property {

	// Attributes
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    // Constructors
    public Property() {
        this.propertyName = " ";
        this.city = " ";
        this.rentAmount = 0.0;
        this.owner = " ";
        
    }

    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    public Property(Property otherProperty) {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.owner = otherProperty.owner;
        this.plot = new Plot(otherProperty.plot);
    }
    
    // Getter methods
    public String getPropertyName() {
        return propertyName;
    }

    public String getCity() {
        return city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    public Plot getPlot() {
        return plot;
    }

    // toString method
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }

	
}
