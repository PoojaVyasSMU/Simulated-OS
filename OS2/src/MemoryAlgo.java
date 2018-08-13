import java.util.LinkedList;

public class MemoryAlgo
{

	public static LinkedList<input> process =new LinkedList<input>();
	public static LinkedList<addm> addressspace =new LinkedList<addm>();
	 //assign variables
	static int [] al=new int[100];
	static int [] bs=new int[100];
	
	public static void assign()
	{
		int i=0;
		int n=addressspace.size();
		for(i=0;i<n;i++)
		{
			al[i]=addressspace.get(i).availspace;
		}
		
	}
	
	public static void firstfit(int ms)
	{
		
		int n=addressspace.size();
		int n1=process.size();
		int i=0,j=0,allocatedmem=0,count=0;
		double memutilization;
		double blockprobab;
		//assign memory space in an array
		assign();
		//first fit
		for(i=0;i<n1;i++)
		{
			for(j=0;j<n;j++)
			{
				if(process.get(i).memory<al[j])
				{
					bs[i]=1;
					//  Process_id, base_starting_address, memory_length_allocated
					System.out.print("Processs ID: " + process.get(i).pid);
					System.out.print("  Base starting address: "+ addressspace.get(j).startadd + " ");// +process.get(i).memory);
					System.out.print("  Memory length allocated: " + process.get(i).memory);
					al[j]=al[j]-process.get(i).memory;
					allocatedmem+=process.get(i).memory;
					System.out.println("  Remaining space after process allocation  "+al[j]);
					break;
				}
			}
			if(bs[i]==0)
			{
				count++;
				System.out.println("Blocked Process: "+process.get(i).pid);
			}
			
		}
		memutilization=((double)allocatedmem/ms)*100;
		blockprobab=((double)count/n1)*100;
		System.out.println("Memory Utilization of a process: "+memutilization + " % ");
		System.out.println("Blocking Probability of a process: "+blockprobab + " % ");
		
	}
	public static void bestfit(int ms)
	{
		int [] al=new int[100];
		int [] bs=new int[100];
		int [] bl=new int[100];
		int n=addressspace.size();
		int n1=process.size();
		int i=0,j=0,allocatedmem=0,count=0,temp=0;
		double memutilization;
		double blockprobab;
		for(i=0;i<n;i++)
		{
			al[i]=addressspace.get(i).availspace;
			bl[i]=addressspace.get(i).startadd;
			
		}
		//sort address space 
		for(i=0;i<n;i++)
		{
			for(j=i;j<n;j++)
			{
				if(al[i]>al[j])
				{
					temp=al[i];
					al[i]=al[j];
					al[j]=temp;
					temp=bl[i];
					bl[i]=bl[j];
					bl[j]=temp;
					
				}
			}
		}
		
		//memory allocation
		for(i=0;i<n1;i++)
		{
			for(j=0;j<n;j++)
			{
				if(process.get(i).memory <= al[j])
				{
					bs[i]=1;
					
					//  Process_id, base_starting_address, memory_length_allocated
					System.out.print("Processs ID: " + process.get(i).pid);
					System.out.print("  Base starting address: "+ bl[j]+ " ");// +process.get(i).memory);
					System.out.print("  Memory length allocated: " + process.get(i).memory+ " ");
					al[j]=al[j]-process.get(i).memory;
					allocatedmem+= process.get(i).memory;
					//bl[j]=bl[j]+process.get(i).memory; //update starting base address
					System.out.println("  Remaining space after process allocation  "+al[j]);
					break;
				}
			}
			if(bs[i]==0)
			{
				count++;
				System.out.println("Blocked Process: "+process.get(i).pid);
			}
			
		}
		memutilization=((double)allocatedmem/ms)*100;
		blockprobab=((double)count/n1)*100;
		System.out.println("Memory Utilization of a process: "+memutilization + " % ");
		System.out.println("Blocking Probability of a process: "+blockprobab + " % ");
		
	}
	
	public static void worstfit(int ms)
	{
		int n=addressspace.size();
		int n1=process.size();
		int i=0,j=0,allocatedmem=0,count=0;
		int var,size; 
		double memutilization;
		double blockprobab;
		
		assign();
		for(i=0;i<n1;i++)
		{
			size=0;
			var=-1;
			for(j=0;j<n;j++)
			{
				if(process.get(i).memory < al[j]&&(al[j]-process.get(i).memory)>size) 
				{
					size=al[j]-process.get(i).memory;
					var=j;
				}
			}
			if(var!=-1)
			{
				bs[i]=1;
				
				//  Process_id, base_starting_address, memory_length_allocated
				System.out.print("Processs ID: " + process.get(i).pid);
				System.out.print("  Base starting address: "+ addressspace.get(var).startadd);
				System.out.print("  Memory length allocated: " + process.get(i).memory);
				al[var]=al[var]-process.get(i).memory;
				allocatedmem+= process.get(i).memory;
				//bl[j]=bl[j]+process.get(i).memory; //update starting base address
				System.out.println("  Remaining space after process allocation  "+al[var]);
			}
			if(bs[i]==0)
			{
				count++;
				System.out.println("Blocked Process: "+process.get(i).pid);
			}
			
		}
		memutilization=((double)allocatedmem/ms)*100;
		blockprobab=((double)count/n1)*100;
		System.out.println("Memory Utilization of a process: "+memutilization + " % ");
		System.out.println("Blocking Probability of a process: "+blockprobab + " % ");
		
		}
		
	
}
