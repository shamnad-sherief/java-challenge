//Your task is to arrange the all the distinct items in lexicographical ascending order and print them along with their count.

// source:- https://practice.geeksforgeeks.org/problems/earthquake-and-the-paint-shop4518/1

package excercise.hashmap;

import java.util.TreeMap;

public class SortSetOfStrings {
    public static void main(String[] args) {

        int N = 2;
        String A[] ={"3122049353 onafrnbhtr 9822827304 yzfhdgzcvx",
                "2992299540 lpvkgykmlk 6946169466 vdqwvywwgg"};

        SortSetOfStringsSolution s1 = new SortSetOfStringsSolution();

        alphanumeric ans[] = s1.sortedStrings(N,A);

        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i].name + " "+ans[i].count);
        }
    }
}

class alphanumeric {
    public String name;
    public int count;
    alphanumeric(String name, int count) {
        this.name = name;
        this.count = count;
    }
}

class SortSetOfStringsSolution {
    alphanumeric[] sortedStrings(int N, String A[]) {

        TreeMap<String,Integer> mp = new TreeMap<>();

        for(String s: A){
            mp.put(s,mp.getOrDefault(s,0)+1);
        }

        int k = mp.size();
        alphanumeric[] ans = new alphanumeric[k];
        int t = 0;

        for(String s:mp.keySet()){
            ans[t++] = new alphanumeric(s,mp.get(s));
        }

        return ans;
    }
};
