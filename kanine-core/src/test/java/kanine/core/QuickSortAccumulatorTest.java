package kanine.core;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuickSortAccumulatorTest extends AbstractAccumulatorTest {

	@Override protected QuickSortAccumulator createAccumulator(
            int indexSize, int nBest) {
		return new QuickSortAccumulator(indexSize);
	}

    @Test public void reuseFails() {
		BestResultsAccumulator a = createAccumulator(4, 3);
        testAccumulator(a);
        try {
            testAccumulator(a);
            fail();
        } catch (IllegalStateException e) {
        }
    }

}
