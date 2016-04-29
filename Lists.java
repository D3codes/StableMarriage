import java.util.*;

public class Lists
{
	private ArrayList<String>  m_names = new ArrayList<String>();
	private ArrayList<String> f_names = new ArrayList<String>();
	private int[][] m_list, f_list;

	public ArrayList getMnames()
	{
		return m_names;
	}

	public ArrayList getFnames()
	{
		return f_names;
	}

	public int[][] getMlist()
	{
		return m_list;
	}

	public int[][] getFlist()
	{
		return f_list;
	}

	public void fillLists(String filename)
	{
		InOut io = new InOut();
		ArrayList<String> file = io.readFile(filename);

		String tmp_line = file.get(1);
		String tmp_name = "";
		for(int i = 0; i < tmp_line.length(); i++)
		{
			if(tmp_line.charAt(i) == ',')
			{
				m_names.add(tmp_name);
				tmp_name = "";
			}
			else
			{
				tmp_name += tmp_line.charAt(i);
			}
		}
		m_names.add(tmp_name);

		tmp_line = file.get(3);
		tmp_name = "";
		for(int i = 0; i < tmp_line.length(); i++)
		{
			if(tmp_line.charAt(i) == ',')
			{
				f_names.add(tmp_name);
				tmp_name = "";
			}
			else
			{
				tmp_name += tmp_line.charAt(i);
			}
		}
		f_names.add(tmp_name);

		createArray(file);
	}

	public void createArray(ArrayList<String> file)
	{
		m_list = new int[m_names.size()][f_names.size()];
		f_list = new int[f_names.size()][m_names.size()];

		for(int i = 5; i < m_names.size()+5; i++)
		{
			String tmp_line = file.get(i);
			int tmp_int = 0;
			int counter = 0;
			for(int j = 0; j < tmp_line.length(); j++)
			{
				if(tmp_line.charAt(j) == ',')
				{
					m_list[i-5][counter] = tmp_int - 1;
					tmp_int = 0;
					counter++;
				}
				else
				{
					if(tmp_int != 0)
					{
						tmp_int = tmp_int * 10 + (int)tmp_line.charAt(j) - 48;
					}
					else
					{
						tmp_int = (int)tmp_line.charAt(j) - 48;
					}
				}
			}
			m_list[i-5][counter] = tmp_int - 1;
		}

		for(int i = 6 + m_list.length; i < f_names.size() + 6 + m_list.length; i++)
		{
			String tmp_line = file.get(i);
			int tmp_int = 0;
			int counter = 0;
			for(int j = 0; j < tmp_line.length(); j++)
			{
				if(tmp_line.charAt(j) == ',')
				{
					f_list[i - (6 + m_list.length)][counter] = tmp_int - 1;
					tmp_int = 0;
					counter++;
				}
				else
				{
					if(tmp_int != 0)
					{
						tmp_int = tmp_int * 10 + (int)tmp_line.charAt(j) - 48;
					}
					else
					{
						tmp_int = (int)tmp_line.charAt(j) - 48;
					}
				}
			}
			f_list[i - (6+m_list.length)][counter] = tmp_int - 1;
		}
	}

	public void printLists()
	{
		InOut io = new InOut();
		
		io.printLine("Males:");
		for(int i = 0; i < m_names.size(); i++)
		{
			System.out.println(m_names.get(i));
		}

		io.printLine("Females:");
		for(int i = 0; i < f_names.size(); i++)
		{
			io.printLine(f_names.get(i));
		}
	
		io.printLine("Male List:");
		for(int i = 0; i < m_list.length; i++)
		{
			for(int j = 0; j < m_list[i].length; j++)
			{
				System.out.print(m_list[i][j] + " ");
			}
			System.out.println();
		}

		io.printLine("Female List:");
		for(int i = 0; i < f_list.length; i++)
		{
			for(int j = 0; j < f_list[i].length; j++)
			{
				System.out.print(f_list[i][j] + " ");
			}
			System.out.println();
		}

	}
}