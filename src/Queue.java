import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/***********************************************************************************
* 
*WARNING: ALL THE METHODS IS BASED IN THE POSITION OF THE QUEUE NOT IN THE INDEX
* 
***********************************************************************************/

public class Queue {
	private Node head = null;
		
	public Node getHead()
	{
		return this.head;
	}
	
	// Tell us if the Queue is empty
	public boolean emptyQueue(){
		return (this.head!=null) ? false : true;
	}
	
	// return the size of he Queue as a integer
	public int sizeQueue()
	{
		int size = 1;
		if(emptyQueue())
			return 0;
		else
		{
			Node temp = head;
			while(temp.ptrN != null)
			{
				temp = temp.ptrN;
				size++;
			}				
			return size;
		}
	}
	
	// Let print all nodes in the Queue using Buffered
	public void printQueue() throws IOException
	{
		if(this.emptyQueue())
			System.out.println("The list is empty");
		else
		{
			Node temp = head;
			BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
			
			while(temp != null)
			{
				br.write(temp.toString());
				temp = temp.ptrN;
			} 
			br.flush();
			//br.close();
		}
		
	}

	
	
	// add to Queue the new node get as parameter, according with FIFO 
	public void enqueue(Node n)
	{
		if(emptyQueue())
			this.head = n;
		else
		{
			Node temp = head;
			while(temp.ptrN != null)		
				temp = temp.ptrN;
			temp.ptrN = n;
			n.ptrN = null;
		}				
	}
	
	//delete the head of Queue according with FIFO
	public void dequeue(){
		Node temp = getHead();
		this.head = getHead().ptrN;				
		temp.ptrN = null;		
		System.gc();
	}

	//print if the data value exist or not  
	public void existDataNodeQueue(int data) throws IOException
	{
		if(this.emptyQueue())
			System.out.println("The Queue is empty");
		else
		{
			Node temp = head;
			int position = 1;
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			while(temp.data != data && temp.ptrN != null)
			{
				temp = temp.ptrN;
				position++;
			}			
			if(temp.data == data)	
			{
				bw.write("The value " +"\"" +data+ "\"" + " exist and it's in the position: "+position + "\n");
				bw.flush();
				//bw.close();				
			}				
			else
			{
				bw.write("The value doesn't exist!");
				bw.flush();
				//bw.close();				
			}				
		}		
	}

	//return 0 if the data value doesn't exist, otherwise, return the position of the value.
	public int searchDataNodeQueue(int data)
	{
		if(this.emptyQueue())
			return 0;
		else
		{
			Node temp = head;
			int position = 1;			
			while(temp.data != data && temp.ptrN != null)
			{
				temp = temp.ptrN;
				position++;
			}
			
			if(temp.data == data)
				return position;			
			else 
				return 0;				
		}
	}
}
