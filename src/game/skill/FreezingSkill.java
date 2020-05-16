package game.skill;


import game.game.*;
import game.input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

public class FreezingSkill implements IActivatable{
	
	private final int cooldown = 15;
	
	@Override
	public void deactivate(Entity ball) {
		// TODO Auto-generated method stub
		if((ball.getXspeed() == ball.getInstantSpeed()/2 || ball.getXspeed() == -ball.getInstantSpeed()/2 || 
				ball.getYspeed() == ball.getInstantSpeed()/2 || ball.getYspeed() == -ball.getInstantSpeed()/2)) {
					ball.setXspeed(ball.getXspeed()*2);
					ball.setYspeed(ball.getYspeed()*2);
		}
	}

	@Override
	public void activate(NormalBall ball, String player, GraphicsContext gc) {
		// TODO Auto-generated method stub
		if(ball.getXspeed() == ball.getInstantSpeed() || ball.getXspeed() == -ball.getInstantSpeed() || 
				ball.getYspeed() == ball.getInstantSpeed() || ball.getYspeed() == -ball.getInstantSpeed()) {
			ball.setXspeed(ball.getXspeed()/2);
			ball.setYspeed(ball.getYspeed()/2);
			
		}
	}
	
	@Override
	public void deactivate(String player, GraphicsContext gc) {
		// TODO Auto-generated method stub
		//do nothing here
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
	
	public int getMaxCooldown() {
		return cooldown;
	}

}
