import org.joda.time.DateTime;

/**
 * Created by sdargo on 04/07/16.
 */
public class Meetup {
  Integer year;
  Integer month;

  Meetup(Integer month, Integer year) {
    this.year = year;
    this.month = month;
  }

  public DateTime day(int day, MeetupSchedule which) {
    return new DateTime(year, month, getDayOfMonth(day, which), 0, 0, 0);
  }

  public Integer getDayOfMonth(int day, MeetupSchedule which) {
    DateTime month = new DateTime(year, this.month, 1, 0, 0, 0);
    Integer counter = 0;
    Integer dayToReturn = 1;
    Integer whichWeek = MeetupSchedule.whichToInt(which);
    while (month.getMonthOfYear() == this.month) {
      if (month.getDayOfWeek() == day) {
        counter++;
        dayToReturn = month.getDayOfMonth();
        if (counter == whichWeek || (whichWeek == 6 && MeetupSchedule.isTeenthDay(dayToReturn))) {
          return dayToReturn;
        }
      }
      month = month.plusDays(1);
    }
    return dayToReturn; //Will return last day cases
  }


  }

