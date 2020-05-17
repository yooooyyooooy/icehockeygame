package game.scene;

import game.input.*;


import game.skill.*;
import game.sharedObject.ResourceHolder;
import game.skill.Perk;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import game.exception.ballFailedMoveException;
import game.game.*;
import SceneController.SceneController;
import game.board.*;
import game.board.ScoreBoard;

public class GameScene extends StackPane {
	private final Image gameBackground = ResourceHolder.gameBackground;
	private NormalBall ball;
	private BombBall bombBall;
	private Sticks sticks;
	private Item item;
	private Canvas canvas;
	private int timeCount = 0;
	private int random;
	private Clock clock;
	private ScoreBoard scoreBoard;
	private boolean isStarted = false;
	private boolean failed = false;
	private boolean isNormal = true;
	private boolean isOnCooldown1 = false;
	private boolean isOnCooldown2 = false;
	private boolean player1Wins = false;
	private boolean player2Wins = false;
	private int activatedTime1 = 0;
	private int activatedTime2 = 0;

	public GameScene(String name1, String name2, Perk perk1, Perk perk2) {
		canvas = new Canvas(gameBackground.getWidth(), gameBackground.getHeight());
		canvas.setVisible(true);
		canvas.setFocusTraversable(true);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		this.setPrefWidth(gameBackground.getWidth());
		this.setPrefHeight(gameBackground.getHeight());

		this.setBackground(new Background(new BackgroundImage(this.gameBackground, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

		Player player1 = new Player(name1, perk1);
		Player player2 = new Player(name2, perk2);

		sticks = new Sticks(gc);
		ball = new NormalBall(gc);
		item = new Item(gc);
		clock = new Clock(gc);
		scoreBoard = new ScoreBoard(gc, player1, player2);

		addListener();

		AnimationTimer animation = new AnimationTimer() {

			private long lastUpdated;

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				try {
					
					clock.draw(gc);
					clock.updateCooldown(gc, player1.getSkill().getMaxCooldown(), 
							activatedTime1, player2.getSkill().getMaxCooldown(), activatedTime2);
					if (isStarted) {
						if ((item.collideWithBall(ball))) {

							item.clearItem(gc);
							bombBall = ball.transition(item);
							isNormal = false;

						}

						if (isNormal) {
							resetCooldown(player1, player2);

							if(ball.getXspeed() != 0 || ball.getYspeed() != 0) {
						        activateFreezingSkill(player1, player2, gc);
						        activateBlockingSkill(player1, player2, gc);
						       }

							if (ball.isWinning(gc)) {
								addScore(ball, gc, player1, player2);
							}

							if (sticks.hit(ball)) {

								if (ball.getXspeed() == 3 || ball.getXspeed() == -3 || ball.getYspeed() == 3
										|| ball.getYspeed() == -3) {
									ball.setXspeed(ball.getXspeed() * 2);
									ball.setYspeed(ball.getYspeed() * 2);
								}

								gc.clearRect(sticks.getX_pos1() - 30, sticks.getY_pos1() - 30, 70, 130);
								gc.clearRect(sticks.getX_pos2() - 30, sticks.getY_pos2() - 30, 70, 130);

							}

							ball.move(gc);

							if (random == 1) {
								item.draw(gc);
							}

							ball.bounce(gc);
							sticks.move(gc);

						} else {
							if (sticks.hit(bombBall)) {

								gc.clearRect(sticks.getX_pos1() - 30, sticks.getY_pos1() - 30, 70, 130);
								gc.clearRect(sticks.getX_pos2() - 30, sticks.getY_pos2() - 30, 70, 130);

							}

							player1.getSkill().deactivate(bombBall);
							player2.getSkill().deactivate(bombBall);

							bombBall.move(gc);
							bombBall.bounce(gc);

							if (bombBall.isWinning(gc)) {
								bombBall.setXspeed(0);
								bombBall.setYspeed(0);
								bombBall.playExplodingSound();
								gc.drawImage(ResourceHolder.bombEffect, bombBall.getX_coordinate() - 35,
										bombBall.getY_coordinate() - 35);

							} else if (bombBall.getBombTicks() <= -3) {
								addScore(bombBall, gc, player1, player2);
							} else {

								sticks.move(gc);
							}
						}

						ballFailedMoveException.isFailed();

					}

					else if (!failed) {
						
						if (timeCount == 3) {
							isStarted = true;
						}
					}

					else {
						updateCracking(gc);
					}

					scoreBoard.draw(gc, player1, player2);

				}

				catch (ballFailedMoveException e) {
					isStarted = false;
					timeCount = 0;
					failed = true;
					e.printMessage();

				}

				if (now - lastUpdated >= 1000000000) {
					timeCount++;
					if (!isNormal) {
						bombBall.updateBombTicks();
					}
					if (isStarted) {
						clock.timeUpdate();
					}
					if (isOnCooldown1) {
						activatedTime1++;
					}
					if (isOnCooldown2) {
						activatedTime2++;
					}

					lastUpdated = now;
				}

				if (isEnding(clock, player1, player2)) {
					this.stop();
				}
			}
		};

		animation.start();


		this.getChildren().add(canvas);
	}
	
	public void addListener() {

		canvas.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});

		canvas.setOnKeyReleased((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), false);
		});
	}

	public void reset(GraphicsContext gc, double toLoser) {
		isStarted = false;
		isNormal = true;
		timeCount = 0;
		failed = false;
		random = (int) (Math.random() * 4);

		ballFailedMoveException.ball_movements.clear();
		gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		item.clearItem(gc);

		sticks.setX_pos1(sticks.getX1_reset());
		sticks.setY_pos1(sticks.getY1_reset());
		sticks.setX_pos2(sticks.getX2_reset());
		sticks.setY_pos2(sticks.getY2_reset());

		ball.setX_coordinate(toLoser);
		ball.setY_coordinate(ball.getY_reset());

		ball.setXspeed(0);
		ball.setYspeed(0);

		ball.draw(gc);
		sticks.draw(gc);
		if (random == 1 && !isOnCooldown1 && !isOnCooldown2) {
			item.randomDraw(gc);
		}
		
		if(this.getChildren().contains(ResourceHolder.freezingEffect)) {
	  		this.getChildren().remove(ResourceHolder.freezingEffect);
		}

	}
	
	public void addScore(Entity ball, GraphicsContext gc, Player player1, Player player2) {

		if (ball.collidewithWall_Y(gc) && ball.getX_coordinate() < canvas.getWidth() / 2
				&& ball instanceof NormalBall) {
			ResourceHolder.scoringSound.play();
			player2.setScore(player2.getScore() + 1);
			System.out.println("Score: " + player1.getScore() + ", " + player2.getScore());
			System.out.println(player2.getName() + " scores");
			reset(gc, sticks.getX1_reset() + 40);
		} else if (ball.collidewithWall_Y(gc) && ball.getX_coordinate() > canvas.getWidth() / 2
				&& ball instanceof NormalBall) {
			ResourceHolder.scoringSound.play();
			player1.setScore(player1.getScore() + 1);
			System.out.println("Score: " + player1.getScore() + ", " + player2.getScore());
			System.out.println(player1.getName() + " scores");
			reset(gc, sticks.getX2_reset() - 70);
		}

		if (ball.getX_coordinate() < canvas.getWidth() / 2 && ball instanceof BombBall) {
			player2.setScore(player2.getScore() + 1);
			System.out.println("Score: " + player1.getScore() + ", " + player2.getScore());
			System.out.println(player2.getName() + " scores");
			reset(gc, sticks.getX1_reset() + 40);
		} else if (ball.getX_coordinate() > canvas.getWidth() / 2 && ball instanceof BombBall) {
			player1.setScore(player1.getScore() + 1);
			System.out.println("Score: " + player1.getScore() + ", " + player2.getScore());
			System.out.println(player1.getName() + " scores");
			reset(gc, sticks.getX2_reset() - 70);
		}

	}

	public boolean isEnding(Clock clock, Player player1, Player player2) {

		if (clock.getTime() == 0) {

			if (player1.getScore() > player2.getScore()) {
				player1Wins = true;
			} else if (player2.getScore() > player1.getScore()) {
				player2Wins = true;
			}

			if (player1Wins) {
				SceneController.setWinningScene(player1.getName() + " wins XD");
			}

			if (player2Wins) {
				SceneController.setWinningScene(player2.getName() + " wins XD");
			}

			if ((!player1Wins) && (!player2Wins)) {
				SceneController.setWinningScene("Tie");
			}

			return true;
		}
		return false;
	}

	public void resetCooldown(Player player1, Player player2) {

		if (activatedTime1 >= player1.getSkill().getMaxCooldown()) {
			activatedTime1 = 0;
			isOnCooldown1 = false;
		}
		if (activatedTime2 >= player2.getSkill().getMaxCooldown()) {
			activatedTime2 = 0;
			isOnCooldown2 = false;
		}
	}
	public void activateFreezingSkill(Player player1, Player player2, GraphicsContext gc) {
		  
		  if(player1.getSkill() instanceof FreezingSkill) {
		   
			  if(player1.getSkill().isReady1(activatedTime1)) {
			    activatedTime1 = 0;
			    isOnCooldown1 = true;
			    player1.getSkill().activate(ball, "player1", gc);
			    
			    if(!this.getChildren().contains(ResourceHolder.freezingEffect)) {
			    	this.getChildren().add(ResourceHolder.freezingEffect);
			    }
			   }
		   
			  if(activatedTime1 == IActivatable.duration) {
				  	player1.getSkill().deactivate(ball);
		   }
		   
		  }
		  
		  
		  if(player2.getSkill() instanceof FreezingSkill) {
			   if(player2.getSkill().isReady2(activatedTime2)) {
				    activatedTime2 = 0;
				    isOnCooldown2 = true;
				    System.out.println(ball.collidewithBricksRight(gc));
				    player2.getSkill().activate(ball, "player2", gc);
				    
				    if(!this.getChildren().contains(ResourceHolder.freezingEffect)) {
				    	this.getChildren().add(ResourceHolder.freezingEffect);
				    }
			   }
		   
			   if(activatedTime2 == IActivatable.duration) {
				   player2.getSkill().deactivate(ball);
			   }
		  }
		  
		  if(ball.getXspeed() == ball.getInstantSpeed() || ball.getXspeed() == -ball.getInstantSpeed() || 
		    ball.getYspeed() == ball.getInstantSpeed() || ball.getYspeed() == -ball.getInstantSpeed()) {
			  	if(this.getChildren().contains(ResourceHolder.freezingEffect)) {
			  		this.getChildren().remove(ResourceHolder.freezingEffect);
		   }   
		  }
		  
		 }
	

	public void activateBlockingSkill(Player player1, Player player2, GraphicsContext gc) {
		if (player1.getSkill() instanceof BlockingSkill) {
			if (player1.getSkill().isReady1(activatedTime1)) {
				isOnCooldown1 = true;
			}

			if (isOnCooldown1 && activatedTime1 >= 0 && activatedTime1 < 2) {
				player1.getSkill().activate(ball, "player1", gc);

			}

			if (activatedTime1 == IActivatable.duration) {
				player1.getSkill().deactivate("player1", gc);
			}
		}

		if (player2.getSkill() instanceof BlockingSkill) {
			if (player2.getSkill().isReady2(activatedTime2)) {
				isOnCooldown2 = true;
			}

			if (isOnCooldown2 && activatedTime2 >= 0 && activatedTime2 < 2) {
				player2.getSkill().activate(ball, "player2", gc);

			}

			if (activatedTime2 == IActivatable.duration) {
				player2.getSkill().deactivate("player2", gc);
			}
		}
	}

	public void updateCracking(GraphicsContext gc) {

		if (isNormal) {
			gc.drawImage(ResourceHolder.ballCracking, ball.getX_coordinate() - 15, ball.getY_coordinate() - 15);

			if (timeCount == 3) {
				reset(gc, canvas.getWidth() / 2 - 15);
			}
		} else {
			gc.drawImage(ResourceHolder.bombballCracking, bombBall.getX_coordinate() - 15,
					bombBall.getY_coordinate() - 15);

			if (timeCount == 3) {
				reset(gc, canvas.getWidth() / 2 - 15);
			}
		}

	}
}