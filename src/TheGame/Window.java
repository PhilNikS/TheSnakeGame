package TheGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.util.Iterator;
import java.util.Random;

import javax.swing.*;

public class Window extends JPanel implements KeyListener, ActionListener {

	private int snakeX[] = new int[750];
	private int snakeY[] = new int[750];
	private boolean left, right, up, down;

	private ImageIcon titleImage;
	private ImageIcon rightS;
	private ImageIcon leftS;
	private ImageIcon upS;
	private ImageIcon downS;
	private ImageIcon snakeBody;
	private ImageIcon food;
	private ImageIcon foodScore;
	private ImageIcon lenghtScore;
	private ImageIcon earth;
	private ImageIcon tonelX;
	private ImageIcon tonelY;

	private Timer timer;
	private int time = 100;
	private int moves = 0;
	private int score = 0;

	private int size = 3;

	private int foodXpos = Foods.getRandomX();
	private int foodYpos = Foods.getRandomY();

	public Window() {
		
		getImages();

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(time, this);
		timer.start();

	}


	private void getImages() {
		try {
			titleImage = new ImageIcon(getClass().getResource("/Images/TitleSnake.jpg"));
			snakeBody = new ImageIcon(getClass().getResource("/Images/SnakeBody2.png"));
			rightS = new ImageIcon(getClass().getResource("/Images/SnakeR.png"));
			upS = new ImageIcon(getClass().getResource("/Images/SnakeU.png"));
			leftS = new ImageIcon(getClass().getResource("/Images/SnakeL.png"));
			downS = new ImageIcon(getClass().getResource("/Images/SnakeD.png"));
			snakeBody = new ImageIcon(getClass().getResource("/Images/SnakeBody2.png"));
			food = new ImageIcon(getClass().getResource("/Images/SnakeBody.png"));
			earth = new ImageIcon(getClass().getResource("/Images/Earth.png"));
			foodScore = new ImageIcon(getClass().getResource("/Images/SnakeBody.png"));
			lenghtScore = new ImageIcon(getClass().getResource("/Images/SnakeBody2.png"));
			tonelX = new ImageIcon(getClass().getResource("/Images/TonelX.png"));
			tonelY = new ImageIcon(getClass().getResource("/Images/TonelY.png"));
		} catch (Exception e) {
			e.getCause();
		}
	}
	private int cheakFoodPosX() {
		if (foodXpos> 735&&foodYpos > 490)
			foodXpos = Foods.getRandomX();
		else {
			return foodXpos;
		}
		return foodXpos;
		
	}
	private int cheakFoodPosY() {
		if (foodXpos> 735&&foodYpos > 490)
			foodYpos = Foods.getRandomY();
		else {
			return foodYpos;
		}
		return foodYpos;
	}


	public void paint(Graphics g) {
		if (moves == 0) {
			snakeX[2] = 40;
			snakeX[1] = 65;
			snakeX[0] = 90;

			snakeY[2] = 100;
			snakeY[1] = 100;
			snakeY[0] = 100;

		}



		// draw the title image
		g.setColor(Color.WHITE);
		g.drawRect(14, 10, 826, 56);
		titleImage.paintIcon(this, g, 15, 11);


		// draw border gameplay
		g.setColor(Color.white);
		g.drawRect(14, 74, 826, 551);
		earth.paintIcon(this, g, 15, 75);
		
		//draw score window
		g.setColor(Color.WHITE);
		g.drawRect(740, 500, 100, 125);
		g.setColor(Color.BLACK);
		g.fillRect(741, 501, 99, 124);

		// draw the score
		g.setColor(Color.WHITE);
		foodScore.paintIcon(this, g, 770, 575);
		g.drawString(" - " + score, 800, 591);
		
		// draw the snakes lenght
		g.setColor(Color.WHITE);
		lenghtScore.paintIcon(this, g, 770, 525);
		g.drawString(" - " + size, 800, 541);
		
		// draw tonels
		tonelX.paintIcon(this, g, 140, 165);
		tonelY.paintIcon(this, g, 530, 475);
		
		

		if (moves == 0) {
			
			rightS.paintIcon(this, g, snakeX[0], snakeY[0]);
			
			snakeBody.paintIcon(this, g, snakeX[1], snakeY[1]);
			snakeBody.paintIcon(this, g, snakeX[2], snakeY[2]);
		}
		if (moves != 0) {
			for (int i = 0; i < size; i++) {
				if (i == 0 && right) {
					
					rightS.paintIcon(this, g, snakeX[i], snakeY[i]);
				}
				if (i == 0 && left) {
					
					leftS.paintIcon(this, g, snakeX[i], snakeY[i]);
				}
				if (i == 0 && down) {
					
					downS.paintIcon(this, g, snakeX[i], snakeY[i]);
				}
				if (i == 0 && up) {
					upS.paintIcon(this, g, snakeX[i], snakeY[i]);
				}
				if (i != 0) {
					snakeBody.paintIcon(this, g, snakeX[i], snakeY[i]);
					if(snakeX[i] == foodXpos&& snakeY[i] == foodYpos) {
						foodXpos = Foods.getRandomX();
						foodYpos = Foods.getRandomY();
					}
				}
				
			}
		}

		

		if ((foodXpos == snakeX[0]) && foodYpos == snakeY[0]) {
			size++;
			score++;

			foodXpos = Foods.getRandomX();
			foodYpos = Foods.getRandomY();

		}
		food.paintIcon(this, g, cheakFoodPosX(), cheakFoodPosY());

		for (int x = 1; x < size; x++) {
			if (snakeX[x] == snakeX[0] && snakeY[x] == snakeY[0]) {
				right = left = down = up = false;

				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("Game Over", 300, 300);

				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("Press Space to RESTART", 310, 340);

			}
		}

		g.dispose();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if (right && !left) {
			for (int r = size - 1; r >= 0; r--) {

				snakeY[r + 1] = snakeY[r];
			}
			for (int r = size; r >= 0; r--) {
				if (r == 0) {
					snakeX[r] = snakeX[r] + 25;
				} else {
					snakeX[r] = snakeX[r - 1];
				}
				if (snakeX[r] > 815&& snakeY[r]<501) {
					snakeX[r] = 15;
				}
				if (snakeX[r] > 735&& snakeY[r]>490) {
					snakeX[r] = 15;
				}
				if (snakeX[r] == 565 && snakeY[r] == 500) {
					right = false;
					left = false;
					up = false;
					down = true;
					snakeX[r] = 165;
					snakeY[r] = 200;
				}
			}
			repaint();
		}
		if (left && !right) {
			for (int r = size - 1; r >= 0; r--) {

				snakeY[r + 1] = snakeY[r];
			}
			for (int r = size; r >= 0; r--) {
				if (r == 0) {
					snakeX[r] = snakeX[r] - 25;
				} else {
					snakeX[r] = snakeX[r - 1];
				}
				if (snakeX[r] < 15&&snakeY[r]<490) {
					snakeX[r] = 815;	
				}
				if(snakeX[r] <15 && snakeY[r] >495) {
					snakeX[r] = 715;
				}
			
			}
			repaint();

		}
		if (up && !down) {
			for (int r = size - 1; r >= 0; r--) {

				snakeX[r + 1] = snakeX[r];
			}
			for (int r = size; r >= 0; r--) {
				if (r == 0) {
					snakeY[r] = snakeY[r] - 25;
				} else {
					snakeY[r] = snakeY[r - 1];
				}
				if (snakeY[r] < 75 && snakeX[r]< 720) {
					snakeY[r] = 600;
				}
				if (snakeY[r] < 75 && snakeX[r]> 715) {
					snakeY[r] = 475;
				}
				if (snakeX[r] == 165 && snakeY[r] == 175) {
					right = false;
					left = true;
					up = false;
					down = false;
					snakeX[r] = 540;
					snakeY[r] = 500;
				}
			}
			repaint();

		}
		if (down && !up) {
			for (int r = size - 1; r >= 0; r--) {

				snakeX[r + 1] = snakeX[r];
			}
			for (int r = size; r >= 0; r--) {
				if (r == 0) {
					snakeY[r] = snakeY[r] + 25;
				} else {
					snakeY[r] = snakeY[r - 1];
				}
				if (snakeY[r] > 600&&snakeX[r]< 720) {
					snakeY[r] = 75;
				}
				if (snakeY[r] > 499&&snakeX[r]> 715) {
					snakeY[r] = 75;
				}
			}
			repaint();

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			moves = 0;
			score = 0;
			size = 3;
			repaint();

		}

		if (e.getKeyCode() == KeyEvent.VK_D||e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moves++;
			right = true;
			if (!left) {
				right = true;
			} else {
				right = false;
				left = true;
			}
			up = false;
			down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A && moves != 0||e.getKeyCode() == KeyEvent.VK_LEFT&& moves != 0) {
			moves++;
			left = true;
			if (!right) {
				left = true;
			} else {
				left = false;
				right = true;
			}
			up = false;
			down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_W||e.getKeyCode() == KeyEvent.VK_UP&& moves != 0) {
			moves++;

			up = true;
			if (!down) {
				up = true;
			} else {
				up = false;
				down = true;
			}
			left = false;
			right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S||e.getKeyCode() == KeyEvent.VK_DOWN&& moves != 0) {
			moves++;
			down = true;
			if (!up) {
				down = true;
			} else {
				down = false;
				up = true;
			}
			left = false;
			right = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
