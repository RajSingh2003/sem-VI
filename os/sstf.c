#include<stdio.h>
#include<stdlib.h>
int main()
{
	int RQ[100],i,n,THM=0,initial,count=0;
	printf("Enter the no. of request \n");
	scanf("%d",&n);
	printf("Enter Request Sequence \n");
	for(i=0;i<n;i++)
	  scanf("%d",&RQ[i]);
	printf("Enter inital head position\n");
	scanf("%d",&initial);
	while(count!=n)
	{
		int min=1000,d,index;
		for(i=0;i<n;i++)
		{
			d=abs(RQ[i]-initial);
			if(min>d)
			{
			 min=d;
			 index=i;
			}
		}
		THM +=min;
		initial=RQ[index];
		RQ[index]=1000;
		count++;
	}
	printf("Total Head Moment is: %d\n",THM);
	return 0;
}

