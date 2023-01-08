package idv.game.breakoutclone.tools;

import java.util.Optional;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import idv.game.breakoutclone.system.physics.Point;

public class Unit {
	public static <T> Optional<T> resolve(Supplier<T> resolver) {
		try {
			T result = resolver.get();
			return Optional.ofNullable(result);
		} catch (NullPointerException e) {
			return Optional.empty();
		}
	}

	@Test
	public void test() {

		Point p=new Point(10,20);
		
		System.out.println("unit "+Unit.resolve(()->p.x));
	
		
	}
}
