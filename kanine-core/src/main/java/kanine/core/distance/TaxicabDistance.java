package kanine.core.distance;

public class TaxicabDistance extends Distance {

	@Override
	public float distance(float[] a, int aOffset, float[] b, int bOffset,
			int length) {
		float d = 0f;
		for (int i = 0; i < length; i++) {
			float ai = a[aOffset + i];
			float bi = b[bOffset + i];
			float diff = ai - bi;
			d += Math.abs(diff);
		}
		return d;
	}

}