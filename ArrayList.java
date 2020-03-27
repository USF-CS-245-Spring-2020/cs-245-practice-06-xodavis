import java.util.Arrays;

public class ArrayList<T>  implements List<T>{

	protected int size;
	private T[] array;

	public ArrayList(){
		array = (T[]) new Object[10];
		size = 0;
	}

	public void add(T item){
		if(size == array.length){
			double_array();
		}
		array[size++] = item;
	}

	public void add(int pos, T data)throws ArrayIndexOutOfBoundsException{
		if(pos < 0 || pos > size)
			throw new ArrayIndexOutOfBoundsException("Please choose a valid position.");
		if(size == array.length){
			double_array();
		}
		size++;
		// for(int i = size; i > pos; i--){
		// 	array[i] = array[i - 1];
		// }
		array[pos] = data;
	}

	public T get(int pos) throws ArrayIndexOutOfBoundsException{
		if(pos < 0 || pos > size)
			throw new ArrayIndexOutOfBoundsException("Please choose a valid position.");
		return array[pos];
	}

	public T remove(int pos)throws ArrayIndexOutOfBoundsException{
		if(pos < 0 || pos > size)
			throw new ArrayIndexOutOfBoundsException("Please choose a valid position.");
		T temp = array[pos];
		size--;
		for(int i = pos; i < array.length - 1; i++){
			array[i] = array[i + 1];
		}
		return temp;
	}

	public int size(){
		return size;
	}

	public void double_array(){
		array = Arrays.copyOfRange(array, 0, array.length*2);
		// T[] new_array = (T[]) new Object[array.length];
		// for(int i = 0; i < array.length; i++){
		// 	new_array[i] = array[i];
		// array = new_array; 
		// }
	}
}