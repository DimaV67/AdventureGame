import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Room{
	String Name;
	List <String> Descriptions;
	Player p;

	//Hashmap of options, functions and keyboard keys
	Map<Character, RoomOption> Options = new HashMap<Character, RoomOption>();
	char[] actionkeys = {'a','b','c','d','e','f','g','h','i','j','k','l','r','q','y','z'};
	int lastkey =0;
	int SIZE = 12;

	class RoomOption{
		String OptionName;
		String RoomTag; 
	}
	
	public Room(){
		
		Descriptions = new ArrayList <String>();
		
		//insert standard options to be displayed for every room
		
		Options.put('r', new RoomOption());
		Options.get('r').OptionName = "Restart the game";
		
		//quit the game
		Options.put('q', new RoomOption()); 
		Options.get('q').OptionName = "Quit the game";
		
		//print information about the game
		Options.put('y', new RoomOption()); 
		Options.get('y').OptionName = "Print information about the game";
		
		//TO-DO undo last action
		Options.put('z', new RoomOption()); 
		Options.get('z').OptionName = "Undo last step";

	}
	
	
	
	public String getValue(){
		return Name;
	}
	
	
	public void PrintOptions(){
		for (char c:actionkeys){
			if(Options.get(c) != null){
			System.out.print("\n"+c+"-"+ Options.get(c).OptionName);
			}
		}
	}
	
	public void PrintInfo(){
		
			System.out.print("Room:"+Name+ "\n");
			for (int i=0; i<Descriptions.size(); i++){
				System.out.print("Description: "+ Descriptions.get(i)+ "\n");
			}
	}
	
	public void AddOption(String name){
			if (lastkey<=SIZE){
				RoomOption tmpOption = new RoomOption();
				tmpOption.OptionName = name;
				Options.put(actionkeys[lastkey], tmpOption);
				lastkey++;
			}
			else{ 
				System.out.print ("no more options available for room "+ this.Name);
			}
			return;
	}
		
	public void AddTag(String tagname){
		Options.get(actionkeys[lastkey-1]).RoomTag = tagname;
		return;
		
		
	}
	
	public void AddDescription(String name){
		
		Descriptions.add(name);
		return;
	
}
	
		
}