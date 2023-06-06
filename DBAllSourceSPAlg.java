/*
Group Members: 
2006847 Lujain Abdulaziz AlSulami
2005517 Asal Ali Alghamdi
2006739 Ryam Abdulwase Alsahafie 
2106125 Laura Ismail Fatta

References:
GeeksforGeeks. (2023b). Applications of Minimum Spanning Tree Problem. GeeksforGeeks. https://www.geeksforgeeks.org/applications-of-minimum-spanning-tree/

Poe - Fast, Helpful AI Chat. (n.d.). https://poe.com/

https://www.gatevidyalay.com/tag/kruskals-algorithm-example-with-solution/

Baeldung. (2022, May 29). Dijkstra's Algorithm in Java. Retrieved from https://www.baeldung.com/java-dijkstra
Instructor :
I. أسماء الشنقيطي 
I. سيدرا قريشي

*/
package GraphFramework;

import AirFreightApp.Location;
import java.util.List;

/**
 *
 * @author laurafatta

 */
public class DBAllSourceSPAlg extends ShortestPathAlgorithm {
        private SingleSourceSPAlg dijkstraAlg;

    public DBAllSourceSPAlg(Graph graph) {
        super(graph);
        dijkstraAlg = new SingleSourceSPAlg(graph); // Initialize the dijkstraAlg field
    }

    public void computeDijkstraBasedSPAlg() {
        // Loop for all vertices
        for (Location vertex : graph.getVertices()) {
            
            // Compute the shortest path for the current vertex
            dijkstraAlg.computeDijkstraAlg(vertex);
            
            }
    }

    
}

