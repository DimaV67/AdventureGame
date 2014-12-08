import java.io.File;
import java.io.IOException;
import java.util.*;

public class map {
	//properties
	public GameHashMap <Room> GameWorld;			//Create an 'empty' hashmap
	public Room CurrentRoom;
	public String FirstRoomTag;
	
	//constructor
	public map(){
		GameWorld= new GameHashMap<Room>();
		
	}
	
	//methods
	public void BuildAdventureWorld(String AdventureFile) throws IOException

	{
		String line;
		String data[];
		
		Scanner scan = new Scanner (new File(AdventureFile));
		
     	for (int linenr = 1; scan.hasNextLine (); ++linenr) {
			//looking for "r,d,o,t"
			//split line
			//split command --> myString.split("\\s+");
     		line = scan.nextLine();
			data = line.split(" ");
				//Description
				if (data[0].equals("d")&&CurrentRoom!=null) {
					//read description from the file and update Room Description property
					CurrentRoom.AddDescription(line.substring(1).trim());
				
					//update hash map
					//GameWorld.put(CurrentRoom.Name, CurrentRoom);
			}
				
				//Tag
				else if (data[0].equals ("t")&&CurrentRoom!=null) {
					CurrentRoom.AddTag(data[1]);
					//GameWorld.put(CurrentRoom.Name, CurrentRoom);	

				}
				//Options
				else if (data[0].equals("o")&&CurrentRoom!=null) {
					
					CurrentRoom.AddOption(line.substring(1).trim());
					//update hash map
					//GameWorld.put(CurrentRoom.Name, CurrentRoom);
			
				}
				//Make Room
				else if (data[0]. equals("r")) {
				
					Room tempRoom = new Room();
					//need to add roomName to hashTable
					tempRoom.Name = data[1];
				
					//insert new room into hashmap
					GameWorld.put (data[1],tempRoom);
					
					//set Current room 
					CurrentRoom = tempRoom;
					if (linenr==1) FirstRoomTag=tempRoom.Name;

				}
				
			}
        scan.close();
        return;
        }

}






