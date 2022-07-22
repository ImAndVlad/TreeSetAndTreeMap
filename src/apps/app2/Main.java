package apps.app2;

public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.insert(5);
        tree.insert(42);
        tree.insert(13);
        System.out.println(tree.insert(22));
        System.out.println(tree.insert(85));
        System.out.println(tree.contains(85));
        System.out.println(tree.depth());
    }
}
