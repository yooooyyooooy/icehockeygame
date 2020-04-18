package game.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Item extends Object {
	protected String name;
	protected String url;
	
	public Item(double x, double y, String name) {
		// TODO Auto-generated constructor stub
		super(x,y);
			
		switch(name) {
			case "Bomb":
				this.setName("Bomb");
				this.setUrl("bomb.png");
				this.setImage(iv);
				
			case "Ghost":
				this.setName("Ghost");
				this.setUrl("ghost.png");
				this.setImage(iv);
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void bounce() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setImage(ImageView iv) {
		// TODO Auto-generated method stub
		iv = new ImageView(new Image(this.getUrl()));
	}

	
}
