package battle;

/**
 * This  class represents an axe.
 */
public class Axes extends AbstractWeapon {

  /**
   * Creating an axe constructor.
   * @param name name.
   * @param damage damage.
   */
  public Axes(String name,int damage) {
    super(name, damage);
  }

  /**
   * Overriding the get damage method.
   * @return the damage value.
   */
  @Override
  public int getDamage() {
    return rand.nextInt(11 - 6) + 6;
  }

  /**
   * Overriding the get name method.
   * @return the name.
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Overriding the toString method.
   */
  @Override
  public String toString() {
    return this.name + " " + this.damage;
  }

  /**
   * Overriding the equalsAxe method.
   */
  @Override
  protected boolean equalsAxe(Axes other) {
    return this.name.equals(other.name)
            && this.damage == other.damage;
  }

  /**
   * Overriding the equals method.
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof AbstractWeapon) {
      AbstractWeapon aWeapon = (AbstractWeapon) other;
      return aWeapon.equalsAxe(this);
    }
    return false;
  }

  /**
   * Overriding the hashCode method.
   */
  @Override
  public int hashCode() {
    return this.damage;
  }
}
