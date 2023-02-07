// Given a Binary Search Tree with unique node values and a target value. You have to find the node whose data is equal to target
// and return the sum of all descendant (of target) node's data which are vertically below the target node. Initially, you are at the root node.
// Note: If target node is not present in bst then return -1.

// source:- https://practice.geeksforgeeks.org/problems/c85e3a573a7de6dfd18398def16d05387852b319/1

package excercise.tree;

public class TargetAndVerticalNodes {
    Node root;

    TargetAndVerticalNodes() {
        root = null;
    }

    public static void main(String[] args) {
        TargetAndVerticalNodes node = new TargetAndVerticalNodes();
        node.root = new Node(25);
        node.root.left = new Node(20);
        node.root.right = new Node(35);
        node.root.left.left = new Node(15);
        node.root.left.right = new Node(22);
        node.root.right.left = new Node(30);
        node.root.right.right = new Node(45);
        node.root.right.right.right = new Node(32);

        TargetAndVerticalNodesSolution obj = new TargetAndVerticalNodesSolution();

        int target = 25;

        System.out.println(obj.verticallyDownBST(node.root, target));
    }
}

class TargetAndVerticalNodesSolution {
    long res = 0l;
    long verticallyDownBST(Node root, int target) {
        while(root != null) {
            if(root.data > target) {
                root = root.left;
            } else if(root.data < target) {
                root = root.right;
            } else {
                break;
            }
        }
        if(root == null) return -1l;
        vertical(root, 0);
        res -= target;
        return res;
    }

    private void vertical(Node root, int dir) {
        if(root == null) return;
        if(dir == 0) {
            res += root.data;
        }
        vertical(root.left, dir-1);
        vertical(root.right, dir+1);
    }
}