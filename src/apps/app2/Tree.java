package apps.app2;

import java.util.function.Consumer;

public class Tree<T extends Comparable<T>> implements BinarySearchTree<T> {


    private Node<T> root; // first element
    private int size;

    private static class Node<T> {
        T element;
        Node<T> left;
        Node<T> right;

        public Node(T element) {
            this.element = element;
        }
    }

    @Override
    public String toString() {
        return "Tree root: " + root +
                "\nsize: " + size;
    }

    @Override
    public boolean insert(T element) {
        if (root == null) {
            root = new Node<>(element);
            size++;
            return true;
        } else {
            return insert(root, element);
        }
    }

    private boolean insert(Node<T> current, T element) {
        if (element.compareTo(current.element) < 0) { // go left
            if (current.left == null) {
                current.left = new Node<>(element);
                size++;
                return true;
            } else {
                return insert(current.left, element);
            }
        } else if (element.compareTo(current.element) > 0) { // go right
            if (current.right == null) {
                current.right = new Node<>(element);
                size++;
                return true;
            } else {
                return insert(current.right, element);
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(T element) {
        return contains(root, element);
    }

    private boolean contains(Node<T> current, T element) {
        if (current == null) {
            return false;
        } else if (element.compareTo(current.element) < 0) { // go left
            return contains(current.left, element);
        } else if (element.compareTo(current.element) > 0) { // gp right
            return contains(current.right, element);
        } else {
            return true;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int depth() {
        return root != null ? depth(root) - 1 : 0;
    }

    private int depth(Node<T> current) {
        if (current == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(current.left), depth(current.right));
        }
    }

    @Override
    public void inOrderTraversal(Consumer<T> consumer) {
        inOrderTraversal(root, consumer);
    }

    private void inOrderTraversal(Node<T> current, Consumer<T> consumer) {
        if (current != null) {
            inOrderTraversal(current.left, consumer);
            consumer.accept(current.element);
            inOrderTraversal(current.right, consumer);
        }
    }
}
