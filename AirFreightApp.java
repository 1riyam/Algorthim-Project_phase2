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
package AirFreightApp;

/**
 *
 * @author laurafatta
 */
import GraphFramework.DBAllSourceSPAlg;
import GraphFramework.Graph;
import GraphFramework.ShortestPathAlgorithm;
import GraphFramework.SingleSourceSPAlg;
import GraphFramework.Vertex;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class AirFreightApp {
    public static void main(String[] args) throws FileNotFoundException {
         AFRouteMap friGraphst = new AFRouteMap();
        friGraphst.readGraphFromFile("sampleInput.txt");
        // Read graph from file
        
        
// Run Dijkstra-based all source shortest path algorithm
        SingleSourceSPAlg algorithm2 = new SingleSourceSPAlg(friGraphst);
        long startTime = System.nanoTime();
         algorithm2.computeDijkstraAlg(friGraphst.getSource());
        long endTime = System.nanoTime();
        long runningTime = endTime - startTime;


        // Run Dijkstra-based all source shortest path algorithm
        DBAllSourceSPAlg algorithm = new DBAllSourceSPAlg(friGraphst);

        

        // Display the result and running time
displayInfo(algorithm2);        
        System.out.println("\nRunning time Dijkstra Single source: " + runningTime + " nanoseconds");
        
        long startTime2 = System.nanoTime();
        algorithm.computeDijkstraBasedSPAlg();
        long endTime2 = System.nanoTime();
        long runningTime2 = endTime2 - startTime2;
        System.out.println("\nRunning time Dijkstra Based all source: " + runningTime2 + " nanoseconds");
        
        
        
        
        System.out.println("\n\n-------------Requirement 2-------------");
List<Integer> thevertexCounts = Arrays.asList(2000, 3000, 4000, 5000, 6000);
List<List<Integer>> countsOfedge = Arrays.asList(
    Arrays.asList(10000),
    Arrays.asList(15000),
    Arrays.asList(20000),
    Arrays.asList(25000),
    Arrays.asList(30000)
);
int numIterations = thevertexCounts.size(); // Number of iterations

for (int i = 0; i < numIterations; i++) {
    int countOgvertex = thevertexCounts.get(i);
    List<Integer> edges = countsOfedge.get(i);

    for (int countOfedge : edges) {
        // Generate a random graph
        Graph graph = new AFRouteMap();
        graph.generateRandomGraph(countOgvertex, countOfedge);

        SingleSourceSPAlg algorithm4 = new SingleSourceSPAlg(graph);
        DBAllSourceSPAlg algorithm3 = new DBAllSourceSPAlg(graph);

        // Run single source algorithm and measure the running time
        long singleSourceStartTime = System.nanoTime();
        algorithm4.computeDijkstraAlg(graph.getSource());
        long singleSourceEndTime = System.nanoTime();
        long singleSourceRunningTime = singleSourceEndTime - singleSourceStartTime;

        // Run all sources algorithm and measure the running time
        long allSourceStartTime = System.nanoTime();
        algorithm3.computeDijkstraBasedSPAlg();
        long allSourceEndTime = System.nanoTime();
        long allSourceRunningTime = allSourceEndTime - allSourceStartTime;

        System.out.println("\nVertex Count: " + countOgvertex + ", Edge Count: " + countOfedge);
        System.out.println("Dijkstra Single source Running Time: " + singleSourceRunningTime + " ns");

        System.out.println("\nVertex Count: " + countOgvertex + ", Edge Count: " + countOfedge);
        System.out.println("Dijkstra Based all source Running Time: " + allSourceRunningTime + " ns");
    }}}

public static void displayInfo(SingleSourceSPAlg algorithm) {
    List<Location> locations = algorithm.getGraph().getVertices();
    char label='A';
        System.out.println("The starting point location is " + label);
        System.out.println("The routes from location " + label + " to the rest of the locations are:");
        
        for (Location destination : locations) {
            if (!destination.equals(label)) {
                List<Vertex> shortestPath = algorithm.getShortestPath(destination);
                int routeLength = algorithm.getDistance().get(destination);
                
                System.out.print("loc. " + label + ": ");
                for (int j = 0; j < shortestPath.size(); j++) {
                    int vertex = 1;
                    
                        System.out.print("city " + vertex);
                        if (j < shortestPath.size() - 1) 
                            System.out.print(" - ");
                    vertex++;    
                    
                }
                
                System.out.println(" --- route length: " + routeLength);
            } label++;
        }
        
        System.out.println();
        
    }
}



