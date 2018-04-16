
public class Node {
	public int id;//it's unique
	public int data;
	public String text;
	public Node ptr;
	
	//CONSTRUCTORS 
	public Node (){}
	
	public Node (int data)
	{
		this.data = data;
	}
	
	// NICE VIEW DATA
	public String toString()
	{
		return "Data: " + data + "\n";
	}
	
	public Node clone() 
	{
		Node temp = new Node(this.data);
		return temp;
	}
	
	
}
