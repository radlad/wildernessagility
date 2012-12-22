import gui.Paint;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.powerbot.core.event.events.MessageEvent;
import org.powerbot.core.event.listeners.MessageListener;
import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.Job;
import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Random;

import wilderness.DoCliff;
import wilderness.DoJump;
import wilderness.DoLog;
import wilderness.DoPipe;
import wilderness.DoRope;
import wilderness.WalkBack;

import data.Data;

@Manifest(authors = { "nootz" }, name = "MondoAgility", description = "A mediocre agility experience.", version = 1.0 )
public class MondoAgility extends ActiveScript implements PaintListener, MessageListener, MouseListener {

	@Override
	public void onRepaint(Graphics g1) {		
		Paint.doPaint(g1);			
	}
	
    private final List<Node> jobsCollection = Collections.synchronizedList(new ArrayList<Node>());
    private Tree jobContainer = null;

    public synchronized final void provide(final Node... jobs) {
            for (final Node job : jobs) {
                    if(!jobsCollection.contains(job)) {
                            jobsCollection.add(job);
                    }
            }
            jobContainer = new Tree(jobsCollection.toArray(new Node[jobsCollection.size()]));
    }

    public synchronized final void revoke(final Node... jobs) {
            for (final Node job : jobs) {
                    if(jobsCollection.contains(job)) {
                            jobsCollection.remove(job);
                    }
            }
            jobContainer = new Tree(jobsCollection.toArray(new Node[jobsCollection.size()]));
    }

    public final void submit(final Job... jobs) {
            for (final Job job : jobs) {
                    getContainer().submit(job);
            }
    }

	@Override
	public int loop() {		
		if (Data.paused) {
			Task.sleep(50);
		} else {
			if (jobContainer != null) {
	            final Node job = jobContainer.state();
	            if (job != null) {
	                    jobContainer.set(job);
	                    getContainer().submit(job);
	                    job.join();
	            }
			}
		}		
		return Random.nextInt(50, 100);
	}
	
	@Override
	public void onStart() {
		provide(new WalkBack(), new DoPipe(), new DoRope(), new DoJump(), new DoLog(), new DoCliff()); 
		Data.startTime = System.currentTimeMillis();
		Data.startLevel = Skills.getRealLevel(Skills.AGILITY);
		Data.lapsCounter = 0;
		Data.oldLaps = 0;
		for (int i : Data.foodIDs) {
			Data.Food.add(i);
		}
		Data.totalHp = Integer.parseInt(Widgets.get(748, 8).getText());   
	}
	
	@Override
	public void onStop() {
		
	}


	@Override
	public void messageReceived(MessageEvent m) {
		if (m.getId() != 2 && m.getMessage().contains("You slip and fall")) {
			Data.hasFallen = true;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent p) {
		final Rectangle pauseBot = new Rectangle(8, 330, 50, 13);
		final Rectangle toggleDraw = new Rectangle(69, 330, 70, 13);
		
		if(pauseBot.contains(p.getPoint())) {
			Data.paused = !Data.paused;
			Data.status = Data.paused ? "Paused." : "Waiting...";
        }
		if(toggleDraw.contains(p.getPoint())) {
			Data.showDraw = !Data.showDraw;
        }
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

}
