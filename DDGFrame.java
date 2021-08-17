package teamProject;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DDGFrame extends JFrame implements ActionListener {
	private JPanel gameMain;
	private JButton duduGame1;
	private JButton jumpGame;
	private JButton blockGame;
	private ImageIcon duduimg = new ImageIcon("C://projectImage_png/default_dudu.png");
	private ImageIcon duduimg2 = new ImageIcon("C://projectImage_png/over_dudu.png");
	// private JButton gameRecord;

	Dudu duduframe1 = new Dudu();

	DDGFrame() {
		Dimension rscreen = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(600, 300);
		int rxpos = (int) (rscreen.getWidth() / 2 - getWidth() / 2);
		int rypos = (int) (rscreen.getHeight() / 2 - getHeight() / 2);
		setLocation(rxpos, rypos);
		setTitle("게임선택화면");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		gameMain = new JPanel();
		gameMain.setLayout(null);
		add(gameMain);
		duduGame1 = new JButton(duduimg);
		duduGame1.setRolloverIcon(duduimg2);
		jumpGame = new JButton(duduimg);
		jumpGame.setRolloverIcon(duduimg2);
		blockGame = new JButton(duduimg);
		blockGame.setRolloverIcon(duduimg2);
		// gameRecord = new JButton("기록실");

		duduGame1.setBorderPainted(false);
		jumpGame.setBorderPainted(false);
		blockGame.setBorderPainted(false);

		duduGame1.setBounds(0, 0, 200, 300);
		jumpGame.setBounds(199, 0, 200, 300);
		blockGame.setBounds(399, 0, 200, 300);
		// gameRecord.setBounds(75, 350, 130, 50);

		duduGame1.addActionListener(this);
		jumpGame.addActionListener(this);
		blockGame.addActionListener(this);
		// gameRecord.addActionListener(this);

		gameMain.add(duduGame1);
		gameMain.add(jumpGame);
		gameMain.add(blockGame);
		// gameMain.add(gameRecord);

		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == duduGame1) {
			if (duduframe1 == null) {
				duduframe1 = new Dudu();
				duduframe1.setVisible(true);
			} else {
				duduframe1.dispose();
				duduframe1 = new Dudu();
				duduframe1.setVisible(true);
			}
		} else if (e.getSource() == jumpGame) {

		} else if (e.getSource() == blockGame) {

		} // else if (e.getSource() == gameRecord) {

		// }
	}

	public static void main(String args[]) {
		new DDGFrame();
	}
}