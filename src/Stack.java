import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


/***********************************************************************************
*
* WARNING: ALL THE METHODS IS BASED IN THE POSITION OF THE STACK NOT IN THE INDEX
* 
***********************************************************************************/

public class Stack {

	private Node head = null;
	
	//return the head
	public Node getHead()
	{
		return this.head;
	}
	
	// Tell us if the Stack is empty
	public boolean emptyStack(){
		return (head!=null) ? false : true;
	}
	
	// return the size of he Stack as a integer
	public int sizeStack()
	{
		int size = 1;
		if(emptyStack())
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
	
	// Print all nodes in the Stack using Buffered
	public void printStack() throws IOException
	{
		if(this.emptyStack())
		{
			BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
			br.write("The Stack is empty");
			br.flush();
			br.close();
		}			
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

	//add at begin of the Stack the new node get as parameter.
	public void push(Node n)
	{
		if(emptyStack())
			this.head = n;
		else
		{
			n.ptrN = this.getHead();
			head = n;			
		}
	}

	//delete head node of the Stack
	public void pop()
	{
		@SuppressWarnings("unused")
		Node temp = head;
		head = head.ptrN;
		temp = null;
		System.gc();		
	}
	
	//print if the data value exist or not  
	public void existDataNodeStack(int data) throws IOException
	{
		if(this.emptyStack())
			System.out.println("The Stack is empty");
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

	//return 0 if the data value doesn't exist, otherwise, return the position of the value.
	public int searchDataNodeStack(int data)
	{
		if(this.emptyStack())
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
