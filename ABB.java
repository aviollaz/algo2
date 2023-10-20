package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    Nodo root;
    int height;
    int cardinal;
    

    private class Nodo {
        T value;
        Nodo left;
        Nodo right;
        Nodo parent;

        public Nodo(T elem){
            value = elem;
            left = null;
            right = null;
            parent = null;

        }


    }

    public ABB() {
        root = null;
        height = 0;
        cardinal = 0;
    }

    public int cardinal() {
        return cardinal;
    }

    public T minimo(){
        Nodo current = root;
        T res = null;
        if(current != null){
            while(current.left != null){
            current = current.left;
            }
            res = current.value;
        }
        return res;
        
    }

    public T maximo(){
        Nodo current = root;
        T res = null;
        if(current != null){
            while(current.right != null){
                current = current.right;
            }
            res = current.value;
        }

        return res;
    }

    public void insertar(T elem){
        Nodo current = root;
        boolean finished = false;
    
        if(current == null){
            Nodo newRoot = new Nodo(elem);
            newRoot.left = null;
            newRoot.right = null;
            newRoot.parent = null;
            root = newRoot;
            cardinal++;

        }

        while(current != null && !finished && elem.compareTo(current.value) != 0){

            if(elem.compareTo(current.value) < 0 && current.left != null){
                current = current.left;
            } else if(elem.compareTo(current.value) < 0 && current.left == null){
                Nodo leftNode = new Nodo(elem);
                leftNode.left = null;
                leftNode.right = null;
                leftNode.parent = current;
                current.left = leftNode;

                finished = true;
                cardinal++;

            } 

            if(elem.compareTo(current.value) > 0 && current.right != null){
                current = current.right;
            } else if(elem.compareTo(current.value) > 0 && current.right == null){
                Nodo rightNode = new Nodo(elem);
                rightNode.left = null;
                rightNode.right = null;
                rightNode.parent = current;
                current.right = rightNode;
                
                finished = true;
                cardinal++;
            }
        }

    }

    public boolean pertenece(T elem){
        boolean res = false;
        Nodo current = root;

        if(current != null){

            while(current != null && !res){
                if(elem.compareTo(current.value) < 0/*  && current.left != null*/){
                    current = current.left;
                } else if(elem.compareTo(current.value) == 0 ){
                    res = true;
                }

                if(elem.compareTo(current.value) > 0 /*  && current.right != null */){
                    current = current.right;
                } else if(elem.compareTo(current.value) == 0){
                    res = true;
                }
            }
        }

        return res;
        
        
    }

    public void eliminar(T elem){
        Nodo current = root;
        if (current != null){
            while(current != null && elem.compareTo(current.value) != 0){
                if(elem.compareTo(current.value) < 0){
                    current = current.left;
                }
                if(elem.compareTo(current.value) > 0){
                    current = current.right;
                }
            }
            
            if(current != null){
                if(current.left == null && current.right == null){

                }
            }
        }
        
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
