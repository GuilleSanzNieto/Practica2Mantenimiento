import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import tree.BinarySearchTree;
import tree.BinarySearchTreeException;

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
    @DisplayName("Prueba de que el valor ya existe en el insert salte la excepcion")
    @Test
    public void insertIncorrecto(){
        assertThrows(BinarySearchTreeException.class, ()->{
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
            bst.insert(5);
        });
    }

    @DisplayName("Prueba del isLeaf que salga bien")
    @Test
    public void isLeafCorrecto(){
        //Arrange 
        BinarySearchTree<Integer>bst = new BinarySearchTree<>(Integer::compareTo);
        //Act
        bst.insert(5);
        //Assert
        assertEquals(true,bst.isLeaf());
    }

    @DisplayName("Prueba del isLeaf que salga mal")
    @Test
    public void isLeafIncorrecto1(){
        //Arrange 
        BinarySearchTree<Integer>bst = new BinarySearchTree<>(Integer::compareTo);
        //Act
        bst.insert(5);
        bst.insert(3); 
        //Assert
        assertEquals(false,bst.isLeaf());
    }

    @DisplayName("Prueba del isLeaf que salga mal")
    @Test
    public void isLeafIncorrecto2(){
        //Arrange 
        BinarySearchTree<Integer>bst = new BinarySearchTree<>(Integer::compareTo);
        //Act
        bst.insert(5); 
        bst.insert(7);
        //Assert
        assertEquals(false,bst.isLeaf());
    }

    @DisplayName("Prueba del contains que salga bien, buscando el numero más grande")
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
    @DisplayName("Prueba del contains que salga bien, buscando un numero que no esta en el arbol que sea menor que nodo")
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
    @DisplayName("Prueba del contains que salga bien, buscando un numero que no este en el arbol mayor que nodo")
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
    
    @DisplayName("Prueba del minimo, que este correcto")
    @Test
    public void minimumCorrecto(){
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
        assertEquals(2,bst.minimum());
    }

    @DisplayName("Prueba del minimo, que salte la excepcion")
    @Test
    public void minimumIncorrecto(){
        assertThrows(BinarySearchTreeException.class, ()->{
            //Arrange 
            BinarySearchTree<Integer>bst = new BinarySearchTree<>(Integer::compareTo);
            //Act
            bst.minimum();
        });
    }

    @DisplayName("Prueba del maximo, que este correcto")
    @Test
    public void maximumCorrecto(){
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
        assertEquals(8,bst.maximum());
    }

    @DisplayName("Prueba del maximo, que salte la excepcion")
    @Test
    public void maximumIncorrecto(){
        assertThrows(BinarySearchTreeException.class, ()->{
            //Arrange 
            BinarySearchTree<Integer>bst = new BinarySearchTree<>(Integer::compareTo);
            //Act
            bst.maximum();
        });
    }

    @DisplayName("Prueba del removeBranch, que sea correcto y menor que el nodo")
    @Test
    public void removeBranchCorrecto(){
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
        bst.removeBranch(3);
        //Assert
        assertEquals("5(,7(6,8))",bst.render());
    }

    @DisplayName("Prueba del removeBranch, que salte la excepcion")
    @Test
    public void removeBranchIncorrecto(){
        assertThrows(BinarySearchTreeException.class, ()->{
            //Arrange 
            BinarySearchTree<Integer>bst = new BinarySearchTree<>(Integer::compareTo);
            //Act
            bst.removeBranch(3);
        });
    }

    @DisplayName("Prueba del removeBranch, que sea correcto y mayor que el nodo")
    @Test
    public void removeBranchCorrecto2(){
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
        bst.removeBranch(7);
        //Assert
        assertEquals("5(3(2,4),)",bst.render());
    }

    @DisplayName("Prueba del size, que sea correcto y árbol no nulo")
    @Test
    public void sizeCorrecto(){
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
        assertEquals(7,bst.size());
    }

    @DisplayName("Prueba del size, que sea un arbol nulo")
    @Test
    public void sizeCorrecto2(){
        //Arrange 
        BinarySearchTree<Integer>bst = new BinarySearchTree<>(Integer::compareTo);
        //Act
        //Assert
        assertEquals(0,bst.size());
    }

    @DisplayName("Prueba del depth, que sea correcto y árbol no nulo")
    @Test
    public void depthCorrecto(){
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
        assertEquals(3,bst.depth());
    }

    @DisplayName("Prueba del depth, que sea un arbol nulo")
    @Test
    public void depthCorrecto2(){
        //Arrange 
        BinarySearchTree<Integer>bst = new BinarySearchTree<>(Integer::compareTo);
        //Act
        //Assert
        assertEquals(0,bst.depth());
    }
}
