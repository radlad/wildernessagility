package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import methods.Methods;

import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.wrappers.node.SceneObject;

import data.Data;

public class Paint {	
	final static RenderingHints antialiasing = new RenderingHints(
	            RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
    public final static Color color_mouse = new Color(250, 250, 250, 200);
    public final static Color color_mouse_opa = new Color(222, 222, 222, 150);
    public final static Color color_lightgreen = new Color(173, 255, 47, 225);
    public final static Color color_lightgreen_opa = new Color(173, 255, 47, 75);   
    public final static Color color_orange = new Color(205, 133, 63, 200);   

    public final static Color color1 = new Color(0, 0, 0, 160);
    public final static Color color2 = new Color(0, 0, 0);
    public final static Color color3 = new Color(255, 255, 255, 200);
    public final static Color color4 = new Color(255, 5, 5, 200);
    public final static Color color5 = new Color(255, 255, 255, 180);
    public final static Color color6 = new Color(255, 255, 255, 160);
    
    public final static BasicStroke stroke2 = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);    
    public final static BasicStroke stroke1 = new BasicStroke(1);

    public final static Font font1 = new Font("Myriad Pro", 1, 14);
    public final static Font font2 = new Font("Myriad Pro", 1, 10);
    public final static Font font3 = new Font("Myriad Pro", 0, 12);


    
	public static void doPaint(Graphics g1) {	
		Graphics2D g = (Graphics2D)g1;
	    g.setRenderingHints(antialiasing);
	    
		SceneObject pipe = SceneEntities.getNearest(65362);
		SceneObject rope = SceneEntities.getNearest(64696);
		SceneObject rock = SceneEntities.getNearest(64699);
		SceneObject log = SceneEntities.getNearest(64698);
		SceneObject cliff = SceneEntities.getNearest(65734);
		
		if (Data.showDraw) {
			if (Data.PipeDrawArea.contains(Players.getLocal().getLocation())) {
				if (pipe != null) {
					if (pipe.isOnScreen()) {			
						//Methods.drawSceneObj(g1, pipe, color_lightgreen, 225);
						Methods.fillSceneObj(g1, pipe, color_lightgreen_opa, 75);
						Methods.fillTile(g1, Data.PipeEntry, color_lightgreen_opa, 75);
						Methods.drawTile(g1, Data.PipeEntry, color_lightgreen, 225);
						Methods.fillTile(g1, Data.PipeExit, color_lightgreen_opa, 75);
						Methods.drawTile(g1, Data.PipeExit, color_lightgreen, 225);
					}
				}
			}
			if (Data.RopeDrawArea.contains(Players.getLocal().getLocation())) {
				if (rope != null) {
					if (rope.isOnScreen()) {
						//Methods.drawSceneObj(g1, rope, color_lightgreen, 225);
						Methods.fillSceneObj(g1, rope, color_lightgreen_opa, 75);
						Methods.fillTile(g1, Data.RopeEntry, color_lightgreen_opa, 75);
						Methods.drawTile(g1, Data.RopeEntry, color_lightgreen, 225);
						Methods.fillTile(g1, Data.RopeExit, color_lightgreen_opa, 75);
						Methods.drawTile(g1, Data.RopeExit, color_lightgreen, 225);
					}
				}
			}
			if (Data.JumpDrawArea.contains(Players.getLocal().getLocation())) {
				if (rock != null) {
					if (rock.isOnScreen()) {
						//Methods.drawSceneObj(g1, rock, color_lightgreen, 225);
						Methods.fillSceneObj(g1, rock, color_lightgreen_opa, 75);
						Methods.fillTile(g1, Data.RockEntry, color_lightgreen_opa, 75);
						Methods.drawTile(g1, Data.RockEntry, color_lightgreen, 225);
						Methods.fillTile(g1, Data.RockExit, color_lightgreen_opa, 75);
						Methods.drawTile(g1, Data.RockExit, color_lightgreen, 225);
					}
				}
			}
			if (Data.LogDrawArea.contains(Players.getLocal().getLocation())) {
				if (log != null) {
					if (log.isOnScreen()) {
						//Methods.drawSceneObj(g1, log, color_lightgreen, 225);
						Methods.fillSceneObj(g1, log, color_lightgreen_opa, 75);
						Methods.fillTile(g1, Data.LogEntry, color_lightgreen_opa, 75);
						Methods.drawTile(g1, Data.LogEntry, color_lightgreen, 225);
						Methods.fillTile(g1, Data.LogExit, color_lightgreen_opa, 75);
						Methods.drawTile(g1, Data.LogExit, color_lightgreen, 225);
					}
				}
			}
			if (Data.CliffDrawArea.contains(Players.getLocal().getLocation())) {
				if (cliff != null) {
					if (cliff.isOnScreen()) {
						//Methods.drawSceneObj(g1, cliff, color_lightgreen, 225);
						Methods.fillSceneObj(g1, cliff, color_lightgreen_opa, 75);
						Methods.fillTile(g1, Data.CliffEntry, color_lightgreen_opa, 75);
						Methods.drawTile(g1, Data.CliffEntry, color_lightgreen, 225);
						Methods.fillTile(g1, Data.CliffExit, color_lightgreen_opa, 75);
						Methods.drawTile(g1, Data.CliffExit, color_lightgreen, 225);
					}
				}
			}
		}
		
		if (Data.showPaint) {
		  	final Point p = Mouse.getLocation(); 
		    g.setColor(color_mouse_opa);
		    g.drawLine(0, p.y, Game.getDimensions().width, p.y);
		    g.drawLine(p.x, 0, p.x, Game.getDimensions().height);
		    g.setColor(Mouse.isPressed() ? Color.RED : color_mouse);    	    
		    if (!Mouse.isPressed()) {
		    g.setStroke(stroke2);
		    g.drawLine(Mouse.getX(), Mouse.getY() + 8, Mouse.getX(), Mouse.getY() - 8);
		    g.drawLine(Mouse.getX() + 8, Mouse.getY(), Mouse.getX() - 8, Mouse.getY());
		    } else {
		    	g.fillRect(Mouse.getX() - 6, Mouse.getY() + 6, 3, 3);
		    	g.fillRect(Mouse.getX() + 6, Mouse.getY() + 6, 3, 3);
		    	g.fillRect(Mouse.getX() - 6, Mouse.getY() - 6, 3, 3);
		    	g.fillRect(Mouse.getX() + 6, Mouse.getY() - 6, 3, 3);
		    }
		    
	        g.setColor(color1);
	        g.fillRect(0, 344, 518, 44);
	        g.setColor(color1);
	        g.fillRect(0, 368, 518, 20);
	        g.setColor(color_orange);
	        g.fillRect(1, 369, (int) Methods.getExpBarLength(Skills.AGILITY, 517), 19);
	        g.setColor(color2);
	        g.setStroke(stroke1);
	        g.drawRect(0, 344, 518, 44);
	        g.drawRect(0, 368, 518, 20);
	        g.setColor(color1);
	        g.fillRect(8, 330, 50, 13);
	        g.setColor(color2);
	        g.drawRect(8, 330, 50, 13);
	        g.setColor(color1);
	        g.fillRect(69, 330, 70, 13);
	        g.setColor(color2);
	        g.drawRect(69, 330, 70, 13);
	        g.setFont(font1);
	        g.drawString("MondoAgility", 7, 362);
	        g.setColor(color3);
	        g.drawString("MondoAgility", 6, 361);
	        g.setFont(font2);
	        g.setColor(color2);
	        g.drawString("v1.0", 95, 362);
	        g.setColor(color4);
	        g.drawString("v1.0", 94, 361);
	        g.setFont(font3);
	        g.setColor(color5);
	        g.drawString("Run Time: " + Data.runTime.toElapsedString(), 135, 361);
	        g.drawString("Status: " + Data.status, 270, 361);
	        g.drawString("Laps: " + Data.lapsCounter + " (" + Methods.getPerHour(Data.lapsCounter) + " p/h)", 398, 361);
	        g.drawString("[ Agility: " + Skills.getRealLevel(Skills.AGILITY) + " (+" + (Skills.getRealLevel(Skills.AGILITY) - Data.startLevel) + ") | " + Methods.getExpPercent(Skills.AGILITY) + "% | " + Methods.kFormat(Methods.getXpHr(Skills.AGILITY)) + " xp/h | TTL: " + Methods.getTTNL(Skills.AGILITY) + " ]", 132, 382);
	        g.setFont(font2);
	        g.setColor(color6);
	        g.drawString("Pause", 22, 340);
	        g.drawString("Toggle Draw", 75, 340);


		}
	}
}
