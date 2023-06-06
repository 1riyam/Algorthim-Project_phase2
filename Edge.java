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
/**
 * Represents a graph edge.
 */
public class Edge {
    
    // here i craete a var  weight and source,target parent . 
    public int weight;
    public Vertex source;
    public Vertex target;
    public Vertex parent;
    // here i craete a constare methood 
    public Edge(Vertex source, Vertex target, int weight) {
        this.weight = weight;
        this.source = source;
        this.target = target;
    }   
    // here is the Edge 
    public Edge(int weight) {
        this.weight = weight;
    }
    // here is the getWeight methood 
    public int getWeight() {
        return weight;
    }
    // here is the setWeight methood 
    public void setWeight(int weight) {
        this.weight = weight;
    }
    // here is the displayInfo methood 
    public void displayInfo() {
         System.out.println("Source vertex --> " + source.getLabel() + " target vertex --> " + target.getLabel() + " Weight --> " + weight);   

    }
    // here is the getSource methood 
    public Vertex getSource() {
        return source;
    }
    // here is the setSource methood 
    public void setSource(Vertex source) {
        this.source = source;
    }
    // here is the getTarget methood 
    public Vertex getTarget() {
        return target;
    }
    // here is the setTarget methood 
    public void setTarget(Vertex target) {
        this.target = target;
    }
}


