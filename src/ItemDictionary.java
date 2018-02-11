
public class ItemDictionary {
	public static Item[] itemDictionary;
	
	public static void init() {
		SaveManager.populateDictionary();
	}
	
	public static void printDictionary() {
		for(int i = 0; i < itemDictionary.length; i++) {
			System.out.println(itemDictionary[i].name + ": " + itemDictionary[i].id);
		}
	}
	
	public static Item findItem(int id) {
		for(int i = 0; i < itemDictionary.length; i++) {
			if(itemDictionary[i].id == id) {
				return itemDictionary[i];
			}
		}
		return new Item();
	}
	
	public static Item findItem(String name) {
		for(int i = 0; i < itemDictionary.length; i++) {
			if(itemDictionary[i].name.equals(name)) {
				return itemDictionary[i];
			}
		}
		return new Item();
	}
}
