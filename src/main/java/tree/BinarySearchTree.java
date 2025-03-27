package tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinarySearchTree<T> implements BinarySearchTreeStructure<T> {
    private Comparator<T> comparator;
    private T value;
    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;

    public String render(){
        String render = "";

        if (value != null) {
            render += value.toString();
        }

        if (left != null || right != null) {
            render += "(";
            if (left != null) {
                render += left.render();
            }
            render += ",";
            if (right != null) {
                render += right.render();
            }
            render += ")";
        }

        return render;
    }

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
        this.value = null;
        this.left = null; 
        this.right = null; 
        
        // TODO
    }

    @Override
    public void insert(T value) {
        if(value.equals(this.value)){
            throw new BinarySearchTreeException("El valor ya existe");
        }

        if (this.value == null){
            this.value = value;
        }else{
            if (comparator.compare(value, this.value) < 0){
                if (this.left == null){
                    this.left = new BinarySearchTree<T>(comparator);
                    this.left.value = value;
                }else{
                    this.left.insert(value);
                }
            }else{
                if (this.right==null){
                    this.right = new BinarySearchTree<T>(comparator);
                    this.right.value = value;
                }else{
                    this.right.insert(value);
                }
            }
        }
        // TODO
    }

    @Override
    public boolean isLeaf() {
        // TODO
        return this.left == null && this.right == null;
    }

    @Override
    public boolean contains(T value) {
        //Recorro todo el arbol y si encuentro el valor entonces retorno true
        //si no lo encuentro retorno false
        boolean cont = false; 
        if(this.value.equals(value)){
            cont = true;
        }else{
           if(comparator.compare(value, this.value) < 0){
                if(this.left != null){
                     cont = this.left.contains(value);
                }
            }else{
                if(this.right != null){
                    cont = this.right.contains(value);
                }
            }
        // TODO
        }
        return cont;
        
    }
    @Override
    public T minimum() {
        if(this.value==null){
            throw new BinarySearchTreeException("Arbol vacio");
        }
        T min =  null;
        //El minimo estara  a la izquierda del arbol lo mas que se pueda
        if(this.left != null){
            min = this.left.minimum();
        }else {
            min = this.value;
        }
        // TODO
        return min;
    }

    @Override
    public T maximum() {
        if(this.value==null){
            throw new BinarySearchTreeException("Arbol vacio");
        }
        T max = null;
        //El maximo estara a la derecha del arbol lo mas que se pueda y sera una hoja
        if(this.right != null){
            max = this.right.maximum();
        }else {
            max = this.value;
        }
        // TODO
        return max;
    }

    @Override
    public void removeBranch(T value){
        if(this.value==null || !this.contains(value)){
            throw new BinarySearchTreeException("Arbol vacio");
        }
       
        if(comparator.compare(value, this.value) < 0){
            this.left.removeBranch(value);
            
        }else if(comparator.compare(value, this.value) > 0){
            this.right.removeBranch(value);
            
        }else{
            this.value=null; 
            this.left=null; 
            this.right=null; 
        }
    }

    @Override
    public int size() {
        int cont = 0;
        //Recorro todo el arbol y por cada nodo que no sea nulo aumento el contador
        if(this.value != null){
            cont++;
            if(this.left != null){
                cont += this.left.size();
            }
            if(this.right != null){
                cont += this.right.size();
            }
        }
        //TODO
        return cont;
    }

    @Override
    public int depth() {
        int depth = 0; 
        if(this.value != null){
            int ileft =0; 
            int irigth = 0; 
            if(this.left != null){
                ileft += this.left.depth();
            }
            if(this.right != null){
                irigth += this.right.depth();
            }
            depth = Math.max(ileft, irigth) + 1;
        }else{
            depth = 0;
        }
                // TODO
        return depth;
    }

    // Complex operations

    /**
     * Removes the first occurrence of the specified element from this binary search tree, if it is present.
     *
     * @param value to be removed from this binary tree, if present
     * @throws BinaryTreeException if the element is not present in the binary tree
     */
    public void removeValue(T value) {
        if (!contains(value) || this.value == null){
            throw new BinarySearchTreeException("El valor no lo contiene o el árbol está vacío");
        }

        if(comparator.compare(value, this.value) < 0){
            if(this.left != null){
                this.left.removeValue(value);
            }
        }
        else if(comparator.compare(value, this.value) > 0){
            if(this.right != null){
                this.right.removeValue(value);
            }
        }
        else{
            T arbolaux = this.right.minimum();
            this.value = arbolaux;
            removeBranch(arbolaux);
        }
    }

    /**
     * Returns a List of all the values of the tree in order.
     *
     * @return a List of all the values of the tree in order
     */
    public List<T> inOrder(){
        List<T> lista = new ArrayList<>();

        if(this.value != null){
            if(this.left != null){
                lista.addAll(this.left.inOrder());
            }
            lista.add(this.value);
            
            if(this.right != null){
                lista.addAll(this.right.inOrder());
            }
        }

        return lista;
    }

    /**
     * Balance the binary search tree. Making the depth of the
     * left and right subtrees of every node differ by at most one.
     */
    public void balance(){
        List<T> lista = inOrder();
        BinarySearchTree<T> arbol = new BinarySearchTree<>(comparator);
        balanceAux(lista, arbol);
        this.value = arbol.value;
        this.left = arbol.left;
        this.right = arbol.right;      

    }

    private void balanceAux(List<T> lista, BinarySearchTree<T> arbol){
        if(lista.size() == 1){
            arbol.insert(lista.get(0));
        }
        else if(lista.size() > 1){
            int mitad = lista.size() / 2;
            arbol.insert(lista.get(mitad));
            List<T> izq = lista.subList(0, mitad);
            List<T> der = lista.subList(mitad + 1, lista.size());
            balanceAux(izq, arbol);
            balanceAux(der, arbol);
        }
    }
}
