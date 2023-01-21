package idv.game.breakoutclone.breakoutclone.testframe;

import java.awt.Graphics;

import idv.game.breakoutclone.collider.BaseRectangle;
import idv.game.breakoutclone.collider.Collider;
import idv.game.breakoutclone.collider.Rectangle;
import idv.game.breakoutclone.collider.RoundedRectangleColliderFactory;
import idv.game.breakoutclone.frame.graphics.paint.ColliderPainter;
import idv.game.breakoutclone.frame.graphics.paint.Painter;

public class UnitPanelPaintable implements FramePaintable {

	@Override
	public void paint(Graphics g) {
		Painter painter = new ColliderPainter();
		RoundedRectangleColliderFactory factory = new RoundedRectangleColliderFactory();
		BaseRectangle collider = factory.prepareCreate(RoundedRectangleColliderFactory.RECTANGLE).setLocation(200, 160)
				.setSize(200, 120).createNewOne();

		painter.paint(g, collider);
	}

}
