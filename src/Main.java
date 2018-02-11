import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		initialise();
		
		start();
		
		close();
	}
	
	private static void initialise() {
		SaveManager.init();
		ItemDictionary.init();
		Inventory.init();
	}
	
	private static void close() {
		SaveManager.close();
	}
	
	private static void start() {
		Scanner scn = new Scanner(System.in);
		boolean on = true;
		
		while(on) {
			String temp = scn.nextLine();
			
			switch(temp) {
				case "exit":
					on = false;
					break;
				case "inventory":
					Inventory.printInventory();
					break;
				case "dictionary":
					ItemDictionary.printDictionary();
					break;
				case "add":
					addItem();
					break;
			}
		}
		
		scn.close();
	}

	@SuppressWarnings("resource")
	private static void addItem() {
		Scanner scn_tmp = new Scanner(System.in);
		System.out.println(Inventory.addItem(scn_tmp.nextInt()));
		//Inventory.update();
	}

}
