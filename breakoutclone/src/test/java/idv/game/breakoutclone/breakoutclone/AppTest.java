package idv.game.breakoutclone.breakoutclone;

import org.junit.Test;

import idv.game.breakoutclone.collider.BaseRectangle;
import idv.game.breakoutclone.collider.Circle;
import idv.game.breakoutclone.collider.Collider;
import idv.game.breakoutclone.collider.RoundedRectangle;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		// assertTrue( true );

		BaseRectangle rect1 = new RoundedRectangle(10, 40, 8);
		System.out.println("rect1 " + rect1);

		BaseRectangle rect2 = (BaseRectangle) Collider.prepareCteate("Rectangle").setLocation(20, 40).createNewOne();
		rect2.setRound_length(5);
		System.out.println("rect2 " + rect2);

		BaseRectangle rect3 = new Circle(20);
		rect3.setWidth(5);
		System.out.println("rect3 " + rect3);

	}

}
