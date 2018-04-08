import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;




/***********************************************************************************
 *
 * WARNING: ALL THE METHODS IS BASED IN THE POSITION OF THE LIST NOT IN THE INDEX
 * 
 ***********************************************************************************/

public class List {
	private Node head = null;
	
	// Tell us if the list is empty
	public boolean emptyList(){
		return (head!=null) ? false : true;
	}
	
	// return the size of he list as a integer
	public int sizeList()
	{
		int size = 1;
		if(emptyList())
			return 0;
		else
		{
			Node temp = head;
			while(temp.ptr != null)
			{
				temp = temp.ptr;
				size++;
			}				
			return size;
		}
	}
	
	// Let print all nodes in the List using Buffered
	public void printList() throws IOException
	{
		if(this.emptyList())
			System.out.println("The list is empty");
		else
		{
			Node temp = head;
			BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
			
			while(temp != null)
			{
				br.write(temp.toString());
				temp = temp.ptr;
			} 
			br.flush();
			//br.close();
		}
		
	}

	
	
	// add at end of the list the new node get as parameter. Also check if the list is Empty 
	public void addEnd(Node n)
	{
		if(emptyList())
			head = n;
		else
		{
			Node temp = head;
			while(temp.ptr != null)		
				temp = temp.ptr;
			temp.ptr = n;
			n.ptr = null;
		}				
	}
	
	//add at begin of the list the new node get as parameter.
	public void addBegin(Node n)
	{
		if(emptyList())
			head = n;
		else
		{
			Node temp = head;
			head = n;
			n.ptr = temp;
		}
	}

	//add at any position of the list the new node get as parameter.  
	public void addAnyPosition(Node n, int position)
	{				
		if(this.emptyList())
			head = n;
		else if(position>sizeList()+1)		
			System.out.println("The position exceed the size of the list");
		else if(position == 1 )
			this.addBegin(n);		
		else
		{
			Node temp = head;
			
			for(int i=0; i<position-2; i++)
				temp = temp.ptr;
			n.ptr = temp.ptr;
			temp.ptr = n;
		}			
	}

	
	
	//delete head node
	public void deleteBeginList()
	{
		@SuppressWarnings("unused")
		Node temp = head;
		head = head.ptr;
		temp = null;
		System.gc();		
	}

	//delete tail node
	public void deleteEndList(){
		Node temp = head;
		while(temp.ptr.ptr != null)
			temp = temp.ptr;		
		temp.ptr = null;		
		System.gc();
	}

	//delete the node got for parameter
	public void deleteAnyPosition(int position)
	{
		if(position == 1)
			this.deleteBeginList();		
		else if(position == this.sizeList())
			this.deleteEndList();
		else if(position>this.sizeList())
			System.out.println("The position of item to delete is superior to size list");
		else{
			Node temp = head, garbage;
			for(int i=1; i<position-1; i++)
				temp = temp.ptr;
			garbage = temp.ptr;
			temp.ptr = temp.ptr.ptr;
			garbage.ptr = null;
			System.gc();
		}
		
	}


	
	//print if the data value exist or not  
	public void existDataNodeList(int data) throws IOException
	{
		if(this.emptyList())
			System.out.println("The list is empty");
		else
		{
			Node temp = head;
			int position = 1;
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			while(temp.data != data && temp.ptr != null)
			{
				temp = temp.ptr;
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
	public int searchDataNodeList(int data)
	{
		if(this.emptyList())
			return 0;
		else
		{
			Node temp = head;
			int position = 1;			
			while(temp.data != data && temp.ptr != null)
			{
				temp = temp.ptr;
				position++;
			}
			
			if(temp.data == data)
				return position;			
			else 
				return 0;				
		}
	}
	
}
