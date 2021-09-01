
public class IngameTempData {
	public static int p1Score = 0;
	public static int p2Score = 0;
	
	public static String p1Name = "P1   ";
	public static String p2Name = "P2   ";
	
	public static String winner = "DRAW";
	
	public static boolean isDraw;
	public static boolean newRound = false;
	public static String s1 = "[O]";
	public static String s2 = "[X]";
	
	
	public static void resetFields() {
//		p1Name = null;
//		p2Name = null;
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
		p1Name = new String(p2Name.getBytes(),0,p2Name.length()-3) + s1;
		p2Name = new String(tmp.getBytes(),0,tmp.length()-3) + s2;
		
//		tmp  = s1;
//		s1 = s2;
//		s2 = tmp;
		
		int point = p1Score;
		p1Score = p2Score;
		p2Score = point;
	}
	
}
