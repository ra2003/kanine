package kanine.core;

import org.junit.Test;
import static org.junit.Assert.*;

import java.nio.FloatBuffer;

public class CosineSimilarityTest extends AbstractDistanceTest {

    @Override
    protected Distance getDistance() {
        return new CosineSimilarity(false, 0f);
    }

	@Test
	public void cosine() {
        // TODO split these tests
		CosineSimilarity d = new CosineSimilarity(true, 0f);
		// cos([1,1], [1,1]) = 1
		assertEquals(1f, d.distance(new float[] { 1f, 1f }, 0,
				new float[] { 1f, 1f }, 0, 2), ERROR);
		// cos([1,0], [0,1]) = 0
		assertEquals(0f, d.distance(new float[] { 0f, 1f }, 0,
				new float[] { 1f, 0f }, 0, 2), ERROR);
		// cos([1,0], [1,1]) = sqrt(.5)
		assertEquals(Math.sqrt(.5), d.distance(new float[] { 0f, 1f },
				0, new float[] { 1f, 1f }, 0, 2), ERROR);
		// fail on zero norm
		try {
			d.distance(new float[] { 0f, 0f }, 0, new float[] { 1f, 1f }, 0, 2);
			fail();
		} catch (ArithmeticException e) {
		}
		try {
			d.distance(new float[] { 1f, 1f }, 0,
                    FloatBuffer.wrap(new float[] { 0f, 0f }), 0, 2);
			fail();
		} catch (ArithmeticException e) {
		}
		try {
			d.distance(new float[] { 0f, 0f }, 0, new float[] { 0f, 0f }, 0, 2);
			fail();
		} catch (ArithmeticException e) {
		}
		// default on zero norm
		assertEquals(
				.12345f,
				new CosineSimilarity(false, .12345f).distance(new float[] { 0f,
						0f }, 0, new float[] { 0f, 0f }, 0, 2), ERROR);
	}

    @Test public void string() {
        assertEquals(new CosineSimilarity(true, 0f).toString(),
                "CosineSimilarity(zeronorm=fail)");
        assertEquals(new CosineSimilarity(false, 0.5f).toString(),
                "CosineSimilarity(zeronorm=0.5)");
    }
}

