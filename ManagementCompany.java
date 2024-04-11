
/*
 * Class: CMSC203 CRN: 30340
 * Instructor: Professor Khandan 
 * 
 * Description: 
 * 
	ManagementCompany Class:
	The ManagementCompany class represents a management company responsible for overseeing multiple properties. It contains attributes for the company's name,
	tax ID, management fee percentage, and an array of properties it manages. This class provides methods for adding, removing, and accessing properties, 
	calculating total rent, and determining properties with the highest rent. It also validates management fees and generates a summary of all properties 
	managed by the company. Overall, this class serves as the central entity for managing multiple real estate properties.
*

 * Due: 4/10/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
*  independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Dave| Dawit Hailu
*/
public class ManagementCompany {
	
// Attributes
private String name;
private String taxID;
private double mgmFeePer;
private static final int MAX_PROPERTY = 5;
private static final int MGMT_WIDTH = 10;
private static final int MGMT_DEPTH = 10;
private Property[] properties;
private Plot plot;
private int numberOfProperties;

// Constructors
public ManagementCompany() {
	this.name = "";
	this.taxID = "";
	this.mgmFeePer = 0.0;
	this.properties = new Property[MAX_PROPERTY];
	this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	this.numberOfProperties = 0;
}

public ManagementCompany(String name, String taxID, double mgmFee) {
	this();
	this.name = name;
	this.taxID = taxID;
	this.mgmFeePer = mgmFee;
}

public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
	this();
	this.name = name;
	this.taxID = taxID;
	this.mgmFeePer = mgmFee;
	this.plot = new Plot(x, y, width, depth);
}

public ManagementCompany(ManagementCompany otherCompany) {
	this();
	this.name = otherCompany.name;
	this.taxID = otherCompany.taxID;
	this.mgmFeePer = otherCompany.mgmFeePer;
	this.properties = otherCompany.properties.clone();
	this.plot = new Plot(otherCompany.plot);
	this.numberOfProperties = otherCompany.numberOfProperties;
}

// Getter and setter methods
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getTaxID() {
	return taxID;
}

public void setTaxID(String taxID) {
	this.taxID = taxID;
}

public double getMgmFeePer() {
	return mgmFeePer;
}

public void setMgmFeePer(double mgmFeePer) {
	this.mgmFeePer = mgmFeePer;
}

public Plot getPlot() {
	return plot;
}

// Method to add a new property
public int addProperty(String name, String city, double rent, String owner) {
	// Create property with default plot
	Property property = new Property(name, city, rent, owner);
	return addProperty(property);
}

public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
	// Create property with specified plot
	Property property = new Property(name, city, rent, owner, x, y, width, depth);
	return addProperty(property);
}

public int addProperty(Property property) {
	if (numberOfProperties >= MAX_PROPERTY) {
		return -1; // Array is full
	}

	if (property == null) {
		return -2; // Property object is null
	}

	if (!plot.encompasses(property.getPlot())) {
		return -3; // Management company does not encompass property plot
	}

	for (int i = 0; i < numberOfProperties; i++) {
		if (properties[i].getPlot().overlaps(property.getPlot())) {
			return -4; // Property plot overlaps with another property's plot
		}
	}

	properties[numberOfProperties] = property;
	numberOfProperties++;
	return numberOfProperties -1; // Index where property was added
}

// Method to calculate total rent
public double getTotalRent() {
	double totalRent = 0.0;
	for (int i = 0; i < numberOfProperties; i++) {
		totalRent += properties[i].getRentAmount();
	}
	return totalRent;
}

// Method to get property with highest rent
public Property getHighestRentProperty() {
	if (numberOfProperties == 0) {
		return null;
	}

	Property highestRentProperty = properties[0];
	for (int i = 1; i < numberOfProperties; i++) {
		if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
			highestRentProperty = properties[i];
		}
	}
	return highestRentProperty;
}

// Method to remove last property
public void removeLastProperty() {
	if (numberOfProperties > 0) {
		properties[numberOfProperties - 1] = null;
		numberOfProperties--;
	}
}

// Method to check if properties array is full
public boolean isPropertiesFull() {
	return numberOfProperties >= MAX_PROPERTY;
}

// Method to get properties count
public int getPropertiesCount() {
	return numberOfProperties;
}

// Method to check if management fee is valid
public boolean isManagementFeeValid() {
	return mgmFeePer >= 0 && mgmFeePer <= 100;
}

// Method to represent information of all properties
@Override
public String toString() {
	
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("List of the properties for %s, taxID: %s\n", name, taxID));
        sb.append("______________________________________________________\n");
        for (Property property : properties) {
            if (property != null) {
                sb.append(property.toString()).append("\n");
            }
        }
        sb.append("______________________________________________________\n");
        sb.append("\n");
        sb.append(String.format("total management Fee: %.2f", calculateTotalManagementFee()));
        return sb.toString();
    }

    private double calculateTotalManagementFee() {
        return ( mgmFeePer / 100.0)*getTotalRent();
    }
}
