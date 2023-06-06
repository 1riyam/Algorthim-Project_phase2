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

/**
 *
 * @author laurafatta
 */
import AirFreightApp.Location;
import AirFreightApp.Route;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;


public class SingleSourceSPAlg extends ShortestPathAlgorithm {
    private Vertex source;
    private Map<Vertex, Integer> distances;
    private Map<Vertex, Vertex> previousVertices;
    
    
    public SingleSourceSPAlg(Graph graph) {
        
        super(graph);
        distances = new HashMap<>();
        previousVertices = new HashMap<>();

        // Initialize distances for all vertices
        for (Vertex vertex : graph.getVertices()) {
        if (vertex.equals(source)) {
            distances.put(vertex, 0);
        } else {
            distances.put(vertex, Integer.MAX_VALUE);
        }
    }}
   

    public void computeDijkstraAlg(Vertex source) {
    this.source = source;
    distances.clear();
    previousVertices.clear();

    // Create a priority queue to store vertices based on their distances
    PriorityQueue<Vertex> minHeap = new PriorityQueue<>(Comparator.comparingInt(distances::get));

    // Initialize distances for all vertices
    for (Vertex vertex : graph.getVertices()) {
        if (vertex.equals(source)) {
            distances.put(vertex, 0);
            minHeap.offer(vertex);
        } else {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        previousVertices.put(vertex, null);
    }

    while (!minHeap.isEmpty()) {
        Vertex currentVertex =  minHeap.poll();

        // Stop if the current vertex has maximum distance (unreachable)
        if (distances.get(currentVertex) == Integer.MAX_VALUE) {
            break;
        }

        // Update distances for neighboring vertices
        List<Edge> neighbors = graph.getEdgesFromVertex(currentVertex);
        for (Edge neighbor : neighbors) {
            Vertex neighborVertex = neighbor.getTarget();
            int newDistance = distances.get(currentVertex) + neighbor.getWeight();
            if (newDistance < distances.get(neighborVertex)) {
                distances.put( neighborVertex, newDistance);
                previousVertices.put(neighborVertex, currentVertex);
                // Update the priority queue with the new distance
                minHeap.remove(neighborVertex);
                minHeap.offer(neighborVertex);
            }
        }
    }
}





    public List<Vertex> getShortestPath(Vertex destination) {
        List<Vertex> shortestPath = new ArrayList<>();
        Vertex currentVertex = destination;
        
        while (currentVertex != null) {
            shortestPath.add(currentVertex);
            currentVertex = previousVertices.get(currentVertex);
        }
        
        Collections.reverse(shortestPath);
        return shortestPath;
    }
    
    



 private void evaluateDistanceAndPath(Vertex adjacentVertex, int edgeWeight, Vertex sourceVertex) {
        int newDistance = distances.get(sourceVertex) + edgeWeight;
        if (newDistance < distances.get(adjacentVertex)) {
            distances.put(adjacentVertex, newDistance);
            previousVertices.put(adjacentVertex, sourceVertex);
        }
    } 
   
    public Vertex getSource() {
        return source;
    }

    public Map<Vertex, Integer> getDistance() {
        return distances;
    }

    public Map<Vertex, Vertex> getPreviousVertices() {
        return previousVertices;
    }
    
    
   }


