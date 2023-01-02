package excercise.recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
            int n = 3;
            towerOfHanoi(n,'A', 'B', 'C');
    }

    static void towerOfHanoi(int n, char A, char B,char C){   // source: A  auxiliary: B destination: C

        if (n > 0){
            // move n-1 disk to auxiliary tower  B  from A using C
            // move nth disk to tower C from A
            // move n-1 disk to destination tower C from B using A
            towerOfHanoi(n-1, A, C, B);
            System.out.println("Move "+ n + " Disk from " + A + " to " + C);
            towerOfHanoi(n-1, B, A, C);
        }
    }
}
