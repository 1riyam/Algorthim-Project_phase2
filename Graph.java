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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

    public class Graph {
    // here i crate an Location and Route list 

    private List<Location> vertices;
    private List<Route> edges;
    int verticesNo;
    int edgesNo;
    private  Location source;
    private Location target;

    public void readGraphFromFile(String filename) {
        // here i start to cratea a map 
        Map<String, Location> vertexMap = new HashMap<>();

        try {
            File ffile = new File(filename);
            Scanner scanner = new Scanner(ffile);
            
            // here is a string of type graph 
            String digraph = scanner.nextLine();
            
            if(digraph.equalsIgnoreCase("digraph 0")){
                System.out.println("\n                Indirect graph              \n");
            }else{
                 System.out.println("\n                direct graph              \n");
            }

            
            // array of type string 
            String[] countss = scanner.nextLine().split(" ");
            int numVertices = Integer.parseInt(countss[0]);
            int numEdges = Integer.parseInt(countss[1]);
            

            // Create edges
            for (int i = 0; i < numEdges; i++) {
                countss = scanner.nextLine().split(" ");
                String sourceLabel = countss[0];
                String targetLabel = countss[1];
                int weight = Integer.parseInt(countss[2]);

                Location thesourceVertex = vertexMap.get(sourceLabel);
                Location thetargetVertex = vertexMap.get(targetLabel);

                if (thesourceVertex == null) {
                    thesourceVertex = new Location(sourceLabel);
                    vertexMap.put(sourceLabel, thesourceVertex);
                    addVertex(thesourceVertex);
                }

                if (thetargetVertex == null) {
                    thetargetVertex = new Location(targetLabel);
                    vertexMap.put(targetLabel, thetargetVertex);
                    addVertex(thetargetVertex);
                }

                Route edge = new Route(thesourceVertex, thetargetVertex, weight);
                addEdge(edge);
                   // Set the source vertex
                   
        
            }
       

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }       
    }
    
   // constarte methood 
    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }
    // here is the setSource methood 
    public void setSource(Location source) {
        this.source = source;
    }
    // here is the getSource methood 
    public Location getSource() {
        return source;
    }
    // here is the setTarget methood 
    public void setTarget(Location target) {
        this.target = target;
    }
    // here is the getTarget methood 
    public Location getTarget() {
        return target;
    }
    // here is the add vertex methood 
    public void addVertex(Location vertex) {
        this.vertices.add(vertex);
    }
    // here is the add edage methood 
    public void addEdge(Route edge) {
        edges.add(edge);
        this.edges.add(edge);
        this.vertices.add((Location) edge.getSource());
        this.vertices.add((Location) edge.getTarget());
    }
    // here is the getVertices methood 
    public List<Location> getVertices() {
        return this.vertices;
    }
    // here is the getEdges methood 
    public List<Route> getEdges() {
        return this.edges;
    }
     // here is the hasEdge  methood 
    public boolean hasEdge(Location source, Location target) {
        for (Route edge : edges) {
            if (edge.getSource().equals(source) && edge.getTarget().equals(target)) {
                return true;
            }
        }
        return false;
    }
        // here is the getEdgesFromVertex  methood 
        public List<Edge> getEdgesFromVertex(Vertex vertex) {
        List<Edge> edges = new ArrayList<>();
        for (Edge edge : this.edges) {
            if (edge.getSource().equals(vertex) || edge.getTarget().equals(vertex)) {
                edges.add(edge);
            }
        }
        return edges;
    }
    // here is the generateRandomGraph  methood 
     public static Graph generateRandomGraph(int vertexsCount, int edgeCount) {
        Graph graph = new Graph();
        Random random_r = new Random();
       // here is the i crate a for loop 
        for (int i = 1; i <= vertexsCount; i++) {
            Location vertex = new Location(Integer.toString(i));
            graph.addVertex(vertex);
        }
        // here i crate a list of name vertices
        List<Location> vertices = graph.getVertices();
        int rcount = 0;

        while (rcount < edgeCount) {
            int sourceIndex = random_r.nextInt(vertexsCount);
            int targetIndex = random_r.nextInt(vertexsCount);
            Location thesource = vertices.get(sourceIndex);
            Location thetarget = vertices.get(targetIndex);
            // here i crate an if stament to check if thesource != thetarget && !graph.hasEdge(thesource, thetarget
            if (thesource != thetarget && !graph.hasEdge(thesource, thetarget)) {
            // genrate a Random weight from 1 to 100
            int weight = random_r.nextInt(100) + 1; 
            // here i crate a var name edgesr of type string 
            Route edgesr = new Route(thesource, thetarget, weight);
            graph.addEdge(edgesr);
            rcount++;
            }
        }

        return graph;
    }
     
    

}

