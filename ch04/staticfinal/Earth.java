package ch04.staticfinal;

public class Earth {
	static final double PI = Math.PI;
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_SURFACE_AREA;
	
	static {
		EARTH_SURFACE_AREA = 4 * PI * EARTH_RADIUS * EARTH_RADIUS;
	}

}
