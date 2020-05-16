package game.skill;

import game.input.InputUtility;
import game.sharedObject.ResourceHolder;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import game.game.*;

public class BlockingSkill implements IActivatable {
	
	public final int cooldown = 20;
	@Override
	public void activate(NormalBall ball, String player, GraphicsContext gc) {
		// TODO Auto-generated method stub
		if(player == "player1") {
			gc.drawImage(ResourceHolder.iceWall, 0, 0);
			
			if(ball.collidewithBricksLeft(gc)) {
				ResourceHolder.bounceSound.play();
				ball.setXspeed(-(ball.getXspeed()));
			}
			
		}
		if(player == "player2") {
			gc.drawImage(ResourceHolder.iceWall, gc.getCanvas().getWidth()-50, 0);
			
			if(ball.collidewithBricksRight(gc)) {
				ResourceHolder.bounceSound.play();
				ball.setXspeed(-(ball.getXspeed()));
			}
			
		}
	}

	@Override
	public void deactivate(Entity ball) {
		// TODO Auto-generated method stub
		//do nothing here
	}
	
	@Override
	public void deactivate(String player, GraphicsContext gc) {
		// TODO Auto-generated method stub
		if(player == "player1") {
			gc.clearRect(0, 0, 50, gc.getCanvas().getHeight());
		}
		else if(player == "player2") {
			gc.clearRect(gc.getCanvas().getWidth()-50, 0, 50, gc.getCanvas().getHeight());
		}
	}

	@Override
	public boolean isReady1(int activatedTime1) {
		// TODO Auto-generated method stub
		return activatedTime1 == 0 && (InputUtility.getKeyPressed(KeyCode.R));
	}

	@Override
	public boolean isReady2(int activatedTime2) {
		// TODO Auto-generated method stub
		return activatedTime2 == 0 && (InputUtility.getKeyPressed(KeyCode.SPACE));
	}

	@Override
	public int getMaxCooldown() {
		// TODO Auto-generated method stub
		return cooldown;
	}

}