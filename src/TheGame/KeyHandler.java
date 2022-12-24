package TheGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public boolean upPressed, downPressed, leftPressed, rightPressed, shiftPressed,spacePressed;

	public void keyTyped(KeyEvent e) {

		
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_D) {
			rightPressed = true;
			if (!leftPressed) {
				rightPressed = true;
			} else {
				rightPressed = false;
				leftPressed = true;
			}
			upPressed = false;
			downPressed = false;
			
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = true;
			if (!rightPressed) {
				leftPressed = true;
			} else {
				leftPressed = false;
				rightPressed = true;
			}
			upPressed = false;
			downPressed = false;
			
		}
		if(code == KeyEvent.VK_W) {
			upPressed = true;
			if (!downPressed) {
				upPressed = true;
			} else {
				upPressed = false;
				downPressed = true;
			}
			leftPressed = false;
			rightPressed = false;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = true;
			if (!upPressed) {
				downPressed = true;
			} else {
				downPressed = false;
				upPressed = true;
			}
			leftPressed = false;
			rightPressed = false;
		}
		
		
	}

	public void keyReleased(KeyEvent e) {

		
	}

}
