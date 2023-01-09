package idv.game.breakoutclone.system.physics;

import org.junit.jupiter.api.Test;

import idv.game.breakoutclone.collider.Collider;

public class Locations {
	public static Point translateToWorldLocation(Collider parent, Point p) {
		Point location = parent.getOwner().getLocation();

		return new Point(location.x + parent.getX() + p.x, location.y + parent.getY() + p.y);
	}

	public static double getAngle(Point pSrc, Point p1, Point p2) {
		double angle = 0.0f; // 夹角

		// 向量Vector a的(x, y)坐标
		double va_x = p1.x - pSrc.x;
		double va_y = p1.y - pSrc.y;

		// 向量b的(x, y)坐标
		double vb_x = p2.x - pSrc.x;
		double vb_y = p2.y - pSrc.y;

		double productValue = (va_x * vb_x) + (va_y * vb_y); // 向量的乘积
		double va_val = Math.pow(va_x * va_x + va_y * va_y, 0.5); // 向量a的模
		double vb_val = Math.pow(vb_x * vb_x + vb_y * vb_y, 0.5); // 向量b的模
		double cosValue = productValue / (va_val * vb_val); // 余弦公式

		// acos的输入参数范围必须在[-1, 1]之间，否则会"domain error"
		// 对输入参数作校验和处理
		if (cosValue < -1 && cosValue > -2) {
			cosValue = -1;
		} else if (cosValue > 1 && cosValue < 2) {
			cosValue = 1;
		}

		// acos返回的是弧度值，转换为角度值
		angle = Math.acos(cosValue) * 180 / Math.PI;

		return angle;
	}

	@Test
	public void test() {
		Point p0 = new Point(100, 100);
		Point pa = new Point(150, 50);
		Point pb = new Point(150, 150);

		double angle = getAngle(p0, pa, pb);
		System.out.println(angle);

	}
}
