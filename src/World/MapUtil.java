package World;

import GameLogic.Player;
import static World.Map.MAP_HEIGHT;
import static World.Map.MAP_WIDTH;
import static World.Map.downOff;
import static World.Map.initalize;
import static World.Map.initalized;
import static World.Map.redrawMap;
import static World.Map.redrawUnits;
import static World.Map.rightOff;

/**
 *
 * @author d.holmberg
 */
public abstract class MapUtil extends Map{


    
    public static boolean checkTileLand(int startX, int startY) {
        if (TILE_WORLD[startX][startY] == 0) return true;
        if (TILE_WORLD[startX][startY] == 1) return true;
        return false;
    }

    public static void setFocus(Player player) {
        if(!initalized) initalize();
        rightOff = player.getStartX()-(displayWidth/2);
        downOff = player.getStartY()-(displayHeight/2);
        
        if(rightOff < 0) rightOff = MAP_WIDTH + rightOff;
        if(downOff < 0) downOff = MAP_HEIGHT + downOff;
        
        redrawMap();
        redrawUnits();
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
