package preRequisites.Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomSort {
    class Solution {
        static class Person  {  //it is more like a pair class
            String name;
            int height;

            Person(String name, int height) {
                this.name = name;
                this.height = height;
            }
        }

        static class PersonComparator implements Comparator<Person> { //we pass the class name
            @Override
            public int compare(Person p1, Person p2) {
                if(p2.height>p1.height)
                    return 1;
                else
                    return -1;
            }
        }

        public String[] sortPeople(String[] names, int[] heights) {
            int n = names.length;
            List<Person> people = new ArrayList<>();

            // Create a list of Person objects
            for (int i = 0; i < n; i++) {
                people.add(new Person(names[i], heights[i]));
            }

            // Sort the list using a custom comparator
            people.sort(new PersonComparator());

            // Extract the sorted names
            String[] sortedNames = new String[n];
            for (int i = 0; i < n; i++) {
                sortedNames[i] = people.get(i).name;
            }

            return sortedNames;
        }
    }

}
