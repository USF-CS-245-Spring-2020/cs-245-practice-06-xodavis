public class LinkedList<T> implements List<T>{ //the CS tutros taught me how to cast, so all of the casting done in this class ws thanks to them

	static class Node<T>{
		T data;
		Node next;

		Node(T d){
			next = null;
			data = d;
		}
	}

	public Node<T> head;
	public int size;

	public LinkedList(){
		size = 0;
		this.head = null;
		
	}

	//@Override
	public T get(int pos){
		if(pos < 0 || pos >= size)
			System.out.println("Please choose a valid position.");
		Node node = head;
		for(int i = 0; i < pos; i++){
			node = node.next;
		}
		return (T) node.data;
	}

	public int size(){
		return size;
	}
	//@Override
	public T remove(int pos){
		if(pos < 0 || pos >= size)
			System.out.println("Please choose a valid position.");
		if(pos == 0){
			Node curr = head;
			head = head.next;
			--size;
			return (T)curr.data;
		}
		else{
			Node prev = head;
			for(int i = 0; i < pos - 1; i++){
				prev = prev.next;
			}
			Node curr = prev.next;
			prev.next = curr.next;
			--size;
			return (T)curr.data;
		}
	}

	public void add(T item){
		if(head == null){
			Node curr = new Node(item);
			head = curr;
			++size;
		}
		else{
			Node prev = head;
			for(int i = 0; i < size - 1; i++){
				prev = prev.next;
			}
			Node curr = new Node(item);
			prev.next = curr;
			++size;
		}
	}

	public void add(int pos, T item){
		if(pos == 0){
			Node curr = new Node(item);
			curr.next = head;
			head = curr;
			size++;
		}
		else{
			Node prev = head;
			for(int i = 0; i < pos - 1; i++){
				prev = prev.next;
			}
			Node curr = new Node(item);
			curr.next = prev.next;
			prev.next = curr;
			++size;
		}
	}
}