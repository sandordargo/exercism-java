/**
 * Created by sdargo on 05/07/16.
 */
public class Triangle {
  private double a;
  private double b;
  private double c;

  Triangle (double a, double b, double c) throws TriangleException {
    if (a <= 0.0 || b <= 0.0 || c <= 0.0) { throw new TriangleException(); }
    if (a + b <= c || a + c <= b || b + c <= a) { throw new TriangleException(); }
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public TriangleKind getKind() {
    if (this.a == this.b && this.a == this.c) {
      return TriangleKind.EQUILATERAL;
    } else if (this.a == this.b || this.a == this.c || this.b == this.c) {
      return TriangleKind.ISOSCELES;
    }
    return TriangleKind.SCALENE;
  }
}
