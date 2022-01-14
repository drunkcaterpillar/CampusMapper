

public class Connection {
  private Intersection target;
  private int distance;

  public Connection(Intersection target, int distance) {
    this.target = target;
    this.distance = distance;
  }

  public Intersection getTarget() {
    return target;
  }

  public int getDistance() {
    return distance;
  }

  @Override
  public String toString() {
    return target.getName();
  }
}