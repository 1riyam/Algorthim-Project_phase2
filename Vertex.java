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
import java.util.LinkedList;

public class Vertex {
    // here i crate a varc calld lable , isVisted , a list name adjlist
    private String label;
    private boolean isVisited; 
    private LinkedList<Edge> adjList;
    // here is the Vertex contrate 
    public Vertex(String label) {
        this.label = label;
        this.isVisited = false;
        this.adjList = new LinkedList<>();
    }
    // here is the getLabel  methood 
    public String getLabel() {
        return label;
    }
    // here is the setLabel methood 
    public void setLabel(String label) {
        this.label = label;
    }
    // here is the isVisited methood 
    public boolean isVisited() {
        return isVisited;
    }
    // here is the setVisited methood 
    public void setVisited(boolean visited) {
        isVisited = visited;
    }
    // here is the getAdjList methood 
    public LinkedList<Edge> getAdjList() {
        return adjList;
    }
    // here is the displayInfo methood 
    public void displayInfo() {
        System.out.println("Vertex label --> " + label + " Visited --> " + isVisited + " Adjacent vertices --> " + adjList);
    }

}




