
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGame extends JFrame implements ActionListener{
	
	String path = "img/";
	
	JButton cellsButton[] = new JButton[9];
	int currentHand = 0;
	static int game[][] = {
			{-1, -1, -1},
			{-1, -1, -1},
			{-1, -1, -1}
	};
	JPanel board;
	JLabel currentTurn;
	 static boolean disposible = false;
	
	public MainGame() {
		disposible = false;
		
		setSize(500, 650);
		setTitle("Tic Tac Toe");
		setLocationRelativeTo(null);
		setVisible(true);
		//setBackground(Color.white);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		board = new JPanel();
		add(board);
		//board.setBackground(Color.red);
		board.setBounds(18,140, 450, 500);
		board.setLayout(null);
	
		
		
		JPanel hud = new JPanel();
		add(hud);
		hud.setBounds(0,0, 500, 140);
		
		JLabel player1 = new JLabel(IngameTempData.p1Name);
		JLabel player2 = new JLabel(IngameTempData.p2Name);
		currentTurn = new JLabel("Current Turn: " + IngameTempData.p1Name);
		
		hud.add(player1);
		hud.add(player2);
		hud.add(currentTurn);
		hud.setLayout(null);
		
		player1.setBounds(20, 70, 100, 40);
		player1.setFont(new Font("Ariel", Font.PLAIN, 25));
		player1.setForeground(new Color(88, 172, 56));
		
		player2.setBounds(360, 70, 100, 40);
		player2.setFont(new Font("Ariel", Font.PLAIN, 25));
		player2.setForeground(Color.red);
		
		currentTurn.setBounds(150, 5, 300, 50);
		currentTurn.setFont(new Font("Ariel", Font.PLAIN, 20));
		currentTurn.setForeground(new Color(55, 152, 169));
		//hud.setBackground(Color.red);
		
		
		JLabel gameLay = new JLabel(new ImageIcon(path + "board.png"));
		board.add(gameLay);
		gameLay.setBounds(0, 0, 450, 450);
		
		
		for(int i = 0; i < 9; i++) {
			JButton tempButton = new JButton();
			//tempButton.setBackground(Color.white);
			tempButton.setBorderPainted(false);
			tempButton.setFocusable(false);
			tempButton.setContentAreaFilled(false);
			tempButton.addActionListener(this);
			cellsButton[i] = tempButton;
			board.add(cellsButton[i]);
		}
		
		cellsButton[0].setBounds(15, 10, 128, 135);
		cellsButton[1].setBounds(163, 10, 128, 135);
		cellsButton[2].setBounds(305, 10, 128, 135);
		cellsButton[3].setBounds(15, 155, 128, 135);
		cellsButton[4].setBounds(163, 155, 128, 135);
		cellsButton[5].setBounds(305, 155, 128, 135);
		cellsButton[6].setBounds(15, 295, 128, 135);
		cellsButton[7].setBounds(163, 295, 128, 135);
		cellsButton[8].setBounds(305, 295, 128, 135);
		
		
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		 Object source = e.getSource();
		if(source == cellsButton[0]) {
			if(game[0][0] == -1) {
				fill(0, 0, 0);
			}
		}
		
		else if(source == cellsButton[1]) {
			if(game[0][1] == -1) {
				fill(0, 1, 1);
			}
		}
		
		else if(source == cellsButton[2]) {
			if(game[0][2] == -1) {
				fill(0, 2, 2);
			}	
		}
				
		else if(source == cellsButton[3]) {
			if(game[1][0] == -1) {
				fill(1, 0, 3);
			}
		}
				
		else if(source == cellsButton[4]) {
			if(game[1][1] == -1) {
				fill(1, 1, 4);
			}
		}
				
		else if(source == cellsButton[5]) {
			if(game[1][2] == -1) {
				fill(1, 2, 5);
			}
		}
				
		else if(source == cellsButton[6]) {
			if(game[2][0] == -1) {
				fill(2, 0, 6);
			}
		}
				
		else if(source == cellsButton[7]) {
			if(game[2][1] == -1) {
				fill(2, 1, 7);
			}
		}
				
		else if(source == cellsButton[8]) {
			if(game[2][2] == -1) {
				fill(2, 2, 8);
			}
		}
		
	}
	
	void changeHand() {
		if(currentHand == 1) {
			currentHand = 0;
			currentTurn.setText("Current Turn: " + IngameTempData.p1Name);
		}
		else {
			currentHand = 1;
			currentTurn.setText("Current Turn: " + IngameTempData.p2Name);
		}
	}
	
	void fill(int i, int j, int btn) {
		game[i][j] = currentHand;
		if(currentHand == 0) {
			cellsButton[btn].setIcon(new ImageIcon(path + "0.png"));
			
			
		}else {
			cellsButton[btn].setIcon(new ImageIcon(path + "x.png"));
		}
		
		cellsButton[btn].setEnabled(false);
		
		int w;
		
		if( (w = GameLogic.isSomeoneDone()) != -1) {
			if(w == 1) {
				IngameTempData.winner = IngameTempData.p2Name;
				IngameTempData.p2Score++;
			}else {
				IngameTempData.winner = IngameTempData.p1Name;
				IngameTempData.p1Score++;
			}
			new GameOverMenu();
			MainGame.disposible = true;
		}
		
		else if(GameLogic.isFilled()) {
			IngameTempData.isDraw = true;
			new GameOverMenu();
			MainGame.disposible = true;
		}
		
		
		if(disposible) dispose();
		changeHand();
		
		
		//  matrix index checks
		/*
		
		
		for(int ii = 0; ii < 3; ii++) {
			for(int jj = 0; jj < 3; jj++) {
				
				System.out.print(game[ii][jj] + " ");
			}
			System.out.println();
		}
		 */
		
		//
		
	}
	
	public static void resetBoard() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				game[i][j] = -1; 
			}
		}
	}

	
}
