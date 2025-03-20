package tree;

public class BinarySearchTreeMain { 
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        System.out.println(bst.render());
        bst.removeBranch(3);
        System.out.println(bst.render());
    }
    
}
