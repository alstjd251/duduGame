package teamProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Dudu extends JFrame {
	private JPanel backjp;
	private JPanel buttonPanel = new JPanel();
	private ImageIcon back = new ImageIcon("C://duduback.jpg");
	private JButton start = new JButton("시작");
	private JButton end = new JButton("종료");
	private JButton record = new JButton("기록실");
	
	private GridLayout duduLayout = new GridLayout(3, 4);
	
	public Dudu(String title) {
		super(title);
		super.setSize(300, 500);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int) (screen.getWidth() / 2 - super.getWidth() / 2);
		int ypos = (int) (screen.getHeight() / 2 - super.getHeight() / 2);
		super.setLocation(xpos, ypos);
		backjp = new JPanel() {
            public void paintComponent(Graphics g) {
            	Dimension backd = getSize();
                g.drawImage(back.getImage(), 0, 0, backd.width, backd.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
		};
		backjp.setLayout(new BorderLayout());
		super.add(backjp);
		super.setResizable(false);
		super.setVisible(true);
	}
	
	public void init() {
		backjp.add("SOUTH", buttonPanel);
		buttonPanel.setLayout(new GridLayout(1, 3));
		buttonPanel.add(start);
		buttonPanel.add(end);
		buttonPanel.add(record);
	}
}

public class DDGFrame {
	public static void main(String[] ar) {
		new Dudu("두더지게임");
	}
}