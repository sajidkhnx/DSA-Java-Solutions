import java.util.*;
public class hashconcept{
    public static void main (String args[]){
        HashSet<String> cities =  new HashSet<>();

        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Kolkata");
        cities.add("Sikkim");

        Iterator i = cities.iterator();

        while(i.hasNext()){
            System.out.println(i.next());
        }
        System.out.println("Change---------------------------------------------------------------------");
        for (String string : cities) {
            System.out.println(string);
        }
    }
}