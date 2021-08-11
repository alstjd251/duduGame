package teamProject;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Dudu extends JFrame implements MouseListener, ActionListener {
	private Image background = new ImageIcon("c://projectImage_png/duduback.png").getImage();
	private JPanel panel;
	private JLabel[] holes = new JLabel[9];
	private int[] board = new int[9];
	private int score = 0;
	private JLabel lblScore;
	private JLabel lblTimeLeft;
	private JLabel lblHighscore;
	private Toolkit tk = Toolkit.getDefaultToolkit();

	private int timeLeft = 30;
	// private int highscore = 0;

	private JButton btnStart;
	private JButton btnEnd;
	private JButton btnRecord;

	private Timer timer;

	private DuduRecord dr;
	
	private ImageIcon loadImage(String path) {
		Image image = new ImageIcon(this.getClass().getResource(path)).getImage();
		Image scaledImage = image.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(scaledImage);
	}

	private void genRandMole() {
		Random rnd = new Random(System.currentTimeMillis());
		int moleID = rnd.nextInt(9);
		board[moleID] = 1;
		holes[moleID].setIcon(loadImage("/dudu.png"));
	}

	private void clearBoard() {
		for (int i = 0; i < 9; i++) {
			holes[i].setIcon(loadImage("/hit.png"));
			board[i] = 0;
		}
	}

	private void initGUI() {
		setTitle("두더지 게임");
		setSize(500, 800);
		Dimension rscreen = Toolkit.getDefaultToolkit().getScreenSize();
		int rxpos = (int) (rscreen.getWidth() / 2 - getWidth() / 2);
		int rypos = (int) (rscreen.getHeight() / 2 - getHeight() / 2);
		setLocation(rxpos, rypos);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension back = getSize();
				g.drawImage(background, 0, 0, back.width, back.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		contentPane.setBackground(new Color(0, 51, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JLabel lblTitle = new JLabel("두더지 잡기");
		lblTitle.setForeground(new Color(153, 204, 0));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 500, 50);
		contentPane.add(lblTitle);
		panel = new JPanel();
		panel.setBackground(new Color(0, 102, 0));
		panel.setBounds(30, 100, 420, 520);
		panel.setLayout(null);
		contentPane.add(panel);

		holes[0] = new JLabel("0");
		holes[0].setName("0");
		holes[0].setBounds(0, 390, 130, 130);
		panel.add(holes[0]);

		holes[1] = new JLabel("1");
		holes[1].setName("1");
		holes[1].setBounds(130, 390, 130, 130);
		panel.add(holes[1]);

		holes[2] = new JLabel("2");
		holes[2].setName("2");
		holes[2].setBounds(260, 390, 130, 130);
		panel.add(holes[2]);

		holes[3] = new JLabel("3");
		holes[3].setName("3");
		holes[3].setBounds(0, 260, 130, 130);
		panel.add(holes[3]);

		holes[4] = new JLabel("4");
		holes[4].setName("4");
		holes[4].setBounds(130, 260, 130, 130);
		panel.add(holes[4]);

		holes[5] = new JLabel("5");
		holes[5].setName("5");
		holes[5].setBounds(260, 260, 130, 130);
		panel.add(holes[5]);

		holes[6] = new JLabel("6");
		holes[6].setName("6");
		holes[6].setBounds(0, 130, 130, 130);
		panel.add(holes[6]);

		holes[7] = new JLabel("7");
		holes[7].setName("7");
		holes[7].setBounds(130, 130, 130, 130);
		panel.add(holes[7]);

		holes[8] = new JLabel("8");
		holes[8].setName("8");
		holes[8].setBounds(260, 130, 130, 130);
		panel.add(holes[8]);

		lblScore = new JLabel("Score: 0");
		lblScore.setHorizontalAlignment(SwingConstants.TRAILING);
		lblScore.setForeground(new Color(135, 206, 250));
		lblScore.setBounds(300, 20, 140, 30);
		contentPane.add(lblScore);

		lblTimeLeft = new JLabel("30");
		lblTimeLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeLeft.setForeground(new Color(240, 128, 128));
		lblTimeLeft.setBounds(230, 50, 140, 30);
		contentPane.add(lblTimeLeft);

		lblHighscore = new JLabel("Highscore: 0");
		lblHighscore.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHighscore.setForeground(new Color(255, 255, 0));
		lblHighscore.setBounds(310, 50, 130, 30);
		contentPane.add(lblHighscore);

		btnStart = new JButton("Start");
		btnStart.setBackground(Color.white);
		btnStart.setBounds(30, 650, 110, 30);
		contentPane.add(btnStart);

		btnEnd = new JButton("End");
		btnEnd.setBackground(Color.white);
		btnEnd.setBounds(170, 650, 110, 30);
		contentPane.add(btnEnd);

		btnRecord = new JButton("Record");
		btnRecord.setBackground(Color.white);
		btnRecord.setBounds(310, 650, 110, 30);
		contentPane.add(btnRecord);

		panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(loadImage("/hammer.png").getImage(),
				new Point(0, 0), "custom cursor1"));
	}

	private void initEvents() {
		for (int i = 0; i < holes.length; i++) {
			holes[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					JLabel lbl = (JLabel) e.getSource();
					int id = Integer.parseInt(lbl.getName());
					pressedButton(id);
				}
			});
		}
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStart.setEnabled(false);
				btnRecord.setEnabled(false);
				clearBoard();
				genRandMole();
				timer.start();
			}
		});
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dr == null) {
					dr = new DuduRecord();
				} else {
					dr.dispose();
					dr = new DuduRecord();
				}
			}
		});
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (timeLeft == 0) {
					lblTimeLeft.setText("" + timeLeft);
					timer.stop();
					btnStart.setEnabled(true);
					btnRecord.setEnabled(true);
				}
				lblTimeLeft.setText("" + timeLeft);
				timeLeft--;
			}
		});
	}
	private void pressedButton(int id) {
		int val = board[id];
		if (val == 1) {
			score++;
		} else {
			score--;
		}
		lblScore.setText("Score: " + score);

		clearBoard();
		genRandMole();
	}

	public Dudu() {
		initGUI();
		clearBoard();
		initEvents();
	}

	public void customcursor() {
		Image cursorimage = tk.getImage("C://projectImage_png/hammer.png");
		Point point = new Point(0, 0);
		Cursor cursor = tk.createCustomCursor(cursorimage, point, "haha");
		panel.setCursor(cursor);
		for (int i = 0; i < holes.length; i++) {
			holes[i].addMouseListener(this);
		}
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		Image cursorimage1 = tk.getImage("C://projectImage_png/hammerhit.png");
		Point point = new Point(0, 0);
		Cursor cursor1 = tk.createCustomCursor(cursorimage1, point, "");
		panel.setCursor(cursor1);

	}

	public void mouseReleased(MouseEvent e) {
		Image cursorimage = tk.getImage("C://projectImage_png/hammer.png");
		Point point = new Point(0, 0);
		Cursor cursor1 = tk.createCustomCursor(cursorimage, point, "");
		panel.setCursor(cursor1);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dispose();
	}
}
