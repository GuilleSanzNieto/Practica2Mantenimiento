import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//Guillermo Sanz Nieto y Marta Vegas Cuevas
//Grupo G

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import tree.BinarySearchTree;
import tree.BinarySearchTreeException;

public class BinarySearchTreeTest {

    @Nested
    @DisplayName("Pruebas de Insert")
    class InsertTests {
        @Test
        @DisplayName("Insertar correctamente")
        void insertCorrecto() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(3);
            bst.insert(7);
            bst.insert(2);
            bst.insert(4);
            bst.insert(6);
            bst.insert(8);
            assertEquals("5(3(2,4),7(6,8))", bst.render());
        }

        @Test
        @DisplayName("Insertar un valor existente debe lanzar una excepción")
        void insertIncorrecto() {
            assertThrows(BinarySearchTreeException.class, () -> {
                BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
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
    }

    @Nested
    @DisplayName("Pruebas de isLeaf")
    class IsLeafTests {
        @Test
        @DisplayName("Debe ser una hoja")
        void isLeafCorrecto() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            assertEquals(true, bst.isLeaf());
        }

        @Test
        @DisplayName("No debe ser una hoja (hijo izquierdo)")
        void isLeafIncorrecto1() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(3);
            assertEquals(false, bst.isLeaf());
        }

        @Test
        @DisplayName("No debe ser una hoja (hijo derecho)")
        void isLeafIncorrecto2() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(7);
            assertEquals(false, bst.isLeaf());
        }
    }

    @Nested
    @DisplayName("Pruebas de Contains")
    class ContainsTests {
        @Test
        @DisplayName("Debe encontrar un número existente")
        void containsCorrecto() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(3);
            bst.insert(7);
            bst.insert(2);
            bst.insert(4);
            bst.insert(6);
            bst.insert(8);
            assertEquals(true, bst.contains(6));
        }

        @Test
        @DisplayName("No debe encontrar un número menor")
        void containsIncorrectoMenor() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            assertEquals(false, bst.contains(1));
        }

        @Test
        @DisplayName("No debe encontrar un número mayor")
        void containsIncorrectoMayor() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            assertEquals(false, bst.contains(9));
        }
    }

    @Nested
    @DisplayName("Pruebas de Mínimo")
    class MinimumTests {
        @Test
        @DisplayName("Debe encontrar el valor mínimo")
        void minimumCorrecto() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(3);
            bst.insert(2);
            assertEquals(2, bst.minimum());
        }

        @Test
        @DisplayName("Debe lanzar excepción si el árbol está vacío")
        void minimumIncorrecto() {
            assertThrows(BinarySearchTreeException.class, () -> new BinarySearchTree<>(Integer::compareTo).minimum());
        }
    }

    @Nested
    @DisplayName("Pruebas de Máximo")
    class MaximumTests {
        @Test
        @DisplayName("Debe encontrar el valor máximo")
        void maximumCorrecto() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(7);
            bst.insert(8);
            assertEquals(8, bst.maximum());
        }

        @Test
        @DisplayName("Debe lanzar excepción si el árbol está vacío")
        void maximumIncorrecto() {
            assertThrows(BinarySearchTreeException.class, () -> new BinarySearchTree<>(Integer::compareTo).maximum());
        }
    }

    @Nested
    @DisplayName("Pruebas de RemoveBranch")
    class RemoveBranchTests {
        @Test
        @DisplayName("Debe eliminar un nodo menor")
        void removeBranchCorrecto() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(3);
            bst.removeBranch(3);
            assertEquals("5(,)", bst.render());
        }

        @Test
        @DisplayName("Debe lanzar excepción si el nodo no existe")
        void removeBranchIncorrecto() {
            assertThrows(BinarySearchTreeException.class, () -> {
                BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
                bst.removeBranch(3);
            });
        }

        @Test
        @DisplayName("Debe eliminar un nodo mayor")
        void removeBranchCorrecto2() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(7);
            bst.removeBranch(7);
            assertEquals("5(,)", bst.render());
        }

        @Test
        @DisplayName("Debe lanzar excepción si el nodo no existe")
        void removeBranchIncorrecto2() {
            assertThrows(BinarySearchTreeException.class, () -> {
                BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
                bst.insert(5);
                bst.removeBranch(1);
            });
        }
    }

    @Nested
    @DisplayName("Pruebas de Size")
    class SizeTests {
        @Test
        @DisplayName("Debe retornar el tamaño correcto y arbol izquierdo no vacio")
        void sizeCorrecto() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(3);
            assertEquals(2, bst.size());
        }

        @Test
        @DisplayName("Debe retirnar el tamaño correcto y arbol derecho no vacio")
        void sizeCorrecto2(){
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(7);
            assertEquals(2, bst.size());
        }

        @Test
        @DisplayName("Debe retornar 0 si el árbol está vacío")
        void sizeVacio() {
            assertEquals(0, new BinarySearchTree<>(Integer::compareTo).size());
        }
    }

    @Nested
    @DisplayName("Pruebas de Depth")
    class DepthTests {
        @Test
        @DisplayName("Debe retornar la profundidad correcta y arbol a la izquierda")
        void depthCorrecto() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(3);
            assertEquals(2, bst.depth());
        }
        @Test
        @DisplayName("Debe retornar la profundidad corrceta y arbol es hacia la derecha")
        void depthCorrecto2(){
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(7);
            assertEquals(2, bst.depth());
        }

        @Test
        @DisplayName("Debe retornar 0 si el árbol está vacío")
        void depthVacio() {
            assertEquals(0, new BinarySearchTree<>(Integer::compareTo).depth());
        }
    }

    @Nested
    @DisplayName("Pruebas de Render")
    class RenderTests {
        @Test
        @DisplayName("Debe renderizar correctamente cuando solo hay un hijo izquierdo")
        void renderCorrecto() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(3);
            assertEquals("5(3,)", bst.render());
        }

        @Test
        @DisplayName("Debe renderizar correctamente cuando solo hay un hijo derecho")
        void renderCorrecto2() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(7);
            assertEquals("5(,7)", bst.render());
        }
    }

    @Nested
    @DisplayName("Pruebas de removeValue")
    class RemoveValueTests{
        @Test
        @DisplayName("Debe lanzar excepción si el nodo no existe")
        void removeValueIncorrecto() {
            assertThrows(BinarySearchTreeException.class, () -> {
                BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
                bst.removeValue(3);
            });
        }

        @Test
        @DisplayName("Debe lanzar excepción si el árbol está vacío")
        void removeValueIncorrecto2() {
            assertThrows(BinarySearchTreeException.class, () -> {
                BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
                bst.removeValue(5);
            });
        }

        @Test
        @DisplayName("Debe lanzar excepción si el valor no está en el árbol")
        void removeValueIncorrecto3() {
            assertThrows(BinarySearchTreeException.class, () -> {
                BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
                bst.insert(5);
                bst.insert(3);
                bst.insert(7);
                bst.removeValue(1);
            });
        }
        
        @Test
        @DisplayName("Debe eliminar un nodo hoja")
        void removeValueCorrecto() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(3);
            bst.insert(7);
            bst.removeValue(3);
            assertEquals("5(,7)", bst.render());
        }

        @Test
        @DisplayName("Debe eliminar un nodo con un hijo a la derecha")
        void removeValue_hijoDer() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(3);
            bst.insert(7);
            bst.insert(8);
            bst.removeValue(7);
            assertEquals("5(3,8)", bst.render());
        }

        @Test
        @DisplayName("Debe eliminar un nodo con un hijo a la izquierda")
        void removeValue_hijoIzq(){
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(3);
            bst.insert(2);
            bst.insert(7);
            bst.removeValue(3);
            assertEquals("5(2,7)", bst.render());
        }

        

        @Test
        @DisplayName("Debe eliminar un nodo con dos hijos")
        void removeValueCorrecto3() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(5);
            bst.insert(3);
            bst.insert(7);
            bst.removeValue(5);
            assertEquals("7(3,)", bst.render());
        }   
    }

    @Nested
    @DisplayName("Pruebas de InOrder")
    class InOrderTests {
        @Test
        @DisplayName("caso en el que el arbol sea null")
        void inOrder_Incorrecto(){
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            assertEquals("[]", bst.inOrder().toString());
        }
    }

    @Nested
    @DisplayName("Pruebas de Balance")
    class BalanceTests {
        @Test
        @DisplayName("Debe retornar el balance correcto")
        void balanceCorrecto() {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
            bst.insert(6);
            bst.insert(4);
            bst.insert(8);
            bst.insert(7);
            bst.insert(9);
            bst.insert(10);

            bst.balance();

            assertEquals("8(6(4,7),10(9,))", bst.render());
        }
    }
}
