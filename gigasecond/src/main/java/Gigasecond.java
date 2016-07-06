import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by sdargo on 06/07/16.
 */
public class Gigasecond {

  LocalDateTime datetime;

  Gigasecond(LocalDate date) {
    this.datetime = date.atStartOfDay();
  }

  Gigasecond(LocalDateTime datetime) {
    this.datetime = datetime;
  }

  public LocalDateTime getDate() {
    return this.datetime.plusSeconds(1000000000);
  }

}
