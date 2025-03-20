package tree;

import java.util.Comparator;
// import java.util.List;
// import java.util.ArrayList;

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
        if (this.value == null){
            this.value = value;
        }else{
            if (comparator.compare(value, this.value) < 0){
                if (this.left.isLeaf()){
                    this.left = new BinarySearchTree<T>(comparator);
                    this.left.value = value;
                }else{
                    this.left.insert(value);
                }
            }else{
                if (this.right.isLeaf()){
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
            }else if(comparator.compare(value, this.value) > 0){
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
        T min=  null;
        //El minimo estara  a la izquierda del arbol lo mas que se pueda y sera una hoja 
        if(this.left != null){
            min = this.left.minimum();
        }else if(this.left.isLeaf()){
            min = this.left.value;
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
        }else if(this.right.isLeaf()){
            max = this.right.value;
        }
        // TODO
        return max;
    }

    @Override
    public void removeBranch(T value){
        if(this.value==null){
            throw new BinarySearchTreeException("Arbol vacio");
        }
       
        if(comparator.compare(value, this.value) < 0){
            if(this.left != null){
                if(this.left.value.equals(value)){
                    this.left=null; 
                    this.right=null;
                }else{
                    this.left.removeBranch(value);
                }
            }
        }else if(comparator.compare(value, this.value) > 0){
            if(this.right != null){
                if(this.right.value.equals(value)){
                    this.right = null; 
                    this.left=null;
                }else{
                    this.right.removeBranch(value);
                }
            }
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
    // (Estas operaciones se incluirán más adelante para ser realizadas en la segunda
    // sesión de laboratorio de esta práctica)
}
