package kanine.core.accumulators;

import kanine.core.accumulators.PartialQuickSortAccumulator;

public class QuickSelectAccumulatorTest extends AbstractAccumulatorTest {

	@Override
	protected PartialQuickSortAccumulator createAccumulator(int indexSize, int nBest) {
		return new PartialQuickSortAccumulator(indexSize);
	}
}
