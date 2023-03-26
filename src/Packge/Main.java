package Packge;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        affine f=new affine();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocation(new Point(500, 300));
        f.setSize(500,400);
        f.setVisible(true);

    }
}
