
public class IngameTempData {
	public static int p1Score;
	public static int p2Score;
	
	public static String p1Name;
	public static String p2Name;
	
	public static String winner = "DRAW";
	
	public static boolean isDraw;
	public static boolean newRound = false;
	
	
	public static void resetFields() {
		p1Name = null;
		p2Name = null;
		p1Score = 0;
		p2Score = 0;
		winner =  "DRAW";
		isDraw = false;
	}
	
	public static void resetRound() {
		winner =  "DRAW";
		isDraw = false;
		swapSide();
		
	}
	
	private static void swapSide() {
		String tmp = p1Name;
		p1Name = p2Name;
		p2Name = tmp;
		
		int point = p1Score;
		p1Score = p2Score;
		p2Score = point;
	}
	
}
