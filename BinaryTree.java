public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

    private static class Node<E> {
        E value;
        Node<E> left;
        Node<E> right;

        Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public BinaryTree() {
        this.root = null;
    }

    public void insert(E value) {
        root = insertRec(root, value);
    }

    private Node<E> insertRec(Node<E> root, E value) {
        if (root == null) {
            root = new Node<>(value);
            return root;
        }
        if (value.compareTo(root.value) < 0) {
            root.left = insertRec(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }
    
    
    //Buscar
    public E search(E value) {
        return searchRec(root, value);
    }

    private E searchRec(Node<E> current, E value) {
        if (current == null) return null;

        if (value.compareTo(current.value) == 0) {
            return current.value;
        }

        if (value.compareTo(current.value) < 0) {
            return searchRec(current.left, value);
        } else {
            return searchRec(current.right, value);
        }
    }

    //ordenar
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node<E> current) {
        if (current != null) {
            inOrderRec(current.left);
            System.out.println(current.value);
            inOrderRec(current.right);
        }
    }
}
    
