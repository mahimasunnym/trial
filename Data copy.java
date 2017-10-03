//package trial_hw3;

public class Data {
	private int key;
	private String value;
	
	public Data(int key){
		this(key, null);
	}
	public Data(int key, String value){
		this.key = key;
		this.value = value;
	}
	public int getKey(){
		return this.key;
	}
	public String getValue(){
		return this.value;
	}

	public void remove(int key){
		this.key = 0;
		this.value = null;		
	}

	public void addValue(String value){
		this.value = value;
	}
	public void insertKeyValue(int key, String value){
		this.key = key;
		this.value = value;
	}
	
}
