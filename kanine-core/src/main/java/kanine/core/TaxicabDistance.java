package kanine.core;

import java.nio.FloatBuffer;

/**
 * Calculates the <a
 * href="http://en.wikipedia.org/wiki/Taxicab_distance">Taxicab distance</a>
 * between two vectors.
 */
public final class TaxicabDistance extends Distance {

    @Override protected float distance(final float[] a, final int aOffset,
            final float[] b, final int bOffset, final int length) {
        float d = 0f;
        for (int i = 0; i < length; i++) {
            float ai = a[aOffset + i];
            float bi = b[bOffset + i];
            float diff = ai - bi;
            d += Math.abs(diff);
        }
        return d;
    }

    @Override protected float distance(final float[] a, final int aOffset,
            final FloatBuffer b, final int bOffset, final int length) {
        float d = 0f;
        for (int i = 0; i < length; i++) {
            float ai = a[aOffset + i];
            float bi = b.get(bOffset + i);
            float diff = ai - bi;
            d += Math.abs(diff);
        }
        return d;
    }

    @Override public String toString() {
        return getClass().getSimpleName();
    }

}
