

public class GameLogic {
	
	
	public GameLogic() {
		
	}
	
	
	public static boolean isFilled() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(MainGame.game[i][j] == -1) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public static int isSomeoneDone() {
		
		// 3 row
		
		if((MainGame.game[0][0] == 0 && MainGame.game[0][1] == 0 && MainGame.game[0][2] == 0) || (MainGame.game[0][0] == 1 && MainGame.game[0][1] == 1 && MainGame.game[0][2] == 1)) {
			return MainGame.game[0][0];
		}
		
		else if((MainGame.game[1][0] == 0 && MainGame.game[1][1] == 0 && MainGame.game[1][2] == 0) || (MainGame.game[1][0] == 1 && MainGame.game[1][1] == 1 && MainGame.game[1][2] == 1)) {
			return MainGame.game[1][0];
		}
		
		else if((MainGame.game[2][0] == 0 && MainGame.game[2][1] == 0 && MainGame.game[2][2] == 0) || (MainGame.game[2][0] == 1 && MainGame.game[2][1] == 1 && MainGame.game[2][2] == 1)) {
			return MainGame.game[2][0];
		}
		
		// 3 column
		
		else if((MainGame.game[0][0] == 0 && MainGame.game[1][0] == 0 && MainGame.game[2][0] == 0) || (MainGame.game[0][0] == 1 && MainGame.game[1][0] == 1 && MainGame.game[2][0] == 1)) {
			return MainGame.game[0][0];
		}
		
		else if((MainGame.game[0][1] == 0 && MainGame.game[1][1] == 0 && MainGame.game[2][1] == 0) || (MainGame.game[0][1] == 1 && MainGame.game[1][1] == 1 && MainGame.game[2][1] == 1)) {
			return MainGame.game[0][1];
		}
		
		else if((MainGame.game[0][2] == 0 && MainGame.game[1][2] == 0 && MainGame.game[2][2] == 0) || (MainGame.game[0][2] == 1 && MainGame.game[1][2] == 1 && MainGame.game[2][2] == 1)) {
			return MainGame.game[0][2];
		}
		
		else if((MainGame.game[0][2] == 0 && MainGame.game[1][1] == 0 && MainGame.game[2][0] == 0) || (MainGame.game[0][2] == 1 && MainGame.game[1][1] == 1 && MainGame.game[2][0] == 1)) {
			return MainGame.game[0][2];
		}
		
		else if((MainGame.game[0][0] == 0 && MainGame.game[1][1] == 0 && MainGame.game[2][2] == 0) || (MainGame.game[0][0] == 1 && MainGame.game[1][1] == 1 && MainGame.game[2][2] == 1)) {
			return MainGame.game[0][0];
		}
		
		return -1;
		
		
	}
	
	
}
