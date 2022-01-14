
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

public class TestDataWrangler {
  private DataWrangler data;

  @BeforeEach
  public void instantiateDataWrangler() {
    data = new DataWrangler();
  }

  /**
   * Tests that the data wrangler class is instantiated correctly in that it is able to read from
   * the two data files and read the data correctly.
   * 
   * There should be 54 items returned from the getAllIntersections() method which is how many items
   * are in the source file.
   */
  @Test
  public void testDataWranglerInstantiation() {
    assertEquals(data.getAllIntersections().size(), 54);
  }

  /**
   * Tests a select few intersections throughout the data set to ensure that these selected
   * intersections contain the correct connections as found in the data file. This tests the
   * correctness of reading in the data files.
   */
  @Test
  public void testConnections() {
    assertEquals(data.getAllIntersections().get(0).getConnections().toString(),
        "[Liden & Babcock, Observatory & Charter]");
    assertEquals(data.getAllIntersections().get(14).getConnections().toString(),
        "[Johnson & Randall, Orchard & Dayton, Spring & Randall]");
    assertEquals(data.getAllIntersections().get(23).getConnections().toString(),
        "[Mills & Johnson, Brooks & Conklin, Clymer & Brooks, Johnson & Park]");
    assertEquals(data.getAllIntersections().get(35).getConnections().toString(),
        "[Charter & Dayton, Capital & Charter, Spring & Orchard, Spring & Mills]");
    assertEquals(data.getAllIntersections().get(49).getConnections().toString(),
        "[Park & Dayton, Spring & Brooks, Fahrenbrook & Park]");
    assertEquals(data.getAllIntersections().get(53).getConnections().toString(),
        "[Capital & Coyne, Regent & Orchard, Regent & Charter]");
  }

  /**
   * Tests a select few intersections throughout the data set to ensure that the selected
   * intersections contain the correct point of interests as found in the data file. This tests the
   * correctness of reading in the data files.
   */
  @Test
  public void testPointOfInterests() {
    assertEquals(data.getAllIntersections().get(0).getPointOfInterests().toString(), "[Steenbock Memorial Library, Department of Soil Science]");
    assertEquals(data.getAllIntersections().get(6).getPointOfInterests().toString(), "[Buisness Learning Commons, Wisconsin School of Buisness, Rheta's Market,  UW School of Journalism & Mass Communication, Chadbourne Residence Hall]");
    assertEquals(data.getAllIntersections().get(20).getPointOfInterests().toString(), "[]");
    assertEquals(data.getAllIntersections().get(32).getPointOfInterests().toString(), "[Wisconsin Primate Center, Islamic Center of Madison]");
    assertEquals(data.getAllIntersections().get(41).getPointOfInterests().toString(), "[Landmark Credit Union, Campus Village Apartments]");
    assertEquals(data.getAllIntersections().get(48).getPointOfInterests().toString(), "[College Park Apartments]");
    assertEquals(data.getAllIntersections().get(53).getPointOfInterests().toString(), "[The Red Zone Madison]");
  }
}
