package idv.game.breakoutclone.system.physics;

import org.junit.jupiter.api.Test;

import idv.game.breakoutclone.collider.Collider;

public class Locations {
	public static Point translateToWorldLocation(Collider parent, Point p) {
		Point location = parent.getOwner().getLocation();

		return new Point(location.x + parent.getX() + p.x, location.y + parent.getY() + p.y);
	}

	public static double getIncidenceAngle(Point p0, Point p1, Point p2) {
		return getAngle(p0, p1, p2);
	}

	/**
	 * 
	 * @param pSrc 線段|pSrc p1| 和 |pSrc p2| 相交於 pSrc
	 * @param p1
	 * @param p2
	 * @return
	 */
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

	public static Vector getReflectionVector(Vector incidentceVector, Vector normalVector) {
		// 公式 R=I-2(I.N)N
		// I=入射向量, R=反射向量, N=法線向量
		// I.N = |I||N|cosθ = I.x*N.x+I.y*N.y

		Vector incidentceNorm = getNorm(incidentceVector);
		Vector normalNorm = getNorm(normalVector);
		Vector reflectionVector = new Vector();

		double IdotN = incidentceNorm.x * normalNorm.x + incidentceNorm.y * normalNorm.y;
		reflectionVector.x = incidentceNorm.x - 2 * IdotN * normalNorm.x;
		reflectionVector.y = incidentceNorm.y - 2 * IdotN * normalNorm.y;

		return reflectionVector;
	}

	public static double getReflectionAngle(double p0Angle, double incidenceAngle) {
		// 公式 R=I-2(I.N)N
		// I=入射向量, R=反射向量, N=法線向量
		// I.N = |I||N|cosθ = I.x*N.x+I.y*N.y

		return p0Angle - incidenceAngle * 2;
	}

	/**
	 * 
	 * @param vector
	 * @return 單位向量
	 */
	public static Vector getNorm(Vector vector) {
		double length = Physics.calcDistance(new Point(), vector);
		double rate = 1 / length;

		return new Vector(vector.x * rate, vector.y * rate);
	}

	/**
	 * 
	 * @param collidePoint 線段|pSrc anyPointInLine| 和 |pSrc incidentcePoint| 相交於 pSrc
	 * @param anyPointInLine
	 * @param incidentceP0
	 * @return 法線向量
	 */
	public static Vector getNormal(Point collidePoint, Point anyPointInLine, Point incidentceP0) {
		// line 向量
		Vector lineVector = new Vector(anyPointInLine.x - collidePoint.x, anyPointInLine.y - collidePoint.y);

		// 法線向量
		Vector normalVector1 = new Vector(-1 * lineVector.y, lineVector.x);
		Vector normalVector2 = new Vector(lineVector.y, -1 * lineVector.x);

		double angle = getAngle(collidePoint, incidentceP0,
				new Point(normalVector1.x + collidePoint.x, normalVector1.y + collidePoint.y));
		if (angle < 90) {
			return normalVector1;
		} else {
			return normalVector2;
		}
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
