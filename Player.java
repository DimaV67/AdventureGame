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
				String tmp = null;
				//pop current room
				//we need to pop one before last element to get to the previous room
				if (!history.IsEmpty()) {
					tmp =history.pop();}
				else {
					System.out.print("\nSorry, you are in the first room\n");
					}
				if (!history.IsEmpty()) {
					tmp =history.pop(); }
				else {
					System.out.print("\nSorry, you are in the first room\n");
				}
			
				if (tmp != null){
					GoToRoom(tmp);
				}
				else System.out.print("\nSorry, you are in the first room\n");
				break;
				
			case 'r':
				Restart();
				break;
				
			case 'y':
				PrintAdventure();
				//game.GameWorld.Print();
				break;
				
			case 'q':
				//System.exit(0);
				break;
				
			default:
				if(CurrentRoom.Options.get(key)!=null) GoToRoom(CurrentRoom.Options.get(key).RoomTag);
				break;
		}
		
		return;
	}
	
	public void PrintAdventure(){
		//add code here
		Room tmp;
		while (game.GameWorld.hasNext()){
			tmp = game.GameWorld.next();
			System.out.print("Room:"+ tmp.Name+"\n");
			tmp.PrintOptions();
			}
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
		CurrentRoom.PrintAllOptions();
		System.out.print("\n");
		
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
							System.out.println("Please enter a command:");
						}
					} catch (IOException e) {
						
						e.printStackTrace();
						return 1;
					}
			}
			while (c!='q');
			
			System.out.print("\nThank you for playing! Good bye!\n");
			return 0;
		}
	
}
