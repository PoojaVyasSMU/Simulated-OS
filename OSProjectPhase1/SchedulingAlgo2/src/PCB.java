import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

class input{
	int pid;
	 int arrival_time;
	 int burst_time;
	 int priority;
	 public input(int pid, int arrival_time,int burst_time,int priority)
	 {
		 this.pid=pid;
		 this.arrival_time=arrival_time;
		 this.burst_time=burst_time;
		 this.priority=priority;
						 
	 }
}

public class PCB {
	public static LinkedList<input> ready =new LinkedList<input>();
	public static LinkedList<input> wait =new LinkedList<input>();
	
	public static void insertInReady() throws IOException
	{
		Scanner filescan = new Scanner(new File("Input.txt"));
	      String data;
	      int pid=0; int arrival_time=0; int burst_time=0;int priority=0;
	      

	      while( filescan.hasNextLine() )
	      {
	           data = filescan.nextLine();

	           String[] proc = data.split(" ");
	           pid = Integer.parseInt(proc[0]);
	           arrival_time= Integer.parseInt(proc[1]);
	           burst_time= Integer.parseInt(proc[2]);
	           priority=Integer.parseInt(proc[3]);
	           
	           input list = new input(pid, arrival_time,  burst_time, priority);
				//add 
				ready.add(list);
			}
	      	int i;
			for(i=0;i<ready.size();i++)
			{
				System.out.println("Process: " + (i+1));
				System.out.println("Process id: "+ ready.get(i).pid);
				System.out.println("Arrival time: "+ ready.get(i).arrival_time);
				System.out.println("Burst time: "+ ready.get(i).burst_time);
				System.out.println("Priority: "+ ready.get(i).priority);
			}
     
	      filescan.close();
	      }
	
		

	public static void deletefromReady(int p1) {
	int count=0;
	ListIterator<input> iterate= ready.listIterator();
	while(iterate.hasNext())
	{
		input info=iterate.next();
		
		
		if(info.pid== p1)
		{
			iterate.remove();
			count++;
			System.out.println("Process "+ p1 + " was removed successfully!");
			int i;
			System.out.println("Updates Ready Queue is as follows: ");
			for(i=0;i<ready.size();i++)
			{
				System.out.println("Process: " + (i+1));
				System.out.println("Process id: "+ ready.get(i).pid);
				System.out.println("Arrival time: "+ ready.get(i).arrival_time);
				System.out.println("Burst time: "+ ready.get(i).burst_time);
				System.out.println("Priority: "+ ready.get(i).priority);
			}
		}
		}
		
		if(count == 0)
			System.out.println("No such process id exists!");
			
	}
	
	// display ready queue
	public static void displayReady()
	{
		int i;
		for(i=0;i<ready.size();i++)
		{
			System.out.println("Process: " + (i+1));
			System.out.println("Process id: "+ ready.get(i).pid);
			System.out.println("Arrival time: "+ ready.get(i).arrival_time);
			System.out.println("Burst time: "+ ready.get(i).burst_time);
			System.out.println("Priority: "+ ready.get(i).priority);
		}
		
	}
	
	//display wait queue
	public static void displayWait()
	{
		int i;
		for(i=0;i<wait.size();i++)
		{
			System.out.println("Process: " + (i+1));
			System.out.println("Process id: "+ wait.get(i).pid);
			System.out.println("Arrival time: "+ wait.get(i).arrival_time);
			System.out.println("Burst time: "+ wait.get(i).burst_time);
			System.out.println("Priority: "+ wait.get(i).priority);
		}
	}

	//add to wait queue
	
	public static void insertInWait() throws IOException
	{
		Scanner filescan = new Scanner(new File("Input.txt"));
	      String data;
	      int pid=0; int arrival_time=0; int burst_time=0;int priority=0;
	   

	      while( filescan.hasNextLine() ){
	           data = filescan.nextLine();

	           String[] proc = data.split(" ");
	           pid = Integer.parseInt(proc[0]);
	           arrival_time= Integer.parseInt(proc[1]);
	           burst_time= Integer.parseInt(proc[2]);
	           priority=Integer.parseInt(proc[3]);
	           
	           
	           input list = new input(pid, arrival_time,  burst_time, priority);
				wait.add(list);
				 
	           
	      }
	      
	      int i;
			for(i=0;i<wait.size();i++)
			{
				System.out.println("Process: " + (i+1));
				System.out.println("Process id: "+ wait.get(i).pid);
				System.out.println("Arrival time: "+ wait.get(i).arrival_time);
				System.out.println("Burst time: "+ wait.get(i).burst_time);
				System.out.println("Priority: "+ wait.get(i).priority);
			}
     
	      filescan.close();
	}
	//delete from wait
	
		public static void deletefromWait(int p1) {
			int count=0;
			ListIterator<input> iterate= wait.listIterator();
			while(iterate.hasNext())
			{
				input info=iterate.next();
				
				
				if(info.pid== p1)
				{
					iterate.remove();
					count++;
					System.out.println("Process "+ p1 + " was removed successfully!");
					int i;
					System.out.println("Updates Wait Queue is as follows: ");
					for(i=0;i<wait.size();i++)
					{
						System.out.println("Process: " + (i+1));
						System.out.println("Process id: "+ wait.get(i).pid);
						System.out.println("Arrival time: "+ wait.get(i).arrival_time);
						System.out.println("Burst time: "+ wait.get(i).burst_time);
						System.out.println("Priority: "+ wait.get(i).priority);
					}
				}
				}
				
				if(count == 0)
					System.out.println("No such process id exists!");
			}
}
