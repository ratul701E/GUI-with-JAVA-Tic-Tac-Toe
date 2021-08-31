import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverMenu extends JFrame implements ActionListener{
	
	JButton rematchButton, mainMenuButton, exitButton;
	String path = "img/";
	
	public GameOverMenu() {
		setSize(350, 250);
		setTitle("Game Over");
		setLocationRelativeTo(null);
		setVisible(true);
		//setBackground(Color.white);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		
		JPanel winnerNamePanel = new JPanel();
		add(winnerNamePanel);
		winnerNamePanel.setBounds(0, 0, 350, 80);
		//winnerNamePanel.setBackground(Color.red);
		winnerNamePanel.setLayout(null);
		
		JPanel actionHudPanel = new JPanel();
		add(actionHudPanel);
		actionHudPanel.setBounds(0, 90, 330, 100);
		//actionHudPanel.setBackground(Color.black);
		actionHudPanel.setLayout(new GridBagLayout());
		
		JLabel winner = new JLabel(IngameTempData.winner);
		winnerNamePanel.add(winner);
		winner.setBounds(170, 3, 120, 80);
		winner.setFont(new Font("Ariel", Font.PLAIN, 20));
		winner.setForeground(new Color(126, 191, 124));
		
		JLabel winnerText = new JLabel("Winner : ");
		winnerNamePanel.add(winnerText);
		winnerText.setBounds(40, 0, 125, 80);
		winnerText.setFont(new Font("Ariel", Font.PLAIN, 30));
		winnerText.setForeground(new Color(250, 58, 58));
		
		
		
		rematchButton = new JButton("Rematch", new ImageIcon(path + "rematch.png"));
		rematchButton.setBorderPainted(false);
		rematchButton.setContentAreaFilled(false);
		rematchButton.setFocusable(false);
		rematchButton.setFont(new Font("Lato", Font.BOLD, 12));
		rematchButton.addActionListener(this);
		
		mainMenuButton = new JButton("Main Menu", new ImageIcon(path + "mainMenu.png"));
		mainMenuButton.setBorderPainted(false);
		mainMenuButton.setContentAreaFilled(false);
		mainMenuButton.setFocusable(false);
		mainMenuButton.setFont(new Font("Lato", Font.BOLD, 12));
		mainMenuButton.addActionListener(this);
		
		exitButton = new JButton("Exit", new ImageIcon(path + "exit.png"));
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusable(false);
		exitButton.setFont(new Font("Ariel", Font.BOLD, 12));
		exitButton.addActionListener(this);
		
		
		actionHudPanel.add(rematchButton);
		actionHudPanel.add(mainMenuButton);
		actionHudPanel.add(exitButton);
		
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == rematchButton ) {
			MainGame.resetBoard();
			IngameTempData.resetRound();
			IngameTempData.newRound = true;
			dispose();
			new MainGame();
			
		}
		
		else if(source == mainMenuButton) {
			MainGame.resetBoard();
			IngameTempData.resetFields();
			IngameTempData.newRound = false;
			dispose();
			new GameStartMenu();
		}
		
		else if(source == exitButton) {
			dispose();
		}
		
	}
}
