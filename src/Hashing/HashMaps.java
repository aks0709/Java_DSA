package Hashing;

import Tree.BinaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMaps
{
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("India",120);
        map.put("China",150);
        map.put("Japan",50);
        System.out.println(map);
        map.put("China",180);  //since china key already exsist it just update the key
        System.out.println(map);

        if(map.containsKey("India")) System.out.println("india key exsist");

        System.out.println(map.get("China"));
        System.out.println(map.get("Ayush")); //since there is no such keys therefore it gives you null

        //iterator

        for (Map.Entry<String,Integer> e : map.entrySet())
        {
            System.out.print(" "+e.getKey()+" "+e.getValue());
        }

        System.out.println();
        //2 nd type iteration

        Set<String> keys=map.keySet();
        for (String k: keys)
        {
            System.out.print(" "+k+" "+map.get(k));
        }
        System.out.println();

        //removing of pair
        map.remove("China");
        System.out.println(map);

    }
}
