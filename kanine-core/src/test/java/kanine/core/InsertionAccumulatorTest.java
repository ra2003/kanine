package kanine.core;

public class InsertionAccumulatorTest extends AbstractAccumulatorTest {

	@Override
	protected InsertionAccumulator createAccumulator(int indexSize, int nBest) {
		return new InsertionAccumulator(nBest);
	}

}
