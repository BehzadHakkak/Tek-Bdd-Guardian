package tek.bdd.guardians.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;

public class ReadYamlFiles {
	
	private static ReadYamlFiles readYamlFiles;
	private HashMap propertyType;
	
	//constructor: we create to load our yml file
	private ReadYamlFiles(String filePath) throws FileNotFoundException {
		FileInputStream fileInputStream = FileUtility.getFileInputStream(filePath);
		Yaml yaml = new Yaml();
		this.propertyType = yaml.load(fileInputStream);
	}
	
	//This method will return an instance of ReadYamlFiles class
	public static ReadYamlFiles getInstance(String filePath) throws FileNotFoundException {
		if(readYamlFiles == null)
			return new ReadYamlFiles(filePath);
		return readYamlFiles;
	}
	//we get the property from the Yaml file and store it in a hashmap so that when we call this method
	//(getYamlProperty) we can pass the key and the method return the value for us
	public HashMap getYamlProperty(String key) {
		return (HashMap) this.propertyType.get(key);
	}
	
}
