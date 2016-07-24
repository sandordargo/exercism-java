import java.util.Arrays;
import java.util.List;

public enum MeetupSchedule {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    LAST,
    TEENTH;

    private static List<Integer> teenthDays = Arrays.asList(13, 14, 15, 16, 17, 18, 19);

    public static boolean isTeenthDay(int dayOfMonth) {
      return MeetupSchedule.teenthDays.contains(dayOfMonth);
    }

  public static Integer whichToInt(MeetupSchedule which) {
    switch (which) {
      case FIRST:
        return 1;
      case SECOND:
        return 2;
      case THIRD:
        return 3;
      case FOURTH:
        return 4;
      case LAST:
        return 5;
      case TEENTH:
        return 6;
      default:
        return 0;
    }
  }
}
