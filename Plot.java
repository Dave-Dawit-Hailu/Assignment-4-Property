
/*
 * Class: CMSC203 CRN: 30340
 * Instructor: Professor Khandan 
 * 
 * Description: 
 * 
	Plot Class:
	The Plot class represents a plot of land with attributes for its position (x, y coordinates) and dimensions (width and depth). 
	It provides methods to access and modify these attributes, check for overlaps with other plots, and determine if a plot encompasses another. 
	This class is essential for defining the boundaries of properties within a management company.
	
	Property Class:
	The Property class represents a real estate property with attributes such as its name, location (city), rental amount, owner, 
	and a plot defining its boundaries. It provides methods to access and modify these attributes, as well as a toString method for 
	displaying property information. This class encapsulates individual properties managed by a management company.

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
public class Plot extends Property{

	private int x;
    private int y;
    private int width;
    private int depth;

    // Constructors
    public Plot() {
    	this.x = 0;
    	this.y = 0;
        this.width = 1;
        this.depth = 1;
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot otherPlot) {
        this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.depth = otherPlot.depth;
    }

    // Methods
    public boolean overlaps(Plot plot) {
        int thisRight = this.x + this.width;
        int thisBottom = this.y + this.depth;
        int otherRight = plot.x + plot.width;
        int otherBottom = plot.y + plot.depth;

        return !(this.x >= otherRight || thisRight <= plot.x || this.y >= otherBottom || thisBottom <= plot.y);
    }

    public boolean encompasses(Plot plot) {
        return this.x <= plot.x && this.y <= plot.y &&
                (this.x + this.width) >= (plot.x + plot.width) &&
                (this.y + this.depth) >= (plot.y + plot.depth);
    }

    // Getters and setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    // toString method
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
	

