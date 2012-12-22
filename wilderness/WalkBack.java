package wilderness;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.node.SceneObject;

import data.Data;


public class WalkBack extends Node {

	@Override
	public boolean activate() {			
		return Data.hasFallen && Data.FallExit != null;
	}

	@Override
	public void execute() {
		SceneObject ladder = SceneEntities.getNearest(32015);
		Data.status = "Walking back...";
		
		if (Players.getLocal().getAnimation() == 828) {
			Data.hasFallen = false;
		}
		
		if (Data.FallenTile != null) {
			if (Calculations.distanceTo(Data.FallenTile) > 8) {
				if (!Players.getLocal().isMoving() && Data.FallenTile != null) {
					if (Data.FallenTile.isOnScreen()) {
						Data.FallenTile.interact("Walk here");
						Task.sleep(Random.nextInt(400, 600));
					} else {
						Data.FallenTile.clickOnMap();
						Task.sleep(Random.nextInt(400, 600));
					}		
				}		
			} else {
				if (ladder != null) {
					Camera.turnTo(ladder, Random.nextInt(-25, 25));
					ladder.interact("Climb-up");
				}
			}
		}

	}
	
}