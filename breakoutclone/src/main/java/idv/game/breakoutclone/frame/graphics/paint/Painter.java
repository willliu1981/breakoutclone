package idv.game.breakoutclone.frame.graphics.paint;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Painter {
	Color color;

	public abstract void paint(Graphics g, Paintable paint);

	public void setColor(Color color) {
		this.color = color;
	}
}
