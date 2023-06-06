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
import GraphFramework.Edge;
 

public class Route extends Edge {
    public Route(Location source, Location destination, int weight) {
        super(source, destination, weight);
    }

    

    

    @Override
    public void displayInfo() {
        System.out.println("--- route length: " + getWeight());
       
    }
}
