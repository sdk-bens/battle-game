package battle;

/**
 * This abstract class represents a abstract Gear.
 */
public abstract class AbstractGears implements Gears {
  protected int order;
  protected int affect;
  protected String name;


  protected AbstractGears(int order, String name, int affect) {
    this.order = order;
    this.affect = affect;
    this.name = name;
  }

  /**
   * Determine whether this gear is equal to a Belts Question.
   *
   * @param other the Belts object to which this gear must be compared.
   * @return false by default, subclasses may override.
   */
  protected boolean equalsBelt(Belts other) {
    return false;
  }

  /**
   * Determine whether this gear is equal to a HeadGear Question.
   *
   * @param other the Belts object to which this gear must be compared.
   * @return false by default, subclasses may override.
   */
  protected boolean equalsHeadGear(HeadGear other) {
    return false;
  }

  /**
   * Determine whether this gear is equal to a FootWear Question.
   *
   * @param other the FootWear object to which this gear must be compared.
   * @return false by default, subclasses may override.
   */
  protected boolean equalsFootWear(FootWear other) {
    return false;
  }

  /**
   * Determine whether this gear is equal to a Potions Question.
   *
   * @param other the Potions object to which this gear must be compared.
   * @return false by default, subclasses may override.
   */
  protected boolean equalsPotions(Potions other) {
    return false;
  }

  /**
   * ordering the gears.
   */
  protected int gearOrder(Gears other) {
    return this.order - ((AbstractGears)other).order;
  }

  public abstract int compareTo(Gears g);
}
