package methods;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.powerbot.game.api.methods.Settings;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.SkillData;
import org.powerbot.game.api.util.SkillData.Rate;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.node.SceneObject;

import data.Data;

public class Methods {
	public static NumberFormat k = new DecimalFormat("###,###,###");
	public static NumberFormat z = new DecimalFormat("#");
	public static NumberFormat t = new DecimalFormat("###.##");
	
	public static String kFormat(final int num) {
		return num / 1000 + "." + (num % 1000) / 100 + "K";
		}
	
	public static int getAdrPercent() {		
		return Settings.get(679) / 10;		
	}
	
	public static int getXpHr(int skill) {
		SkillData sr = new SkillData(Data.runTime);
		return sr.experience(Rate.HOUR, skill);		
	}
	
	public static long getTTNL(int skill) {
		SkillData sr = new SkillData(Data.runTime);
		return sr.timeToLevel(Rate.HOUR, skill);
	}
	
	public static double getExpBarLength(int skill, int maxlength) {
        int xpCurrent = Skills.getExperienceRequired(Skills.getRealLevel(skill));
        int xpNext = Skills.getExperienceRequired(Skills.getRealLevel(skill) + 1);        
        double xpBarLength = (xpCurrent / xpNext)*maxlength;
		return xpBarLength;   
	}
	
	public static double getExpPercent(int skill) {
        int xpCurrent = Skills.getExperienceRequired(Skills.getRealLevel(skill));
        int xpNext = Skills.getExperienceRequired(Skills.getRealLevel(skill) + 1);        
        int xpPercent = (xpCurrent / xpNext);
		return xpPercent;   
	}
	
	public static int getPerHour(int integer) {
		int perHour = (int) (integer * 3600000D / (System.currentTimeMillis() - Data.startTime));
		return perHour;		
	}
    
    public static void drawSceneObj(final Graphics g1, final SceneObject obj, final Color color, final int alpha) {    	
        if (obj != null) {
                        g1.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
                        for (Polygon p1 : obj.getBounds()) {
                                        g1.drawPolygon(p1);
                        }
        }
    }
	
    public static void fillSceneObj(final Graphics g1, final SceneObject obj, final Color color, final int alpha) {    	
        if (obj != null) {
                        g1.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
                        for (Polygon p1 : obj.getBounds()) {
                                        g1.fillPolygon(p1);
                        }
        }
    }
    
    public static void drawTile(final Graphics g1, final Tile tile, final Color color, final int alpha) {    	
        if (tile != null) {
                        g1.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
                        for (Polygon p1 : tile.getBounds()) {
                                        g1.drawPolygon(p1);
                        }
        }
    }
    
    public static void fillTile(final Graphics g1, final Tile tile, final Color color, final int alpha) {    	
        if (tile != null) {
                        g1.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
                        for (Polygon p1 : tile.getBounds()) {
                                        g1.fillPolygon(p1);
                        }
        }
    }
    
	public static int getFoodId() {
        for(int id : Data.Food) {
            if(Inventory.getCount(id) > 0) {
                return id;      
            }
        }
		return 0;				
	}
}
