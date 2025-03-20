import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import tree.BinarySearchTree;

public class BinarySearchTreeTest {
    // Test que tenemos que hacer 
    // Una preuba para ver si constains funciona bien
    //Prueba del TMinimo
        //si el valor es null que salta la excepcion 
        //si el valor no es null que retorne el valor minimo
    //Prueba del TMaximo
        //si el valor es null que salta la excepcion 
        //si el valor no es null que retorne el valor maximo
    //Prueba del removeBranch
        //si el valor no esta en el arbol que salte la excepcion
        //si el valor esta en el arbol que lo elimine
    //Prueba del size
        //si el arbol esta vacio que retorne 0
        //si el arbol no esta vacio que retorne el tamaño del arbol
    //Prueba del depth
        //si el arbol esta vacio que retorne 0
        //si el arbol no esta vacio que retorne la profundidad del arbol
    
    @DisplayName("Pruebos del insert Test ")
    @Test
    public void insertCorrecto(){
        //Arrange 
        BinarySearchTree<Integer>bst = new BinarySearchTree<>(Integer::compareTo);
        //Act
        bst.insert(5);
        bst.insert(3);  
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        //Assert
        assertEquals("5(3(2,4),7(6,8))",bst.render());
    }
    @DisplayName("Prueba del containst que salga bien, buscando el numero más grande")
    @Test
    public void containsCorrecto(){
        //Arrange 
        BinarySearchTree<Integer>bst = new BinarySearchTree<>(Integer::compareTo);
        //Act
        bst.insert(5);
        bst.insert(3);  
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        //Assert
        assertEquals(true,bst.contains(6));
    }
    @DisplayName("Prueba del containst que salga bien, buscando un numero que no esta en el arbol que sea menor que nodo")
    @Test
    public void containsCorrecto3(){
        //Arrange 
        BinarySearchTree<Integer>bst = new BinarySearchTree<>(Integer::compareTo);
        //Act
        bst.insert(5);
        bst.insert(3);  
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        //Assert
        assertEquals(false,bst.contains(1));
    }
    @DisplayName("Prueba del containts que salga bien, buscando un numero que no este en el arbol mayor que nodo")
    @Test
    public void containsCorrecto4(){
        //Arrange 
        BinarySearchTree<Integer>bst = new BinarySearchTree<>(Integer::compareTo);
        //Act
        bst.insert(5);
        bst.insert(3);  
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        //Assert
        assertEquals(false,bst.contains(9));
    }

}
