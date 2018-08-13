import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class addm
{
	int startadd,availspace;
	public addm(int startadd, int availspace)
	{
		this.startadd=startadd;
		this.availspace=availspace;
	}
	
}
public class memoryMam 
{
	public static void main(String args[])throws IOException
	{
		Scanner filescan = new Scanner(new File("input.txt"));
		int pid=0; int arrival_time=0; int burst_time=0;int memory=0;
		 String data;
		
		 int memsize = 0, availsize=0,startadd=0,availspace=0,count=0;
		 int i=0;
		 while( filescan.hasNextLine() )
		 { 
			 data = filescan.nextLine();
			 String[] proc = data.split(" ");
			 if(i==0)
			 {
				 memsize= Integer.parseInt(proc[0]);
				 i++;
			 }
			 data = filescan.nextLine();
			 String[] proc1 = data.split(" ");
	         if(i==1)
	         {
	        	 availsize=Integer.parseInt(proc1[0]);
	        	 i++;
	         }
	         for(i=2;i<availsize+2;i++)
	         {
	        	 data = filescan.nextLine();
		         String[] proc2 = data.split(" ");
	        	 startadd=Integer.parseInt(proc2[0]);
		         availspace=Integer.parseInt(proc2[1]);
		        
		         addm list1=new addm(startadd,availspace);
		         MemoryAlgo.addressspace.add(list1);
	         }
	       
	         if(i==availsize+2)
	         {
	        	 data = filescan.nextLine();
		         String[] proc2 = data.split(" ");
	        	 count=Integer.parseInt(proc2[0]);
	        	 i++;
	         }
	         
	         while(count!=0)//8 and 14
	         {
	        	 data = filescan.nextLine();
		         String[] proc2 = data.split(" ");
	        	 pid = Integer.parseInt(proc2[0]);
		         arrival_time= Integer.parseInt(proc2[1]);
		         burst_time= Integer.parseInt(proc2[2]);
		         memory=Integer.parseInt(proc2[3]);
		         input list = new input(pid, arrival_time,  burst_time, memory);
		         MemoryAlgo.process.add(list);
		         count--;
	         }
	           
	}
		 System.out.println("First fit algorithm: ");
		 MemoryAlgo.firstfit(memsize);
		 System.out.println(" ");
		 System.out.println("Best fit algorithm: ");
		 MemoryAlgo.bestfit(memsize);
		 System.out.println(" ");
		 System.out.println("Worst fit algorithm: ");
		 MemoryAlgo.worstfit(memsize);
}
}
