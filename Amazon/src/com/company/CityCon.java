package com.company;

/**
 * Created by feideng on 11/16/16.
 */
import java.util.*;
public class CityCon {

    public  List<Connection> findPath(List<Connection> list) {
        ArrayList<Connection> result = new ArrayList<Connection>();
        Set<String> visited = new HashSet<String>();
        Set<String> citiSet = new HashSet<String>();

        getAllCities(list, citiSet);

        while (!list.isEmpty()) {
            // find the minimum cost to the city from cityTree among the result.
            Connection temp = findMin(list, visited);
            if (temp == null) {// we finished
                break;
            }
            list.remove(temp); // remove the current minimum cost from grand set
            visited.add(temp.city1);
            visited.add(temp.city2);
            result.add(temp);
        }

        if(visited.size()<citiSet.size()) {
            return new ArrayList<Connection>();
        }

        // override compare make it alphabet order
        Comparator<Connection> cmp = new Comparator<Connection>() {
            public int compare(Connection c1, Connection c2) {
                if (c1.city1.equals(c2.city1)) {
                    return c1.city2.compareTo(c2.city2);
                }
                return c1.city1.compareTo(c2.city1);
            }
        };
        result.sort(cmp);

        return result;
    }

    private static void getAllCities(List<Connection> list, Set<String> citiSet) {
        for (Connection con : list) {
            citiSet.add(con.city1);
            citiSet.add(con.city2);
        }
    }

    // find the minimum cost between the city we traversed and we did not
    // traverse.
    public  Connection findMin(List<Connection> list, Set<String> visited) {
        Connection result = null;
        int minCost = Integer.MAX_VALUE; // minimum cost

        for (Connection con : list) {
            if (con.cost <= minCost) {
                // if none of the city we traversed
                // or the connection is connected to either city from cityTree.
                if ((visited.contains(con.city1) && !visited.contains(con.city2))
                        || visited.contains(con.city2) && !visited.contains(con.city1)) {
                    minCost = con.cost;
                    result = con;
                }
                if (visited.isEmpty()) {
                    minCost = con.cost;
                    result = con;
                }
            }
        }

        return result;
    }
}


