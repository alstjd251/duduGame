package teamProject;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DDGFrame extends JFrame implements ActionListener {
	private JPanel gameMain;
	private JButton duduGame;
	private JButton jumpGame;
	private JButton blockGame;
	//private JButton gameRecord;
	//메인화면에서 DuduRecord 그대로쓰면 이상한상황이 발생함

	Dudu duduframe = new Dudu();

	DDGFrame() {
		Dimension rscreen = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(300, 500);
		int rxpos = (int) (rscreen.getWidth() / 2 - getWidth() / 2);
		int rypos = (int) (rscreen.getHeight() / 2 - getHeight() / 2);
		setLocation(rxpos, rypos);
		setTitle("게임선택화면");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		gameMain = new JPanel();
		gameMain.setLayout(null);
		add(gameMain);
		duduGame = new JButton("두더지 게임");
		jumpGame = new JButton("점프 게임");
		blockGame = new JButton("블록부수기 게임");
		//gameRecord = new JButton("기록실");

		duduGame.setBounds(75, 50, 130, 50);
		jumpGame.setBounds(75, 150, 130, 50);
		blockGame.setBounds(75, 250, 130, 50);
		//gameRecord.setBounds(75, 350, 130, 50);

		duduGame.addActionListener(this);
		jumpGame.addActionListener(this);
		blockGame.addActionListener(this);
		//gameRecord.addActionListener(this);

		gameMain.add(duduGame);
		gameMain.add(jumpGame);
		gameMain.add(blockGame);
		//gameMain.add(gameRecord);

		setResizable(false);
		setVisible(true);
	}

	public static void main(String args[]) {
		new DDGFrame();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == duduGame) {
			if (duduframe == null) {
				duduframe = new Dudu();
				duduframe.setVisible(true);
			} else {
				duduframe.dispose();
				duduframe = new Dudu();
				duduframe.setVisible(true);
			}
		} else if (e.getSource() == jumpGame) {

		} else if (e.getSource() == blockGame) {

		} //else if (e.getSource() == gameRecord) {

		//}
	}
}