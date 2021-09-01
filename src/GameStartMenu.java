import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameStartMenu extends JFrame {
	
	String path = "src/img/";
	
	public GameStartMenu() {
		setIconImage(new ImageIcon(path + "game.png").getImage());
		setSize(500, 600);
		setTitle("Tic Tac Toe | Main Menu");
		setLocationRelativeTo(null);
		setVisible(true);
		//setBackground(Color.white);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		
		
		
		
		JPanel logoPanel = new JPanel();
		add(logoPanel);
		logoPanel.setLayout(null);
		JLabel imgJLabel = new JLabel(new ImageIcon(path + "gamelogo.png"));
		logoPanel.add(imgJLabel);
		
		imgJLabel.setBounds(0, 0, 500, 80);
		logoPanel.setBounds(0, 0, 500, 80);
		
		JPanel mainPanel = new JPanel();
		add(mainPanel);
		mainPanel.setBounds(0, 80, 500, 520);
		mainPanel.setLayout(null);
		//mainPanel.setBackground(Color.red);
		JTextField p1, p2;
		JLabel p1l, p2l, mainmenu;
		JButton startButton;
		
		
		
		mainmenu = new JLabel("Main Menu");
		mainmenu.setFont(new Font("Ariel", Font.BOLD, 45));
		mainmenu.setBounds(130, 50, 300, 40);
		mainmenu.setForeground(new Color(85, 161, 207));
		mainPanel.add(mainmenu);
		
		p1l = new JLabel("Player 1 Name (O)");
		p1l.setFont(new Font("Ariel", Font.PLAIN, 18));
		p1l.setForeground(new Color(88, 172, 56));
		p2l = new JLabel("Player 2 Name (X)");
		p2l.setFont(new Font("Ariel", Font.PLAIN, 18));
		p2l.setForeground(Color.red);
		mainPanel.add(p1l);
		mainPanel.add(p2l);
		p1l.setBounds(170, 150, 150, 40);
		p2l.setBounds(170, 250, 150, 40);
		
		p1 = new JTextField();
		p1.setFont(new Font("Ariel", Font.PLAIN, 18));
		p1.setForeground(new Color(88, 172, 56));
		p1.setText(new String(IngameTempData.p1Name.getBytes(), 0, IngameTempData.p1Name.length()-3));
		p2 = new JTextField();
		p2.setFont(new Font("Ariel", Font.PLAIN, 18));
		p2.setForeground(Color.red);
		p2.setText(new String(IngameTempData.p2Name.getBytes(), 0, IngameTempData.p2Name.length()-3));
		mainPanel.add(p1);
		mainPanel.add(p2);
		p1.setBounds(170, 190, 150, 40);
		p2.setBounds(170, 290, 150, 40);
		
		
		
		startButton = new JButton(new ImageIcon(path + "play.png"));
		mainPanel.add(startButton);
		startButton.setBounds(223, 340, 50, 85);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusable(false);
		
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(p1.getText().isEmpty() || p2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(rootPane, "Player name cannot be empty", "Name Field Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(p1.getText().equals(p2.getText())) {
					JOptionPane.showMessageDialog(rootPane, "Player name cannot be same", "Name Field Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				dispose();
				IngameTempData.p1Name = p1.getText() + " [O]";
				IngameTempData.p2Name = p2.getText() + " [X]";;
				new MainGame();
				
			}
		});
		
	}
}
