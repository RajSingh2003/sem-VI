#include<stdio.h>

int max[10][10],allocation[10][10],need[10][10];
int avail[10],req[10];
int np,nr;


void acceptAv()
{
int j;
printf("\n Enter available resources :");
for(j=0;j<nr;j++)
scanf("%d",&avail[j]);
}

void displayAv()
{
int j;
printf("\n Available Resources\n");
for(j=0;j<nr;j++)
printf("%d",avail[j]);
}

void readmatrix(int matrix[10][10])
{
int i,j;
for(i=0;i<np;i++)
for(j=0;j<nr;j++)
scanf("%d",&matrix[i][j]);
}

void display_matrix(int matrix[10][10])
{
 int i,j;
 for(i=0;i<np;i++)
 {
   printf("\n P%d\t",i);
   for(j=0;j<nr;j++)
   {
     printf("%d\t",matrix[i][j]);
   }
 }
}

void calculate_need()
{
int i,j;
for(i=0;i<np;i++)
for(j=0;j<nr;j++)
need[i][j]=max[i][j]-allocation[i][j];
}

void banker()
{
int i,j,k=0,flag;
int finish[10],safe_seq[10];
for(i=0;i<np;i++)
{
finish[i]=0;
}
int over=0;
while(!over){
for(i=0;i<np;i++)
{
 flag=0;
 if(finish[i]==0)
 {
   for(j=0;j<nr;j++)
   {
    if(need[i][j]>avail[j])
    {
      flag=1;
      break;
    }
   }
   if(flag==0)
   {
     finish[i]=1;
     safe_seq[k]=i;
     k++;
     for(j=0;j<nr;j++)
     avail[j]+=allocation[i][j];
    }
   }
   else
   {
     over=1;
   }
 }
}
flag=0;
for(i=1;i<np;i++)
{
 if(finish[i]==0)
 {
   printf("\n The system is in deadlock condition");
   flag=1;
   break;
 }
}
if(flag==0)
{
printf("\n The system is in safe state! \n Safe Sequence is ==>");
for(i=0;i<np;i++)
printf("P%d", safe_seq[i]);
}
}

int request(){
int j,n,i;
printf("Enter the process number for which you want to request\n");
scanf("%d",&j);
printf("Enter the request array\n");
for( i=0;i<nr;i++){
scanf("%d",&req[i]);
}


for(i=0;i<nr;i++){
if(req[i]>need[j][i]){
printf("Can't fill the request bcz its max exceed\n");
return 0;
}
}
for(i=0;i<nr;i++){
if(req[i]>avail[i]){
printf("Process must wait\n");
return 0;
}
}

for(i=0;i<nr;i++){
avail[i]=avail[i]-req[i];
allocation[j][i]=allocation[j][i]+req[i];
need[j][i]=need[j][i]-req[i];
}

//For checking new state are safe or not..
//banker();
}


int main(){

int j,choice,p;
//read input
printf("\n Enter no.of processes");
scanf("%d",&np);
printf("\n Enter no. of resources");
scanf("%d",&nr);
printf("\n Enter initial allocation matrix :");
readmatrix(allocation);
printf("\n Enter Max requirement matrix :");
readmatrix(max);
////calculate need
calculate_need();

do
{
printf("\n1.Accept available\n 2.Display allocation\n 3.DisplayNeedMatrix\n 4.DiplayAvailable\n 5.Banker calculate\n6.Req\n7.Exit\n");

printf("Enter the choice\n");
scanf("%d",&choice);

switch(choice)
{
  case 1: acceptAv();
	  break;
  case 2: printf("Allocation matrix is:......\n"); 
          display_matrix(allocation);
	  printf("Max matrix is.....\n");
	  display_matrix(max);
          break;

  case 3: printf("Need matrix is .....\n");
          display_matrix(need);
          break;
  case 4: displayAv();
          break;
  case 5: banker();
	  break;
  case 6: p=request();
	  break;
}
}while(choice<7);

return 0;
}

/*Output
 Enter no.of processes6

 Enter no. of resources4

 Enter initial allocation matrix :0 3 2 4
1 2 0 1
0 0 0 0
3 3 2 2 
1 4 3 2
2 4 1 4

 Enter Max requirement matrix :6 5 4 4 
4 4 4 4
0 0 1 2
3 9 3 4
2 5 3 3
4 6 3 5

1.Accept available
 2.Display allocation
 3.DisplayNeedMatrix
 4.DiplayAvailable
 5.Banker calculate
6.Req
7.Exit
Enter the choice
1

 Enter available resources :3 4 5 2

1.Accept available
 2.Display allocation
 3.DisplayNeedMatrix
 4.DiplayAvailable
 5.Banker calculate
6.Req
7.Exit
Enter the choice
6
Enter the process number for which you want to request
1
Enter the request array
2 2 3 1

1.Accept available
 2.Display allocation
 3.DisplayNeedMatrix
 4.DiplayAvailable
 5.Banker calculate
6.Req
7.Exit
Enter the choice
5
1 1 1 1 1 
 The system is in safe state! 
 Safe Sequence is ==>P4P5P1P2P3P0
*/


