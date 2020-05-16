package game.skill;

import javafx.scene.canvas.GraphicsContext;
import game.game.*;

public interface IActivatable {
	
	public static final int duration = 2;
	
	public void activate(NormalBall ball, String player, GraphicsContext gc);
	public void deactivate(Entity ball);
	public void deactivate(String player, GraphicsContext gc);
	public boolean isReady1(int activatedTime1);
	public boolean isReady2(int activatedTime2);
	public int getMaxCooldown();
}
