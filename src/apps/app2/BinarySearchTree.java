package apps.app2;

import java.util.function.Consumer;

public interface BinarySearchTree<T extends Comparable<T>>{

    boolean insert(T element); // add element

    boolean contains(T element); // element check

    int size(); // size

    int depth(); // tree depth check

    void inOrderTraversal(Consumer<T> consumer); // walk in order
}
