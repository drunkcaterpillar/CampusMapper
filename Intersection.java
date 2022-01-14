

import java.util.ArrayList;

/**
 * This intersection class represents a street intersection and the associated attributes of a
 * street intersection (i.e. street name, the point of interests close to the intersection, and the
 * connections or other intersections that this intersection connects to.
 * 
 * @author Anthony Reis
 *
 */

public class Intersection {
  private String name;
  boolean isValid;
  private ArrayList<String> pointOfInterests;
  private ArrayList<Connection> connections; // Each intersection can have up to four connections

  /**
   * Default constructor that initializes all intersection fields.
   */
  public Intersection(String name) {
    this.name = name;
    isValid = true;
    pointOfInterests = new ArrayList<String>();
    connections = new ArrayList<Connection>();
  }

  /**
   * Sets the status of this intersection. If this intersection is to be used in calculating a graph
   * route, set the status to "true". If this intersection is to not be used in calculating a graph
   * route, set the status to "false".
   * 
   * NOTE: All intersections are TRUE (valid) upon initialization.
   * 
   * @param iValid the status of this intersection
   */
  public void setStatus(boolean isValid) {
    this.isValid = isValid;
  }

  /**
   * Add a point of interest to this intersection.
   * 
   * @param POI string of point of interest to add
   */
  public void addPointOfInterest(String POI) {
    this.pointOfInterests.add(POI);
  }

  /**
   * Add a connection to this intersection. That is, add what other intersections that this
   * intersection connects to.
   * 
   * @param connection
   */
  public void addConnection(Intersection intersection, Integer distance) {
    connections.add(new Connection(intersection, distance));
  }

  /**
   * Gets the name of this intersection
   * 
   * @return name of intersection
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the array list of the point of interests for this intersection.
   * 
   * @return array list of strings
   */
  public ArrayList<String> getPointOfInterests() {
    return pointOfInterests;
  }

  /**
   * Gets the array list of the connections for this intersection.
   * 
   * @return array list of connections
   */
  public ArrayList<Connection> getConnections() {
    return connections;
  }

}
