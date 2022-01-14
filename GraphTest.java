

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.NoSuchElementException;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private CS400Graph<String> graph;
    
    /**
     * Instantiate graph from last week's shortest path activity.
     */
    @BeforeEach
    public void createGraph() {
        graph = new CS400Graph<>();
        // insert vertices A-E
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        // insert edges from Week 09. Dijkstra's Activity
        graph.insertEdge("A","B",2);
        graph.insertEdge("A","D",4);
        graph.insertEdge("A","E",1);
        graph.insertEdge("B","C",5);
        graph.insertEdge("C","A",3);
        graph.insertEdge("D","B",3);
        graph.insertEdge("D","C",7);
        graph.insertEdge("D","E",1);
        graph.insertEdge("E","C",8);
    }

    /**
     * Checks the distance/total weight cost from the vertex labelled C to E
     * (should be 4), and from the vertex labelled A to C (should be 7).
     */
    @Test
    public void providedTestToCheckPathCosts() {
        assertTrue(graph.getPathCost("C", "E") == 4);    
        assertTrue(graph.getPathCost("A", "C") == 7);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * labelled C to E, and from the vertex labelled A to C.
     */
    @Test
    public void providedTestToCheckPathContents() {
        assertTrue(graph.shortestPath("C", "E").toString().equals(
            "[C, A, E]"
        ));
        assertTrue(graph.shortestPath("A", "C").toString().equals(
            "[A, B, C]"
        ));
    }
    /*
     * Checks the distance of the longest shortest path in the graph (my personal starting node was A, and the node that is furthest is C)
     * 
     */
    @Test 
    public void testCorrectDistanceLongestPathDjikstraActivity() {
      assertTrue(graph.getPathCost("A", "C") == 7);
    }
    
    /**
     * Checks the sequence of values of the longest shortest path
     * 
     */
    @Test
    public void testCorrectValuesLongestPathDjikstraActivity() {
      assertTrue(graph.shortestPath("A", "C").toString().equals("[A, B, C]"));
    }
    
    /**
     * Checks if shortest paths are being returned as they should be
     */
    @Test
    public void testCorrectShortestDistances() {
      
      // Shortest paths when the start node is A
      assertTrue(graph.getPathCost("A", "A") == 0);
      assertTrue(graph.getPathCost("A", "B") == 2);
      assertTrue(graph.getPathCost("A", "C") == 7);
      assertTrue(graph.getPathCost("A", "D") == 4);
      assertTrue(graph.getPathCost("A", "E") == 1);
      
      // Various other shortest paths
      assertTrue(graph.getPathCost("D", "A") == 10);
      assertTrue(graph.getPathCost("C", "D") == 7);
      assertTrue(graph.getPathCost("B", "A") == 8);
      
    }
    
    /**
     * Checks if the correct sequence of values is returned for different shortest paths
     */
    @Test
    public void testCorrectSequenceShortestPaths() {
      assertTrue(graph.shortestPath("A", "A").toString().equals("[A]"));
      assertTrue(graph.shortestPath("A", "B").toString().equals("[A, B]"));
      assertTrue(graph.shortestPath("A", "C").toString().equals("[A, B, C]"));
      assertTrue(graph.shortestPath("A", "D").toString().equals("[A, D]"));
      assertTrue(graph.shortestPath("A", "E").toString().equals("[A, E]"));
      
      assertTrue(graph.shortestPath("D", "A").toString().equals("[D, C, A]"));
      assertTrue(graph.shortestPath("C", "D").toString().equals("[C, A, D]"));
      assertTrue(graph.shortestPath("B", "A").toString().equals("[B, C, A]"));

      
    }
    
    /**
     * Checks for proper exception handling
     */
    @Test
    public void testExceptionHandling() {
      boolean isThrown = false;
      try {
        graph.getPathCost("X", "A");
      }
      catch(NoSuchElementException e) {
        isThrown = true;
      }
      
      assertTrue(isThrown == true);
      
      CS400Graph<String> test = new CS400Graph<String>();
      test.insertVertex("A");
      test.insertVertex("B");
      
      isThrown = false;
      try {
        test.getPathCost("A", "B");
      }
      catch(NoSuchElementException e) {
        isThrown = true;
      }
      
      assertTrue(isThrown == true);
    }

}
