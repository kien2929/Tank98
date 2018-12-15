import base.game.GameCanvas;
import base.game.GameWindow;
import base.game.Settings;

import java.awt.*;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow window = new GameWindow();

        GameCanvas canvas = new GameCanvas();
        canvas.setPreferredSize(new Dimension(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT));
        window.add(canvas);
        window.pack();
        window.setVisible(true);
        canvas.gameLoop();
    }
}
//        Student student1 = new Student();
//        Student student2 = new Student();
//        student1.print(); // this = student1
//        student2.name = "Nguyen Thi B";
//        student2.code = "sb11111";
//        student2.print(); // this = student2
    //sum()
    //access modifier: public/protected/default/private
    //
//    public static double sum(double a, double b) {
//        return a + b;
//    }
//
//    public static void main(String[] args) {
//        double result = sum(1, 2);
//        if (result > 3) {
//            System.out.println("Big number");
//        } else {
//            System.out.println("Small number");
//        }
//        int number = 1;
//        switch (number) {
//            case 1:
//                System.out.println("1");
//                break;
//            case 2:
//                System.out.println("2");
//                break;
//            default:
//                System.out.println("Unknown number");
//        }
//
//        String s;
//        Clock clock;
//        clock.run();
//        while (true) {
//
//        }
//        do {
//            System.out.println(1);
//        } while (true);
//        for (int i = 0; i < 100; i++) {
//        }
//    }
//}
