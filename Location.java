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

import GraphFramework.Vertex;

/**
 *
 * @author laurafatta
 */
import GraphFramework.Vertex;
import GraphFramework.Edge;
public class Location extends Vertex {
    public String city;
    // here it is the constract methoood          
    public Location(String label){
        super(label);
    }

    

    

    @Override
    public void displayInfo() {
        System.out.println("-------------------------------------------------");
        System.out.println(getLabel() + ": " + city);
        System.out.println("-------------------------------------------------");
    }
    
    @Override
    public String toString() {
        return city; // Return only the city name
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
}



