public class Relationships
{
	public static void main(String[] args)
	{
		go(args[0]);	
	}

	public static void go(String args)
	{
		Lists lists = new Lists();
		lists.fillLists(args);
		//lists.printLists();

		Pair pair = new Pair(lists.getMlist().length);
		pair.match(lists.getMlist(), lists.getFlist());
		pair.printPairs(lists.getMnames(), lists.getFnames());
	}
}