package apps.app3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static class Ball {
    }

    private static class Board {
        /* (private List balls;) - original code
        I add generics(strict typification) and made balls static */
        private static List<Ball> balls;

        public Board() {
            /* (List balls = new ArrayList<>();) - original code
            I remove the type for the variable balls */
            balls = new ArrayList<>();
            balls.add(new Ball());
            balls.add(new Ball());
            balls.add(new Ball());
        }

        public int count() {
            return balls.size();
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.count());
    }
}
