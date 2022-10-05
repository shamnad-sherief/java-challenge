//Geek has a list Li containing (not necessarily distinct) N words and Q queries.
// Each query consists of a string x. For each query, find how many strings in the List Li has the string x as its prefix.

// source:- https://practice.geeksforgeeks.org/problems/geek-and-strings3030/1


package excercise.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrefixMatch {
    public static void main(String[] args) {

        int N = 5;
        int Q = 5;
        String[] li = {"abracadabra", "geeksforgeeks", "abracadabra", "geeks", "geeksthrill"};
        String[] query = {"abr", "geeks", "geeksforgeeks", "ge", "gar"};

        PrefixMatchSolution s1 = new PrefixMatchSolution();

        System.out.println(s1.prefixCount(N,Q,li,query));

    }

}

class PrefixMatchSolution{
    static List<Integer> prefixCount(int N, int Q, String li[], String query[])
    {
        Map<String, Integer> map =  new HashMap<>();
        for(int i = 0; i < N; ++i){
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < li[i].length(); ++j){
                sb.append(li[i].charAt(j));
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(String q : query){
            res.add(map.getOrDefault(q,0));
        }
        return res;
    }
}
