package idv.game.breakoutclone.frame.graphics.paint;

import java.awt.Color;
import java.awt.Graphics;

import idv.game.breakoutclone.breakoutclone.collider.BaseRectangle;
import idv.game.breakoutclone.system.physics.Point;

public class ColliderPainter extends Painter {

	@Override
	public void paint(Graphics g, Paintable paint) {
		BaseRectangle rect = (BaseRectangle) paint;
		Point p1 = new Point(rect.getRound_length(), rect.getRound_length());
		Point p2 = new Point(rect.getRound_length() + rect.getFixedWidth(),
				rect.getRound_length());
		Point p3 = new Point(rect.getRound_length() + rect.getFixedWidth(),
				rect.getRound_length() + rect.getFixedHeigth());
		Point p4 = new Point(rect.getRound_length(),
				rect.getRound_length() + rect.getFixedHeigth());

		//起始位置
		Graphics g2 = g.create(50, 50, 400, 400);

		//圓角
		int roundSize = (int) (rect.getRound_length() * 2);
		g2.setColor(Color.black);
		g2.drawArc((int) (p1.x - rect.getRound_length()),
				(int) (p1.y - rect.getRound_length()), roundSize, roundSize, 90,
				90);
		g2.drawArc((int) (p2.x - rect.getRound_length()),
				(int) (p2.y - rect.getRound_length()), roundSize, roundSize, 90,
				-90);
		g2.drawArc((int) (p3.x - rect.getRound_length()),
				(int) (p3.y - rect.getRound_length()), roundSize, roundSize,
				-90, 90);
		g2.drawArc(((int) (p4.x - rect.getRound_length())),
				(int) (p4.y - rect.getRound_length()), roundSize, roundSize,
				-90, -90);

		//矩形邊
		g2.drawLine((int) (p1.x), (int) (p1.y - rect.getRound_length()),
				(int) (p1.x + rect.getFixedWidth()),
				(int) (p1.y - rect.getRound_length()));
		g2.drawLine((int) (p2.x + rect.getRound_length()), (int) (p2.y),
				(int) (p2.x + rect.getRound_length()),
				(int) (p2.y + rect.getFixedHeigth()));
		g2.drawLine((int) (p3.x), (int) (p3.y + rect.getRound_length()),
				(int) (p3.x - rect.getFixedWidth()),
				(int) (p3.y + rect.getRound_length()));
		g2.drawLine((int) (p4.x - rect.getRound_length()), (int) (p4.y),
				(int) (p4.x - rect.getRound_length()),
				(int) (p4.y - rect.getFixedHeigth()));

		System.out.println("cp1 " + p3.y);
		System.out.println("cp2 " + rect.getRound_length());

	}

}
