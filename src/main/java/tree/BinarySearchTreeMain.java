package tree;

//Guillermo Sanz Nieto y Marta Vegas Cuevas
//Grupo G

public class BinarySearchTreeMain { 
    /* 
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
        //bst.removeBranch(3);
        System.out.println(bst.render());
        //bst.inOrder();
        System.out.println(bst.inOrder());
    }
    */
    
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
        bst.insert(50);
        bst.insert(40);
        bst.insert(30);
        bst.insert(20);
        bst.insert(35);
        bst.insert(60);
        System.out.println(bst.render());
        bst.removeValue(40);
        System.out.println(bst.render());
        System.out.println(bst.inOrder());
        bst.balance();
        System.out.println(bst.render());
    }
}
