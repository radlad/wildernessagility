package wilderness;

import methods.Methods;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.api.wrappers.node.SceneObject;

import data.Data;

public class DoCliff extends Node {

	@Override
	public boolean activate() {
		return Data.WildAgilityCourse.contains(Players.getLocal().getLocation()) && !Data.hasFallen && Players.getLocal() != null && Data.CliffStart.contains(Players.getLocal().getLocation());
	}

	@Override
	public void execute() {			
		
		int currentHp = Integer.parseInt(Widgets.get(748, 8).getText());
		if (currentHp < Data.totalHp*0.5) {
			Item food = Inventory.getItem(Methods.getFoodId());			
			if (food != null) {				
				Data.status = "Eating food.";
				food.getWidgetChild().click(true); 						
			}
		}
		
		if (Players.getLocal().getAnimation() == 3378 && !Data.lapDone) {
			Data.lapDone = true;
			Data.lapsCounter+=1;			
		}
		
		SceneObject cliff = SceneEntities.getNearest(65734);
		Data.status = "Doing cliff...";
		if (cliff.isOnScreen()) {
			if (!Players.getLocal().isMoving() && Players.getLocal().getAnimation() == -1) {
				cliff.interact("Climb");
				Task.sleep(Random.nextInt(400, 600));
			}
		} else {
			Camera.setPitch(Random.nextInt(5,25));
			Camera.turnTo(cliff, Random.nextInt(-25, 25));
		}		
	}

}
