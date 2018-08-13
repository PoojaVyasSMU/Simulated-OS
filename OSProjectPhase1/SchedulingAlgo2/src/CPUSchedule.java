
public class CPUSchedule {
	public static int i,j;
	public static int n=PCB.ready.size();
	public static int [] at=new int [n];
	public static int []bt=new int [n]; //n
	public static int [] prior=new int[n];
	public static int [] p=new int[n];
	public static int [] rt=new int[n];
	public static int [] tt=new int[n];
	public static int [] wt=new int[n];
	
	
	public static void assignValue()
	{
		
		for(int i=0;i<n;i++)
		{
			at[i]= PCB.ready.get(i).arrival_time;
			bt[i]=PCB.ready.get(i).burst_time;
			p[i]=PCB.ready.get(i).pid;
			prior[i]=PCB.ready.get(i).priority;
			rt[i]=bt[i];
			
		}
	}
	public static void SortAsc()
	{
		int n=PCB.ready.size();
		int temp=0;
		assignValue();
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				
				if(at[i]>at[j])
				{
					temp=at[i];
					at[i]=at[j];
					at[j]=temp;
					temp=bt[i];
					bt[i]=bt[j];
					bt[j]=temp;
					temp=p[i];
					p[i]=p[j];
					p[j]=temp;
				}
			}
			
		}
	}
	public static  void FirstComeFirstServe()
	{
		int timeavg=0, tsum=0;
		int waitsum=0,waitavg,tat=0,sum=0;
		assignValue();
		
		SortAsc();
			
		wt[0]=0;
		for(i=1;i<n;i++)
		{
		sum=sum+bt[i-1]; 
		wt[i]=sum-at[i];
		waitsum=waitsum+wt[i];
		}
		 
		waitavg=(waitsum/n);
		for(i=0;i<n;i++)
		{
		tat=tat+bt[i];
		tt[i]=tat-at[i];
		tsum=tsum+tt[i];
		}
		 
		timeavg=(tsum/n);
		int [] st=new int[n];
		int [] et=new int[n];
		st[0]=0;
		et[0]=bt[0];
		for(i=1;i<n;i++)
		{
			st[i]=et[i-1];
			et[i]=et[i-1]+bt[i];
			
		}
				
		System.out.println("FCFS Scheduling Output: ");
		for(i=0;i<n;i++)
		{
		System.out.println("Process " + p[i] + " Start time: " + st[i] + " End time " + et[i] + " Wait time: " + wt[i]+ " Turnaround time: "+ tt[i]);
					
		}
		System.out.println("Average Wait time: " + waitavg);
		System.out.println("Average turnaround time: " + timeavg);
		System.out.println("");
						
	}
	


//SJF

	public static void shortestJobFirst()
	{
		//display space and change variables
		int i,j;
		int [] st=new int[n];
		int [] et=new int[n];
		
		int timeavg=0, tsum=0;
		int waitsum=0,waitavg,tat=0,sum=0;
		int temp=0;
		assignValue();
		SortAsc();
		
		for(i=1;i<n;i++)
		{
			for(j=i+1;j<n;j++)
			{
				
				if(bt[i]>bt[j])
				{
					temp=at[i];
					at[i]=at[j];
					at[j]=temp;
					temp=bt[i];
					bt[i]=bt[j];
					bt[j]=temp;
					temp=p[i];
					p[i]=p[j];
					p[j]=temp;
				}
			}
			
		}
		
		
		wt[0]=0;
		for(i=1;i<n;i++)
		{
		sum=sum+bt[i-1];
		wt[i]=sum-at[i];
		waitsum=waitsum+wt[i];
		}
		waitavg=(waitsum/n);
		for(i=0;i<n;i++)
		{
		tat=tat+bt[i];
		tt[i]=tat-at[i];
		tsum=tsum+tt[i];
		}
		timeavg=(tsum/n);
		
		//start time and end time
		st[0]=0;
		et[0]=bt[0];
		for(i=1;i<n;i++)
		{
			st[i]=et[i-1];
			et[i]=et[i-1]+bt[i];
			
		}
		System.out.println("SJF Scheduling Output: ");
		for(i=0;i<n;i++)
		{
			System.out.println("Process " + p[i] + " Start time: " + st[i] + " End time " + et[i] + " Wait time: " + wt[i]+ " Turnaround time: "+ tt[i]);
				
		}
		System.out.println("Average Wait time: " + waitavg);
		System.out.println("Average turnaround time: " + timeavg);
		System.out.println("");
		
		}

	public static void NPpriority()
	{
	int i,j;
	int [] st=new int[n];
	int [] et=new int[n];
	int temp=0;
	int timeavg=0, tsum=0;
	int waitsum=0,waitavg,tat=0,sum=0;
	assignValue();	
	for(i=0;i<n;i++)
	{
		for(j=i+1;j<n;j++)
		{
			//assuming lower number, higher priority
			if(prior[i]==prior[j])
			{
				if(at[j]<at[i])
				{
					temp=prior[i];
					prior[i]=prior[j];
					prior[j]=temp;
					
					temp=at[i];
					at[i]=at[j];
					at[j]=temp;
					temp=bt[i];
					bt[i]=bt[j];
					bt[j]=temp;
					temp=p[i];
					p[i]=p[j];
					p[j]=temp;
				}
			}
			else
			{
			
			if(prior[i]>prior[j])
			{
				
				temp=prior[i];
				prior[i]=prior[j];
				prior[j]=temp;
				
				temp=at[i];
				at[i]=at[j];
				at[j]=temp;
				temp=bt[i];
				bt[i]=bt[j];
				bt[j]=temp;
				temp=p[i];
				p[i]=p[j];
				p[j]=temp;
			}
		}
		}
	}
	wt[0]=0;
	for(i=1;i<n;i++)
	{
	sum=sum+bt[i-1];
	wt[i]=sum-at[i];

	waitsum=waitsum+wt[i];
	}
	 
	waitavg=(waitsum/n);
	for(i=0;i<n;i++)
	{
	tat=tat+bt[i];
	tt[i]=tat-at[i];
	tsum=tsum+tt[i];
	}
	 
	timeavg=(tsum/n);
	st[0]=0;
	et[0]=bt[0];
	for(i=1;i<n;i++)
	{
		st[i]=et[i-1];
		et[i]=et[i-1]+bt[i];
		
	}
	
	System.out.println("Non preemptive priority Scheduling Output: ");
	
	for(i=0;i<n;i++)
	{
	System.out.println("Process " + p[i] + " Start time: " + st[i] + " End time " + et[i]+ " Wait time: " + wt[i]+ " Turnaround time: "+ tt[i]);
			
	}
	System.out.println("Average Wait time: " + waitavg);
	System.out.println("Average turnaround time: " + timeavg);
	System.out.println("");
	}
	
	public static void rr2()
	{
		  int i,time,left,flag=0;
		  int wait_time=0,turnaround_time=0;
		  int [] rt=new int[n]; 
		  int [] st=new int[n]; 
		  left=n;
		  int Q=4;
		  
		  assignValue();
		  SortAsc();
		  for(i=0;i<n;i++)
		  {
			  rt[i]=bt[i];
		  }
		  System.out.println("Roud Robin Scheduling Output: ");
		  System.out.println("Processes arranged as per the order of completion: ");
	
		  for(time=0,i=0;left != 0;)
		  {
			  if(rt[i]<=Q && rt[i]>0)
			  {
				  time+=rt[i]; 
			      rt[i]=0; 
			      flag=1;
			  }
			  else
			  {
				  if(rt[i]>0)
				  {
					  rt[i]-= Q; 
				      time+=Q; 
				  }
			  }
			  if(rt[i]==0 && flag==1)
			  {
				  left--;
				  System.out.println("Process: " + p[i] + " Turaround time: " + (time-at[i]) + " Wait time: " + (time-at[i]-bt[i]));
				  wait_time+=time-at[i]-bt[i]; 
			      turnaround_time+=time-at[i];
				      flag=0; 
			  }
			  if(i==n-1) 
			      i=0; 
			    else 
			    	{
			    	if(at[i+1]<=time) 
			    		i++; 
			    	else 
					      i=0; 
			    	}			  
		  }
		  for(i=1;i<n;i++)
		  {
			  st[i]=st[i-1]+Q;
		  }
		  System.out.println("Average wait time "+ wait_time/n);
		  System.out.println("Average Turnaround time "+ turnaround_time/n);
		  System.out.println(" ");
		}
}



