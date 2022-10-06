package battle;

import java.util.Random;

/**
 * This abstract class represents an abstract Weapon.
 */
public abstract class AbstractWeapon implements Weapons {
  protected int damage;
  protected  String name;
  Random rand = new Random();

  protected AbstractWeapon(String name, int damage) {
    this.damage = damage;
    this.name = name;
  }

  /**
   * Determine whether this weapon is equal to a Katanas Question.
   *
   * @param other the katanas object to which this Question must be compared.
   * @return false by default, subclasses may override.
   */
  protected boolean equalsKatanas(Katanas other) {
    return false;
  }

  /**
   * Determine whether this weapon is equal to a flail Question.
   *
   * @param other the flail object to which this Question must be compared.
   * @return false by default, subclasses may override.
   */
  protected boolean equalsFlails(Flails other) {
    return false;
  }

  /**
   * Determine whether this weapon is equal to a BroadSwords Question.
   *
   * @param other the BroadSwords object to which this Question must be compared.
   * @return false by default, subclasses may override.
   */
  protected boolean equalsBroadSwords(BroadSwords other) {
    return false;
  }

  /**
   * Determine whether this weapon is equal to a TwoHandedSwords Question.
   *
   * @param other the TwoHandedSwords object to which this Question must be compared.
   * @return false by default, subclasses may override.
   */
  protected boolean equalsTwoHandedSwords(TwoHandedSwords other) {
    return false;
  }

  /**
   * Determine whether this weapon is equal to a Axes Question.
   *
   * @param other the Axes object to which this Question must be compared.
   * @return false by default, subclasses may override.
   */
  protected boolean equalsAxe(Axes other) {
    return false;
  }
}
