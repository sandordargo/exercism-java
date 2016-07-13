import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdargo on 13/07/16.
 */
public class Allergies {

  private int score;
  private List<Allergen> allergies;

  public Allergies(int score) {
    this.score = score % 256;
    this.buildAllergenList();
  }

  public boolean isAllergicTo(Allergen allergenToCheck) {
    return this.allergies.contains(allergenToCheck);
  }

  public boolean checkAllergy(Allergen allergenToCheck) {
    if (((allergenToCheck.getScore() & (allergenToCheck.getScore() - 1)) == 0) && allergenToCheck.getScore() <= this.score) {
      this.score -= allergenToCheck.getScore();
      return true;
    }
    return false;
  }

  List<Allergen> getList() {
    return this.allergies;
  }

  private void buildAllergenList() {
    List<Allergen> allergies = new ArrayList<>();
    Allergen[] allergiesValues = Allergen.values();
    for (int i = allergiesValues.length - 1; i >= 0; i--) {
      if (this.checkAllergy(allergiesValues[i])) {
        allergies.add(0, allergiesValues[i]);
      }
    }
    this.allergies = allergies;
  }
}
