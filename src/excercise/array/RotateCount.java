package excercise.array;

//given a sorted and rotated array of length N. Find the number of times of array rotated
// [IN]: arr={3,4,5,1,2}
// [OUT] : 2
// the above array is rotated 2 times
public class RotateCount {
    public static void main(String[] args) {
        int[] arr={4,5,8,9,1,3};

        int min=arr[0];  //assigning minimum value is at index 0
        int min_index=0;  //minimum index is 0
        for(int i=0;i< arr.length;i++){
            if(min>arr[i]){
                min=arr[i];
                min_index=i;
            }
        }

        System.out.println(arr.length-min_index);
    }
}
