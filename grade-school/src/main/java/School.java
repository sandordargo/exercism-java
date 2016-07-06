import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sdargo on 04/07/16.
 */
public class School {

  private Map<Integer, List<String>> gradeStudentsMap = new HashMap<>();

  public void add(String name, Integer grade) {
    if (!this.gradeStudentsMap.containsKey(grade)) {
      this.gradeStudentsMap.put(grade, new ArrayList<>());
    }
    this.gradeStudentsMap.get(grade).add(name);
  }

  public Map<Integer, List<String>> sort() {
    for (Integer value : this.gradeStudentsMap.keySet()) {
      this.gradeStudentsMap.get(value).sort(String::compareTo);
    }
    return this.gradeStudentsMap;
  }

  public Map<Integer, List<String>> db() {
    return this.gradeStudentsMap;
  }

  public List<String> grade(Integer grade) {
    if (!this.gradeStudentsMap.containsKey(grade)) {
      return new ArrayList<>();
    }
    return this.gradeStudentsMap.get(grade);
  }
}
