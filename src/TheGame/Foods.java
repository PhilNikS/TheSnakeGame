package TheGame;

import java.util.Random;

public class Foods {
	
	private static int foodX[] = { 40, 65, 90, 115, 140, 165, 190, 215, 240, 265, 290, 315, 340, 365, 390, 415, 440, 465,
			490, 515, 540, 565, 590, 615, 640, 665, 690, 715, 740, 765, 790, 815 };
	private static int foodY[] = { 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500,
			525, 550, 575, 600 };
	
	private static int resX;
	private static int resY;
	
	public static int getRandomX() {
		resX = new Random().nextInt(32);
		
		return foodX[resX];
	}
	public static int getRandomY() {
	
			resY = new Random().nextInt(22);
			return foodY[resY];
		
	}
}
