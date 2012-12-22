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

public class DoRope extends Node {

	@Override
	public boolean activate() {
		return Data.WildAgilityCourse.contains(Players.getLocal().getLocation()) && !Data.hasFallen && Players.getLocal() != null && Data.RopeStart.contains(Players.getLocal().getLocation());
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
		
		SceneObject rope = SceneEntities.getNearest(64696);
		Data.status = "Doing rope...";			
		if (rope.isOnScreen()) {			
			if (!Players.getLocal().isMoving() && Players.getLocal().getAnimation() == -1) {				
				rope.interact("Swing-on");				
				Task.sleep(Random.nextInt(400, 600));
			}
		} else {
			System.out.println("Does turnto");
			Camera.setPitch(Random.nextInt(5,25));
			Camera.turnTo(rope, Random.nextInt(-25, 25));
		}
	}

}
