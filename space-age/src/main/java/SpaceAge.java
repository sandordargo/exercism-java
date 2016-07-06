/**
 * Created by sdargo on 05/07/16.
 */
public class SpaceAge {
  private long age_in_seconds;

  private static final int EARTH_YEAR_IN_SECONDS = 31557600;
  private static final double MERCURY_YEAR_IN_SECONDS = 0.2408467 * EARTH_YEAR_IN_SECONDS;
  private static final double VENUS_YEAR_IN_SECONDS = 0.61519726 * EARTH_YEAR_IN_SECONDS;
  private static final double MARS_YEAR_IN_SECONDS = 1.8808158 * EARTH_YEAR_IN_SECONDS;
  private static final double JUPITER_YEAR_IN_SECONDS = 11.862615 * EARTH_YEAR_IN_SECONDS;
  private static final double SATURN_YEAR_IN_SECONDS = 29.447498 * EARTH_YEAR_IN_SECONDS;
  private static final double URANUS_YEAR_IN_SECONDS = 84.016846 * EARTH_YEAR_IN_SECONDS;
  private static final double NEPTUNE_YEAR_IN_SECONDS = 164.79132 * EARTH_YEAR_IN_SECONDS;

  SpaceAge(long age_in_seconds) {
    this.age_in_seconds = age_in_seconds;
  }

  public long getSeconds() { return this.age_in_seconds; }

  public double onEarth() { return (double)this.age_in_seconds / EARTH_YEAR_IN_SECONDS; }

  public double onMercury() { return (double)this.age_in_seconds / MERCURY_YEAR_IN_SECONDS; }
  public double onVenus() { return (double)this.age_in_seconds / VENUS_YEAR_IN_SECONDS; }
  public double onMars() { return (double)this.age_in_seconds / MARS_YEAR_IN_SECONDS; }
  public double onJupiter() { return (double)this.age_in_seconds / JUPITER_YEAR_IN_SECONDS; }
  public double onSaturn() { return (double)this.age_in_seconds / SATURN_YEAR_IN_SECONDS; }
  public double onUranus() { return (double)this.age_in_seconds / URANUS_YEAR_IN_SECONDS; }
  public double onNeptune() { return (double)this.age_in_seconds / NEPTUNE_YEAR_IN_SECONDS; }


}
