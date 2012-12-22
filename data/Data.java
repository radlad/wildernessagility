package data;

import java.util.ArrayList;

import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

public class Data {
	
	public static Area PipeStart = new Area(new Tile[] { new Tile(2987, 3937, 0), new Tile(2998, 3937, 0), new Tile(3000, 3939, 0), 
			new Tile(3006, 3939, 0), new Tile(3006, 3934, 0), new Tile(3002, 3930, 0), 
			new Tile(2990, 3930, 0), new Tile(2987, 3933, 0) });
	
	public static Area PipeDrawArea = new Area(new Tile[] { new Tile(2989, 3930, 0), new Tile(2989, 3937, 0), new Tile(2997, 3937, 0), 
			new Tile(2999, 3939, 0), new Tile(3002, 3939, 0), new Tile(3002, 3949, 0), 
			new Tile(3005, 3949, 0), new Tile(3006, 3947, 0), new Tile(3006, 3934, 0), 
			new Tile(3002, 3930, 0) });
	
	public static Area RopeStart = new Area(new Tile[] { new Tile(3002, 3954, 0), new Tile(3008, 3954, 0), new Tile(3008, 3951, 0), 
			new Tile(3007, 3949, 0), new Tile(3007, 3948, 0), new Tile(3002, 3948, 0) });
	
	public static Area RopeDrawArea = new Area(new Tile[] { new Tile(3001, 3959, 0), new Tile(3008, 3959, 0), new Tile(3008, 3952, 0), 
			new Tile(3007, 3950, 0), new Tile(3007, 3948, 0), new Tile(3001, 3948, 0) });
	
	public static Area JumpStart = new Area(new Tile[] { new Tile(2994, 3966, 0), new Tile(3007, 3966, 0), new Tile(3007, 3960, 0), 
			new Tile(3008, 3959, 0), new Tile(3008, 3957, 0), new Tile(3001, 3957, 0), 
			new Tile(3001, 3960, 0), new Tile(3001, 3962, 0), new Tile(2999, 3963, 0), 
			new Tile(2997, 3963, 0), new Tile(2996, 3962, 0), new Tile(2994, 3962, 0) });
	
	public static Area JumpDrawArea = new Area(new Tile[] { new Tile(2994, 3965, 0), new Tile(3003, 3965, 0), new Tile(3003, 3957, 0), 
			new Tile(2994, 3957, 0) });
	
	public static Area JumpExit = new Area(new Tile[] { new Tile(2993, 3963, 0), new Tile(2997, 3963, 0), new Tile(2997, 3958, 0), 
			new Tile(3000, 3958, 0), new Tile(3001, 3957, 0), new Tile(3001, 3955, 0), 
			new Tile(2993, 3955, 0) });
	
	public static Area LogStart = new Area(new Tile[] { new Tile(2991, 3963, 0), new Tile(2996, 3963, 0), new Tile(2997, 3962, 0), 
			new Tile(2997, 3957, 0), new Tile(3002, 3953, 0), new Tile(3002, 3942, 0), 
			new Tile(2999, 3942, 0), new Tile(2999, 3949, 0), new Tile(2991, 3949, 0) });
	
	public static Area LogDrawArea = new Area(new Tile[] { new Tile(2993, 3954, 0), new Tile(3002, 3954, 0), new Tile(3002, 3942, 0), 
			new Tile(2992, 3942, 0), new Tile(2992, 3948, 0) });
	
	public static Area CliffStart = new Area(new Tile[] { new Tile(2986, 3946, 0), new Tile(2990, 3946, 0), new Tile(2992, 3948, 0), 
			new Tile(2995, 3948, 0), new Tile(2995, 3942, 0), new Tile(2998, 3940, 0), 
			new Tile(2998, 3939, 0), new Tile(2986, 3939, 0) });
	
	public static Area CliffDrawArea = new Area(new Tile[] { new Tile(2987, 3947, 0), new Tile(2996, 3947, 0), new Tile(2996, 3942, 0), 
			new Tile(2999, 3939, 0), new Tile(2997, 3937, 0), new Tile(2987, 3937, 0) });
	
	public static Area WildAgilityCourse = new Area(new Tile[] { new Tile(2993, 3967, 0), new Tile(3005, 3967, 0), new Tile(3007, 3964, 0), 
			new Tile(3008, 3959, 0), new Tile(3008, 3952, 0), new Tile(3006, 3946, 0), 
			new Tile(3006, 3933, 0), new Tile(3003, 3930, 0), new Tile(2989, 3930, 0), 
			new Tile(2986, 3933, 0), new Tile(2986, 3946, 0), new Tile(2990, 3946, 0), 
			new Tile(2990, 3952, 0), new Tile(2989, 3952, 0), new Tile(2989, 3963, 0), 
			new Tile(2993, 3967, 0) });

	public static Tile LogTile = new Tile(3001, 3946, 0);
	public static Tile FallExit = new Tile(3005, 10362, 0);
	public static Tile FallenTile = new Tile(3003, 10355, 0);
	public static Tile PipeEntry = new Tile(3004, 3937, 0);
	public static Tile PipeExit = new Tile(3004, 3950, 0);
	public static Tile RopeEntry = new Tile(3005, 3953, 0);
	public static Tile RopeExit = new Tile(3005, 3958, 0);
	public static Tile RockEntry = new Tile(3002, 3960, 0);
	public static Tile RockExit = new Tile(2996, 3960, 0);
	public static Tile LogEntry = new Tile(3001, 3946, 0);
	public static Tile LogExit = new Tile(2994, 3945, 0);
	public static Tile CliffEntry = new Tile(2993, 3939, 0);
	public static Tile CliffExit = new Tile(2993, 3935, 0);
	
	public static int[] foodIDs = { 361, 379, 373, 7946, 385, 15272 }; 
	public static ArrayList<Integer> Food = new ArrayList<Integer>();
	
	public static boolean hasFallen = false;
	
	public static String status = "Waiting...";
	public static Timer runTime = new Timer(0);
	public static long startTime;
	public static int startLevel;
	public static int lapsCounter = 0;
	public static int oldLaps = 0;
	public static boolean lapDone = false;
	public static int totalHp;
	
	public static boolean paused = false;	
	public static boolean showPaint = true;
	public static boolean showDraw = true;
	
}
