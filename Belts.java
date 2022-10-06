package battle;

/**
 * A class for Belts gear.
 */
public class Belts extends  AbstractGears {
  String size;
  int unit;

  /**
   * Creating a Belt constructor.
   * @param name name.
   * @param affect affect.
   * @param size size.
   * @param unit unit.
   */
  public Belts(String name, int affect, String size, int unit) {
    super(3, name, affect);
    this.size = size;
    this.unit = unit;
  }

  /**
   * Overriding getAffect method.
   */
  @Override
  public int getAffect() {
    return this.affect;
  }

  /**
   * Overriding getName method.
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Overriding toStringGear method.
   */
  @Override
  public String toString() {
    return this.name + " " + this.affect + " " + this.unit;
  }

  /**
   * Overriding getSize method.
   */
  public String getSize() {
    return this.size;
  }

  /**
   * Overriding equalsBelt method.
   */
  @Override
  protected boolean equalsBelt(Belts other) {
    return this.name.equals(other.name)
            && this.size.equals(other.size)
            && this.affect == other.affect;
  }

  /**
   * Overriding equals method.
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof AbstractGears) {
      AbstractGears aGear = (AbstractGears) other;
      return aGear.equalsBelt(this);
    }
    return false;
  }

  /**
   * Overriding compareTo method.
   */
  @Override
  public int compareTo(Gears g) {
    if (g instanceof Belts) {
      return this.name.compareTo(((AbstractGears)g).name);
    }
    return this.gearOrder(g);
  }

  /**
   * Overriding hashCode method.
   */
  @Override
  public int hashCode() {
    return this.affect;
  }
}

