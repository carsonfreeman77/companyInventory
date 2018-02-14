import java.io.*;
import java.util.*;

public class accountingModule extends buyerMenu
	{
		public static ArrayList<Item> stock = new ArrayList<Item>();
		public static void main(String[] args)
			{
				fillStock();
				changePrice();
			}
		public static void changePrice() 
			{
			
			System.out.println("What price would you like to change?");
			int count = 1;
			for(int i = 0; i < stock.size(); i++)
				{
					
					System.out.println(count +") " + stock.get(i).getName() + " with a price of $" + stock.get(i).getAmount());
					count++;
				}
			
			Scanner c = new Scanner(System.in);
			System.out.println();
			int choice = c.nextInt();
			
			
			
			
			}
		public static void fillStock()
		{
			String fileName = "StockIndex.txt";
			String line = null;
			FileReader fileReader;
			try
				{
					fileReader = new FileReader(fileName);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					while((line = bufferedReader.readLine()) != null) {
						int x1 = 0;
						int x2 = 0;
						int x3 = 0;
						boolean one = false;
						boolean two = false;
						boolean three = false;
						for(int x=0; x<line.length(); x++)
							{
								if(line.substring(x,x+1).equals(" ") && one == false)
									{
										x1 = x;
										one = true;
									}
								else if(line.substring(x,x+1).equals(" ") && two == false)
									{
										x2 = x;
										two = true;
									}
								else if(line.substring(x,x+1).equals(" ") && three == false)
									{
										x3 = x;
										three = true;
									}
							}
						stock.add(new Item(line.substring(0, x1), line.substring(x1+1, x2), Integer.parseInt(line.substring(x2+1, x3)), Integer.parseInt(line.substring(x3+1))));
					}
		            bufferedReader.close();
				} 
			catch (FileNotFoundException e)
				{
					System.out.println("Can't find the file");
				} catch (IOException e)
				{
					System.out.println("IOException");
					
				}
		}
	}
