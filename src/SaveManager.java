import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class SaveManager {
	private static final String PATH = new File("").getAbsolutePath().toString() + "/resources";
	
	static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	static BufferedReader in = null;
//	static PrintWriter out = null;
	
	public static void populateDictionary() {
		ItemDictionary.itemDictionary = gson.fromJson(in.lines().collect(Collectors.joining()), Item[].class);
	}

	public static void init() {
		try {
			in = new BufferedReader(new FileReader(PATH + "/items.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void close() {
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
