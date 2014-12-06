import java.io.IOException;


public class Player {
	Room CurrentRoom= null;
	
	//stack to keep the history
	GameStack<String> history = new GameStack<String>();
	map game= null;
	
	public Player(map m){
		game=m;
			
	}
	public void DoTheOption(char key){
		
		switch(key){
			case 'z':
				String tmp;
				//pop current room
				tmp =history.pop();
				tmp =history.pop();
				if (tmp != null){
					GoToRoom(tmp);
				}
				break;
			case 'r':
				Restart();
				break;
				
			case 'y':
				PrintAdventure();
				break;
				
			case 'q':
				System.exit(0);
				
			default:
				if(CurrentRoom.Options.get(key)!=null) GoToRoom(CurrentRoom.Options.get(key).RoomTag);
				break;
		}
		
		return;
	}
	
	public void PrintAdventure(){
		//add code here
	}
	
	public int GoToRoom(String key){
				
		CurrentRoom = game.GameWorld.get(key);
		if (CurrentRoom==null) auxlib.die("No room for the key:"+key);
		
		//remember current room
		history.push(key);
		
		//set the player into the room
		CurrentRoom.p= this;
		
		//print room info
		CurrentRoom.PrintInfo();
		CurrentRoom.PrintOptions();
		
		return 0;
	}
	
	public void Restart(){
		//go to first room
		GoToRoom(game.FirstRoomTag);
		//reset the history
		history = new GameStack<String>();
		
	}
	
	//run the game
		public int Run()
		{
			char c = 0;
			System.out.println("Please enter a command:");
			
			do{
				try {
						c =  (char) System.in.read();
						if ( CurrentRoom.Options.get(c)!=null){
							//CurrentRoom.Options.get(c).runCommand(c);
							DoTheOption(c);
						}
					} catch (IOException e) {
						
						e.printStackTrace();
					}
			}
			while (c!='q');
			
			return 0;
		}
	
}
