package battle;

import java.util.LinkedList;
import java.util.Random;

/**
 * This class represents a battle.
 */
public class Battle {
  Random rand = new Random();
  TwoHandedSwords twoHandedSwords = new TwoHandedSwords("twoHandedSwords",rand.nextInt(13 - 8) + 8);
  Axes axe = new Axes("axe",rand.nextInt(11 - 6) + 6);
  Flails flail = new Flails("flail",rand.nextInt(13 - 8) + 8);
  BroadSwords broadSwords = new BroadSwords("broadSwords",rand.nextInt(11 - 6) + 6);
  Katanas katana = new Katanas("katana",rand.nextInt(7 - 4) + 4);
  HeadGear headGear;
  FootWear footWear;
  Belts belt;
  Potions potion;

  /**
   * method for calculating the striking power.
   * @param player player.
   * @param playerGears gears that player is wearing.
   * @return the striking power of a player.
   */
  public double strikingPower(Player player, LinkedList<AbstractGears> playerGears) {
    double power = 0;
    if (playerGears.contains(potion)) {
      power = player.getDexterity() + potion.getAffect() + rand.nextInt(11 - 1) + 1;
    } else {
      power = player.getDexterity() + rand.nextInt(11 - 1) + 1;
    }
    return power;
  }

  /**
   * method for calculating the avoidance Ability.
   * @param player player.
   * @param playerGear gears that player is wearing.
   * @return the avoidance ability of a player.
   */
  public double avoidanceAbility(Player player, LinkedList<AbstractGears> playerGear) {
    double avoid = 0;
    if (playerGear.contains(footWear)) {
      avoid = player.getDexterity() + footWear.getAffect() + rand.nextInt(7 - 1) + 1;
    } else {
      avoid = player.getDexterity() + rand.nextInt(7 - 1) + 1;
    }
    return avoid;
  }

  /**
   * method for calculating the potential Damage.
   * @param player player.
   * @param g weapon used.
   * @return the potential damage a player can cause to their opponent.
   */
  public double potentialDamage(Player player, AbstractWeapon g) {
    //double damage = 0;
    if (g instanceof  Axes) {
      return player.getStrength() + g.getDamage();
    } else {
      if (g instanceof Katanas) {
        return player.getStrength() + rand.nextInt(7 - 4) + 4;
      } else {
        if (g instanceof  Flails) {
          if (player.getStrength() > 14) {
            return player.getStrength() + rand.nextInt(13 - 8) + 8;
          } else {
            return player.getStrength() + ((rand.nextInt(13 - 8) + 8) / 2.);
          }
        } else {
          if (g instanceof BroadSwords) {
            return player.getStrength() + rand.nextInt(11 - 6) + 6;
          } else {
            if (g instanceof TwoHandedSwords) {
              if (player.getStrength() > 14) {
                return player.getStrength() + rand.nextInt(13 - 8) + 8;
              } else {
                return player.getStrength() + (rand.nextInt(13 - 8) + 8 / 2.);
              }
            }
          }
        }
      }
    }
    return 0;
  }

  /**
   * Method for calculating the actual damage.
   * @param player1 player1
   * @param player2 player2
   * @param weapon weapon used by player1.
   * @return the damage that player 1 caused to player2
   */
  public double actualDamage(Player player1, Player player2, AbstractWeapon weapon) {
    return potentialDamage(player1, weapon) - player2.getConstitution() ;
  }

  /**
   * Attack method.
   * @param player1 player1.
   * @param player2 player2.
   * @param weapon weapon used by player1 to attack player2.
   * @return the health value of player who got attacked.
   */
  public double playerAttack(Player player1, Player player2, AbstractWeapon weapon) {
    LinkedList<AbstractGears> gears = new LinkedList<>();
    double player2Health = player2.getHealth();
    if (strikingPower(player1, gears ) > avoidanceAbility(player2, gears)) {
      return player2Health - actualDamage(player1, player2, weapon);
    }
    else {
      return player2.getHealth();
    }
  }
}
