package GameLogic;

/**
 *
 * @author d.holmberg
 */
public class Combat {
    
    public static void unitMelee(Unit attacker, Unit defender){
        defender.changeHealth(attacker.getMDamage() - defender.getMDefence());
        attacker.changeHealth(defender.getMDamage() - attacker.getMDefence());
        checkUnitDeath(attacker);
        checkUnitDeath(defender);
    }
    
    public static void unitRanged(Unit attacker, Unit defender){
        defender.changeHealth(attacker.getRDamage() - defender.getRDefence());
        checkUnitDeath(defender);
    }
   
    public static void unitMelee(Unit attacker, City defender){
        defender.changeHealth(attacker.getMDamage() - defender.getMDefence());
        attacker.changeHealth(defender.getMDamage() - attacker.getMDefence());
        checkUnitDeath(attacker);
        checkUnitDeath(defender);
    }
    
    public static void unitRanged(Unit attacker, City defender){
        defender.changeHealth(attacker.getRDamage() - defender.getRDefence());
        checkUnitDeath(defender);
    }
    
    public static void cityRanged(City attacker, Unit defender){
        defender.changeHealth(attacker.getRDamage() - defender.getRDefence());
    }
    
    private static void checkUnitDeath(Unit unit) {
        if(unit.getHealth() == 0) unit.kill();
    }
    
    //----Variables-----------

    


    
    //----Object-Methods-------

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
