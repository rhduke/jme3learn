/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

/**
 *
 * @author Ronald
 */
public class Chap3Charges {
    private int charges;
    private int damage;
    
    public Chap3Charges(int charges, int damage) {
        this.charges = charges;
        this.damage = damage;
    }
    
    public void recharge() {
        charges++;
    }
    
    public void discharge() {
        if (!isEmpty()) {
            charges--;
        }
    }
    
    public boolean isEmpty() {
        if (charges <= 0) return true;
        else return false;
    }
    
    public int getCharges() { return charges; }
    
    public int getDamage() { return damage; }
}
