package kanine.core.accumulators;

import kanine.core.Result;

public final class PartialQuickSortAccumulator
        implements BestResultsAccumulator {

	private final float[] distances;
	private final int[] index;
	private int sorted = 0;

	public PartialQuickSortAccumulator(int indexSize) {
		this.distances = new float[indexSize];
		this.index = new int[indexSize];
		for (int i = 0; i < indexSize; i++) {
			distances[i] = Float.MAX_VALUE;
			index[i] = i;
		}
	}

    @Override
	public void accumulate(int index, float distance) {
		if (sorted > 0) {
			throw new IllegalStateException("arrays already sorted");
		}
		distances[index] = distance;
	}

    @Override
	public Result[] get(int n) {
		if (sorted < n) {
			QuickSort.select(distances, index, n);
			sorted = n;
		}
        int safeN = Math.min(n, index.length);
		Result[] results = new Result[safeN];
		for (int i = 0; i < safeN; i++) {
			results[i] = new Result(index[i], distances[i]);
		}
		return results;
	}

}
