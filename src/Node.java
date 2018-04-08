
public class Node {
	public int data;
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
	
	
}
