import java.util.Arrays;

public class RingBufferDemo {

	public static  void main(String[] args) {
		RingBuffer rb = new RingBuffer(3);
		rb.push(7);
		rb.push(11);
		rb.push(13);
		rb.push(17);
		System.out.println(rb.pop());
		rb.push(23);
		
		System.out.println(rb.pop());
		System.out.println(rb.pop());
		System.out.println(rb.pop());
	}
	
	static class RingBuffer {
		// Total de elementos no RB
		private int size; 
		// Máximo de elementos permitidos no RB 
		private int capacity;
		// Índice usada para recuperar o item no RB
		private int head;
		// Índice usada para inserir um item no RB
		private int tail;
		// Estrutura que contem os itens do RB
		private int[] buffer;
		
		RingBuffer(int capacity) {
			this.capacity = capacity;
			buffer = new int[capacity]; 
			Arrays.fill(buffer, -1);
		}
		
		public void push(int item) {
			if (tail == head && size == capacity) {
				head = calcIndex(head);
			}
			
			buffer[tail] = item;
			tail = calcIndex(tail);
			
			if (size < capacity) {
				size++;
			}
		}
		
		public int pop() {
			if (size == 0) {
				return -1;
			}
			
			int item = buffer[head];
			buffer[head] = -1;
			
			head = calcIndex(head);
			
			size--;
			
			return item;
		}
		
		// Se INDEX for igual a CAPACITY, INDEX receberá 0
		// Se INDEX for menor que CAPACITY, INDEX é incrementado em 1
		private int calcIndex(int index) {
			return (++index) % capacity;
		}
	}
	
	

}
