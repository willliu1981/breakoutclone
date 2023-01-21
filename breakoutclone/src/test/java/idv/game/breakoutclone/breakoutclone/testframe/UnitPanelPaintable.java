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
		//BaseRectangle rect = (BaseRectangle) Collider.prepareCteate("Rectangle").setLocation(111, 33).createNewOne();
		RoundedRectangleColliderFactory factory = new RoundedRectangleColliderFactory();
		BaseRectangle collider = factory.prepareCreate(RoundedRectangleColliderFactory.RECTANGLE).setLocation(200, 160)
				.createNewOne();
		// BaseRectangle rect = new RoundedRectangle(111,35,18);
		// BaseRectangle rect = new Circle(111);

		painter.paint(g, collider);
	}

}
