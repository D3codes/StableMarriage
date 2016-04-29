import java.util.*;

public class Pair
{
	private int[] pairs;
	private int[] f_counter;

	public Pair(int size)
	{
		pairs = new int[size];
		f_counter = new int[size];

		for(int i = 0; i < pairs.length; i++)
		{
			pairs[i] = -1;
			f_counter[i] = 0;
		}
	}

	public void match(int[][] m_list, int[][] f_list)
	{
		while(check())
		{
			for(int j = 0; j < pairs.length; j++)
			{
				if(notInPairs(j))
				{
					if(compare(j, f_list[j][f_counter[j]], m_list))
					{
						pairs[f_list[j][f_counter[j]]] = j;
					}
					f_counter[j]++;
				}

			}
		}
	}

	private boolean notInPairs(int female)
	{
		for(int i = 0; i < pairs.length; i++)
		{
			if(pairs[i] == female)
			{
				return false;
			}
		}

		return true;
	}

	private boolean check()
	{
		for(int i = 0; i < pairs.length; i++)
		{
			if(pairs[i] == -1)
			{
				return true;
			}
		}

		return false;
	}

	private boolean compare(int female, int male, int[][] m_list)
	{
		if(female == m_list[male][0])
		{
			return true;
		}

		if(pairs[male] == -1)
		{
			return true;
		}

		for(int i = 0; i < m_list[male].length; i++)
		{
			if(m_list[male][i] == pairs[male])
			{
				return false;
			}

			if(m_list[male][i] == female)
			{
				return true;
			}
		}

		return false;
	}

	public void printPairs(ArrayList m_names, ArrayList f_names)
	{
		InOut io = new InOut();
		for(int i = 0; i < pairs.length; i++)
		{
			io.printLine(m_names.get(i) + " and " + f_names.get(pairs[i]));
		}
	}
}