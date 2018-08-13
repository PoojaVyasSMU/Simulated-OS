import java.io.IOException;
import java.util.Scanner;

public class SchedulingAlgo2 {

	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int i=0;
		do
		{
				
		System.out.println("Enter the task to be performed: \n"
				+ "1.Insert in to ready queue\n"
				+ "2.Delete from Ready queue\n"
				+ "3.Insert in to Wait queue\n"
				+ "4.Delete from Wait queue\n"
				+ "5.Display Ready queue\n"
				+ "6.Display Wait queue\n"
				+ "7.Exit\n"
				+ "8.Run scheduling Algorithm\n");
		
		i= sc.nextInt();
			
		
		switch(i)
		{
		case 1: 
		{
			//insert into ready queue
			PCB.insertInReady();
			break;
		}
		case 2:
		{
			// Delete from Ready queue
			int pid;
			System.out.println("Enter the process id to be deleted: ");
			pid=sc.nextInt();
			PCB.deletefromReady(pid);
			break;
		}
		case 3:
		{
			//insert into wait queue
			
				PCB.insertInWait();
				System.out.println("Insertion is Wait queue successful! ");
			
			break;
			
		}
		case 4:
		{
			// delete from wait queue

			int pid;
			System.out.println("Enter the process id to be deleted: ");
			pid=sc.nextInt();
			PCB.deletefromWait(pid);
			break;
		}
		case 5:
		{
			//display ready queue
			System.out.println("Ready queue is as follows: ");
			PCB.displayReady();
			break;
		}
		case 6:
		{
			//Display  wait queue
			System.out.println("Wait queue is as follows: ");
			PCB.displayWait();
			break;
		}
		case 7:
		{
			System.out.println("Exiting..! ");
			break;
		}
		case 8:
		{
			System.out.println("Running Scheduling Algorithms:");
			CPUSchedule.shortestJobFirst();
			CPUSchedule.FirstComeFirstServe();
			CPUSchedule.NPpriority();
			CPUSchedule.rr2();
			
		}
		default: System.out.println(" ");
		} 
		
	}while(i!=7);
}
		
}	

