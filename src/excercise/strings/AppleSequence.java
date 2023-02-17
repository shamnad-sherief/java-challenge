// There is a string of size n containing only 'A' and 'O'. 'A' stands for Apple, and 'O' stands for Orange.
// We have m number of spells, each spell allows us to convert an orange into an apple.
// Find the longest sequence of apples you can make, given a string and the value of m.

// source:- https://practice.geeksforgeeks.org/problems/38f100615d0b2efa755e7b07f905e0f8cd2fe5df/1

package excercise.strings;

public class AppleSequence {

    public static void main(String[] args) {

        int n = 5;
        int m = 1;
        String arr = "AAOAO";

        AppleSequenceSolution obj = new AppleSequenceSolution();

        System.out.println(obj.appleSequence(n, m, arr));
    }
}


class AppleSequenceSolution{
    public static int appleSequence(int n, int m, String arr){
        int i=0;  // Initialize i = 0
        int cntO=0;  // Initialize a counter cntO for the number of 'O's encountered
        int ans=0;  // Initialize a variable ans to hold the maximum sequence length

        // Loop through the string from the beginning
        for(int j=0;j<n;j++)
        {
            // If the current character is 'O', increment the count of 'O's encountered
            if(arr.charAt(j)=='O') cntO++;

            // If the count of 'O's encountered exceeds the maximum allowed (m),
            // move the pointer i forward and decrement the count until it's less than or equal to m.
            while(i<j && cntO>m)
            {
                if(arr.charAt(i)=='O') cntO--;
                i++;
            }

            // Update the maximum sequence length if the current sequence length is greater than the previous maximum.
            ans=Math.max(ans,(j-i+1));
        }

        // Return the maximum sequence length found.
        return ans;
    }
}