
public class Inventory {
	private static int maxSize;
	
	private static int[][] inventory;
	
	public static void init() {
		maxSize = ItemDictionary.itemDictionary.length;
		inventory = new int[2][maxSize];
	}
	
	public static int quantityAtIndex(int i) {
		return inventory[1][i];
	}
	
	public static Item itemAtIndex(int i) {
		return ItemDictionary.findItem(inventory[0][i]);
	}
	
	
	//TODO: fix addItem();
	public static int addItem(int id, int quantity) {
		for (int i = 0; i < maxSize; i++) {
			if(inventory[0][i] == id) {
				inventory[1][i] += quantity;
				return 2;
			}
		}
		
		for (int i = 0; i < maxSize; i++) {
			if(inventory[0][i] == 0 && ItemDictionary.findItem(id).id != -1) {
				inventory[0][i] = id;
				inventory[1][i] += quantity;
				return 1;
			}
		}
		
		return 0;
	}
	
	public static int addItem(int id) {
		for (int i = 0; i < maxSize; i++) {
			if(inventory[0][i] == id) {
				inventory[1][i] += 1;
				return 2;
			}
		}
		
		for (int i = 0; i < maxSize; i++) {
			if(inventory[0][i] == 0 && ItemDictionary.findItem(id).id != -1) {
				inventory[0][i] = id;
				inventory[1][i] += 1;
				return 1;
			}
		}
		
		return 0;
	}
	
	public static int addItem(String name, int quantity) {
		for (int i = 0; i < maxSize; i++) {
			if(inventory[0][i] == ItemDictionary.findItem(name).id) {
				inventory[1][i] += quantity;
				return 2;
			}
		}
		
		for (int i = 0; i < maxSize; i++) {
			if(inventory[0][i] == 0 && ItemDictionary.findItem(name).id != -1) {
				inventory[0][i] = ItemDictionary.findItem(name).id;
				inventory[1][i] += quantity;
				return 1;
			}
		}
		
		return 0;
	}
	
	public static int addItem(String name) {
		for (int i = 0; i < maxSize; i++) {
			if(inventory[0][i] == ItemDictionary.findItem(name).id) {
				inventory[1][i] += 1;
				return 2;
			}
		}
		
		for (int i = 0; i < maxSize; i++) {
			if(inventory[0][i] == 0 && ItemDictionary.findItem(name).id != -1) {
				inventory[0][i] = ItemDictionary.findItem(name).id;
				inventory[1][i] += 1;
				return 1;
			}
		}
		
		return 0;
	}
	
	public static void update() {
		for (int i = 0; i < maxSize; i++) {
			if(inventory[1][i] == 0) {
				inventory[0][i] = 0;
			}
		}
	}
	
	public static void printInventory() {
		for (int i = 0; i < maxSize; i++) {
			if(inventory[0][i] > 0) {
				System.out.println(ItemDictionary.findItem(inventory[0][i]).toString() + ": " + quantityAtIndex(i));
			}
		}
	}
}
