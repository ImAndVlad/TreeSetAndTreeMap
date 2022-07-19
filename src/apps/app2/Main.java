package apps.app2;

public class Main {


    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.insert(22);
        tree.insert(13);
        tree.insert(5);
        tree.insert(76);
        tree.insert(31);

        System.out.println(tree);
    }
}
