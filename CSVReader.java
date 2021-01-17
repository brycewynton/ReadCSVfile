import java.util.*;
import java.io.*;
import java.lang.*;

class SQLinput
{
	private int amount;
	private String date;
	private String title;
	private int score;
	private float ratio;
	private int zip;
	private String state;
	private int length;
	private int code;

	public SQLinput(int _amount, String _date, String _title, int _score, float _ratio, int _zip, String _state, int _length, int _code)
	{
		super();
		_amount = amount;
		_date = date;
		_title = title;
		_score = score;
		_ratio = ratio;
		_zip = zip;
		_state = state;
		_length = length;
		_code = code;
	}

	public int getAmount()
	{
		return amount;
	}

	public void setAmount(int _amount)
	{
		_amount = amount;
	}

	public String getDate()
	{
		return date;
	}
	public void setDate(String _date)
	{
		_date = date;
	}

	public String getTitle()
	{
		return title;
	}
	public void setTitle(String _title)
	{
		_title = title;
	}

	public int getScore()
	{
		return score;
	}
	public void setScore(int _score)
	{
		_score = score;
	}

	public float getRatio()
	{
		return ratio;
	}
	public void setRatio(float _ratio)
	{
		_ratio = ratio;
	}

	public int getZip()
	{
		return zip;
	}
	public void setZip(int _zip)
	{
		_zip = zip;
	}

	public String getState()
	{
		return state;
	}
	public void setState(String _state)
	{
		_state = state;
	}

	public int getLength()
	{
		return length;
	}
	public void setLength(int _length)
	{
		_length = length;
	}

	public int getCode()
	{
		return code;
	}
	public void setCode(int _code)
	{
		_code = code;
	}

	public String toString()
	{
		return "insert into Loan values (" + amount +", "+ date + ", " + title + ", " + score + ", " + ratio + ", " + zip +", " + state + ", " + length +", " + code + ")";
	}
}

public class CSVReader 
{
	private static final String DELIM = ",";

	public static void main(String args[])
	{
		BufferedReader br = null;

		try
		{
			br = new BufferedReader(new FileReader("/Users/bryce/Downloads/Loan.csv"));

			List<SQLinput> inputList = new ArrayList<SQLinput>();
			
			String line = "";

			br.readLine();

			while ((line = br.readLine()) != null)
			{
				String[] csvArr = line.split(DELIM);

				//System.out.println(Arrays.toString(csvArr));
				
				if (csvArr.length > 0)
				{
					SQLinput sqlInput = new SQLinput(Integer.parseInt(csvArr[0]), csvArr[1], csvArr[2], Integer.parseInt(csvArr[3]), Float.parseFloat(csvArr[4]), Integer.parseInt(csvArr[5]), csvArr[6], Integer.parseInt(csvArr[7]), Integer.parseInt(csvArr[8]));  				
					inputList.add(sqlInput);
					System.out.println("insert into Loan values ( "+ Integer.parseInt(csvArr[0])+", '"+ csvArr[1]+"', '"+ csvArr[2]+"', "+ Integer.parseInt(csvArr[3])+", "+ Float.parseFloat(csvArr[4])+", "+ Integer.parseInt(csvArr[5])+", '"+ csvArr[6]+"', "+ Integer.parseInt(csvArr[7])+", "+ Integer.parseInt(csvArr[8])+");");
				} 
			}
			
			for (SQLinput input: inputList)
			{
				//System.out.println("insert into Loan values ( " + input.getAmount()+", "+input.getDate()+", "+input.getTitle()+", "+input.getScore()+", "+input.getRatio()+", "+input.getZip()+", "+input.getState()+", "+input.getLength()+", "+input.getCode()+");");
			}			
		}catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("\nException error caught in first catch clause\n");
		}
		finally 
		{
			try
			{
				br.close();

			} catch (IOException ioe)
			{	
				System.out.println("Error caught while closing the BufferedReader\n");
				ioe.printStackTrace();
			}
		}
	}
}
