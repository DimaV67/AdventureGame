import java.io.IOException;

public class AdventureGame {
	public static void main(String[] args) {
	String filename = null;
	Player p = null;

	//Build the map of the game
	map m = new map();
	
	
	if (args.length==0) {
		auxlib.die("Missing file name");
	}
	else{
    	    		
    		filename = args[0];
    	}
    	
    	
	try {
        	System.out.print("Loading game settings...\n");
			m.BuildAdventureWorld(filename);
			System.out.print("Game loaded sucessfully! Let's go!\n\n");
            
        }catch (IOException error) {
            auxlib.warn (error.getMessage());
            auxlib.exit();
        }
	
	// initialize PLayer and send him to the first room
		p= new Player(m);
		p.GoToRoom(m.FirstRoomTag);
		
		//tell player to start run the game
        p.Run();

        auxlib.exit();

		
	}

}
