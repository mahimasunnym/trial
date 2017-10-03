
public class HashTable {
	//Storage array
	public Data[] table;
	//Current size of storage
	public int size;
	//Size of storage
	public final int SIZE = 10;
	//No of data in the storage
	int table_elements;

	
	public HashTable(){
		//initializing the storage to the defined size
		table = new Data[SIZE];
		//Setting the current size to the storage size
		size = SIZE;
		//Initializing the no of elements in the storage to 0
		table_elements = 0;
	}

	// Private Method : Hashing function of the hash table. Generates the location of the data in the storage for a given key
	private int hashingFunction(int key){
		return key % size;	
	}

	//Public Method : insert a new data to the storage 
	public boolean add(int key, String value) {
		//If the data for this key exist return from beginning itself.
		if (this.isExist(key) != -1) {
			System.out.println(key +" is duplicate entry");
			return false;
		}
		int index = this.hashingFunction(key);
		if(table_elements < size){
			if (table[index] == null) {
				table[index] = new Data(key, value);
				table_elements++;
			} else {
					while (index < size) {
						if (table[index] == null) {
							table[index] = new Data(key, value);
							table_elements++;
							break;
						}
						index++;
						if(index >= size){
							index = 0;
						}
					}
			}
		} else {
			rehashArray();
			int new_index = this.hashingFunction(key);
			if(table[index] == null){
				table[index] = new Data (key, value);
				table_elements ++;
				return true;
			} 
			while (index < size) {
				if (table[index] == null) {
					table[index] = new Data(key, value);
					table_elements ++;
					break;
				}
				index++;
				if(index >= size){
					index = 0;
				}
			}
		}
		System.out.println(table_elements);

		return true;
	}
	
	//Public Method : Update an existing data value
	public boolean update(int key, String value) {
		int index = this.hashingFunction(key);
		if (table[index] != null) {
			if (this.isExist(key) != -1) {
				table[this.isExist(key)].addValue(value);
				return true;
			}
		}
		return false;
	}

	//Public Method : Remove the data from the storage for a given key
	//do lazy deletion
	public boolean remove(int key) {
		int index = this.hashingFunction(key);
		if (table[index] != null) {
			if (this.isExist(key) != -1) {
				table[this.isExist(key)] = null;
				table_elements--;
				return true;
			}
		}
		return false;
	}

	//Public Method : Return the full storage data in string format
	public String toString() {
		String s = "";
			for (int i = 0; i < size; i++) {
				if (table[i] != null) {
					int key = table[i].getKey();
					String value = table[i].getValue();
					s = s +"Index : " + i + "     Key :" + key + '\t' + "   Value :" + value + '\n';
				}
			}
		return s;
	}
	
	//Public Method : check if a data exist in the storage for a given key 
	public int isExist(int key) {
		int index = this.hashingFunction(key);
		int i = index;
		while (i < size && table[i] != null) {
			if (table[i].getKey() == key) {
				return i;
			}
			i++;
		}
		for(int j = 0; i < index && table[j] != null; i ++){
			if (table[j].getKey() == key) {
			return j;
			}
		}
		return -1;
	}
	
	private boolean isPrime(int number){
		if(number % 2 == 0){
			return false;
		} else {
			for(int i = 3; i < number ; i += 2){
				if(number % i == 0){
					return false;
				} 			
			}
		}
		return true;
	}
	
	private void findNextSize(){
		int i = 1;
		size = 2 * size;
		//finding a prime number close to double the size
		while(!this.isPrime(size+i)){
			i++;
		}
		size += i;
	}
	
	//In case the array becomes full, rehashing is done and all the elements in smaller array are copied
	//to the bigger array
	private void rehashArray(){
		int prev_size = size;
		findNextSize();
		System.out.println(size+ " size");
		Data[] old_table = table;
		table = new Data[size];
		int key_temp;
		String value_temp;
		for(int i = 0; i < prev_size ; i ++){
			key_temp = old_table[i].getKey();
			value_temp = old_table[i].getValue();
//			new_index = this.hashingFunction(key_temp);
//			System.out.println(new_index+ "   " + i);
//			if()
//			table[new_index] = new Data(key_temp, value_temp);
			this.add(key_temp, value_temp);
		}
	}
}
