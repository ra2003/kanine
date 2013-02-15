package kanine.core;

import kanine.core.ArrayDataset;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import org.mockito.InOrder;
import org.mockito.stubbing.OngoingStubbing;
import static org.mockito.Mockito.*;

import kanine.core.BestResultsAccumulator;
import kanine.core.Scorer;

public class ArrayDatasetTest {

    @Test
    public void applyArrayAllElements() {
        final int vectorLength = 10;
        final int size = 5;
        final float[] data = new float[vectorLength * size];
        final ArrayDataset dataset = new ArrayDataset(data, vectorLength);
        final Scorer scorer = mock(Scorer.class);
        final BestResultsAccumulator accum = mock(BestResultsAccumulator.class);
        OngoingStubbing<Float> scoreStub =
            when(scorer.inverseScore(any(float[].class), anyInt()));
        for (int i = 0; i < size; i++) {
            scoreStub = scoreStub.thenReturn((float) i);
        }
        scoreStub.thenThrow(new AssertionError("no more elements"));
        dataset.apply(scorer, accum);
        final InOrder inOrder = inOrder(scorer, accum);
        for (int i = 0; i < size; i++) {
            inOrder.verify(scorer).inverseScore(data, i * vectorLength);
            inOrder.verify(accum).accumulate(i, (float) i);
        }
    }

}