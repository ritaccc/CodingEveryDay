package com.company;

/**
 * Created by feideng on 11/16/16.
 */
import java.util.*;
public class SpiningTree {
    public List<Connection> solution(List<Connection> list) {
        if(list == null || list.size() == 0) {
            return list;
        }
        List<Connection> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Set<String> citySet = new HashSet<>();
        while(!list.isEmpty()) {
            Connection tmp = fingMin(list, visited);
            if(tmp == null) {
                break;
            }
            list.remove(tmp);
            visited.add(tmp.city1);
            visited.add(tmp.city2);
            res.add(tmp);
        }
        if(visited.size() < citySet.size()) {
            return new ArrayList<>();
        }
        Collections.sort(res, new Comparator<Connection>(){
            @Override
            public int compare(Connection c1, Connection c2) {
                if((c1.city1).equals(c2.city1)) {
                    return c1.city2.compareTo(c2.city2);
                }
                return c1.city1.compareTo(c2.city1);
            }
        });
        return res;

    }
    private void getAllCity(List<Connection> list, Set<String> citySet) {
        for(Connection con: list) {
            citySet.add(con.city1);
            citySet.add(con.city2);
        }
    }
    private Connection fingMin(List<Connection> list, Set<String> visited) {
        Connection c = null;
        int min = Integer.MAX_VALUE;
        for(Connection con: list) {
            if(con.cost <= min) {
                if(visited.isEmpty()
                        || (!visited.contains(con.city1) && visited.contains(con.city2))
                        ||(!visited.contains(con.city2) && visited.contains(con.city1))) {
                    min = con.cost;
                    c = con;
                }
            }
        }return c;
    }
}
