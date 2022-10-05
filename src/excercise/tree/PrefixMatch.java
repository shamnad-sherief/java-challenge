//Geek has a list Li containing (not necessarily distinct) N words and Q queries.
// Each query consists of a string x. For each query, find how many strings in the List Li has the string x as its prefix.

// source:- https://practice.geeksforgeeks.org/problems/geek-and-strings3030/1
// solution using hash map:- https://github.com/shamnad-sherief/java-challenge/blob/main/src/excercise/hashmap/PrefixMatch.java

package excercise.tree;

import java.util.ArrayList;
import java.util.List;

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
        // code here
        List<Integer> res=new ArrayList<>();
        x = N;
        trie root = new trie();
        build(li, root);
        for(int i = 0;i < Q;i++)
            res.add(find(query[i], root));
        return res;
    }
    static int x;
    static class trie{
        int cnt;
        trie ch[];
        trie(){
            ch=new trie[26];
            cnt = 0;
            for(int i = 0;i < 26;i++)
                ch[i] = null;
        }
    }

    static void build(String a[], trie root){
        trie temp=null;
        for(int i = 0;i < x;i++){
            temp = root;
            for(int j = 0;j < a[i].length();j++){
                if(temp.ch[a[i].charAt(j)-'a'] == null)
                    temp.ch[a[i].charAt(j)-'a'] = new trie();
                temp.ch[a[i].charAt(j)-'a'].cnt += 1;
                temp = temp.ch[a[i].charAt(j)-'a'];
            }
        }
    }

    static int find(String s, trie root){
        for(int i = 0;i < s.length();i++){
            if(root.ch[s.charAt(i)-'a'] == null)
                return 0;
            root = root.ch[s.charAt(i)-'a'];
        }
        return root.cnt;
    }
}
