// --== CS400 File Header Information ==--
// Name: Anthony Reis
// Email: atreis@wisc.edu
// Team: Red
// Role: Data Wrangler
// TA: Mu Cai
// Lecturer: Gary Dahl
// Notes to Grader: N/A

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This datawrangler class represents the data wrangler class which initializes the variable
 * "intersections" by reading two files, one called PointOfInterests.csv and one called
 * Distances.csv. PointOfInterests.csv contains each intersection of the mapped area and all of the
 * point of interests associated with a particular intersection. Distances.csv contains a table of
 * the distances between each intersection.
 * 
 * This class utilizes the two sources .csv files listed above to initialize allIntersections and
 * pass that to the backend developer.
 * 
 * @author Anthony Reis
 *
 */

public class DataWrangler {
  private static ArrayList<Intersection> intersections;

  /**
   * Default constructor that initializes the intersections field and populates it by calling two
   * other functions, initializeIntersections() and initializeConnections().
   */
  public DataWrangler() {
    intersections = new ArrayList<Intersection>();
    initializeIntersections();
    initializeConnections();
  }

  /**
   * Reads from the file PointOfInterests.csv, instantiates an intersection for each intersection
   * found in the file, and adds all point of interests found at that intersection.
   */
  public void initializeIntersections() {
    Scanner scnr = null;

    try {
      File POI = new File("PointOfInterests.csv");
      scnr = new Scanner(POI);

      // Read entire file. Intersection name is always first element in the line. Any following
      // elements of the intersection name are the point of interests for that intersection.
      while (scnr.hasNextLine()) {
        String[] line = scnr.nextLine().split(",");
        Intersection intersection = new Intersection(line[0]);

        for (int i = 1; i < line.length; i++)
          intersection.addPointOfInterest(line[i]);

        intersections.add(intersection);
      }
    } catch (FileNotFoundException e) {
      // Exit the program if source file cannot be found.
      System.out.println("ERROR: Source file(s) cannot be found... exiting program.");
      System.exit(1);
    }
    scnr.close();
  }

  /**
   * Reads from the file Distances.csv, and for each intersection in allIntersections, this method
   * will add a list of connections (if there are any) to the intersection object's connections
   * field.
   */
  public void initializeConnections() {
    Scanner scnr = null;

    try {
      File distances = new File("Distances.csv");
      scnr = new Scanner(distances);
      scnr.nextLine();

      while (scnr.hasNextLine()) {
        String[] line = scnr.nextLine().split(",", -1);
        String currentIntersection = line[0];
        line = Arrays.copyOfRange(line, 1, line.length);
        Intersection currentIntersectionObj = null;

        for (Intersection intersection : intersections) {
          if (intersection.getName().equals(currentIntersection)) {
            currentIntersectionObj = intersection;
            break;
          }
        }

        for (int i = 0; i < line.length; i++) {
          if (!line[i].isBlank()) {
            currentIntersectionObj.addConnection(intersections.get(i), Integer.parseInt(line[i]));
          }
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("ERROR: Source file(s) cannot be found... exiting program.");
      System.exit(1);
    }
    scnr.close();
  }

  /**
   * Gets the array list of all of the intersections in this data set.
   * 
   * @return array list of intersections
   */
  public ArrayList<Intersection> getAllIntersections() {
    return intersections;
  }
}


