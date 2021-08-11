package teamProject;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DuduRecord extends JFrame implements ActionListener{
	private JTextField user;
	private JLabel userName;
	private JLabel jscore;
	private JButton re;
	
	DuduRecord(){
		Dimension rscreen = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(300, 500);
		int rxpos = (int) (rscreen.getWidth() / 2 - getWidth() / 2);
		int rypos = (int) (rscreen.getHeight() / 2 - getHeight() / 2);
		setLocation(rxpos, rypos);
		setTitle("record");
		this.setLayout(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		user = new JTextField();
		user.setBounds(100, 150, 110, 30);
		userName = new JLabel("UserName : ");
		userName.setBounds(30, 150, 110, 30);
		
		jscore = new JLabel("점수들어갈자리");
		jscore.setBounds(100, 300, 110, 30);
		
		re = new JButton("기록");
		re.setBounds(100, 400, 110, 30);
		
		add(user);
		add(userName);
		add(jscore);
		add(re);
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        dispose();
        
        if(e.getSource() == re) {
        	//db에 기록할 코드
        }
    }
}