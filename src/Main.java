import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {	
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue q1 = new Queue();
		q1.addNodeQueue(new Node(4));
		q1.addNodeQueue(new Node(5));
		q1.addNodeQueue(new Node(6));
		//q1.printQueue();
		q1.existDataNodeQueue(5);
		int a  = q1.searchDataNodeQueue(5);
		br.write(Integer.toString(a));
		br.flush();
		
		
		
		
		
		
		

	}

}
