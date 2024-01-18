#include<stdio.h>

void main()
{
int min,max,ciln[20],finaldiff=1000,final=0,ans=0,k,i,head,n,start,end,diff;
printf("Enter no of block in cylinder and head\n");
scanf("%d%d",&n,&head);
printf("Enter block\n");
for(i=0;i<n;i++){
scanf("%d",&ciln[i]);
}

printf("Enter the  number moved from to upto ..");
scanf("%d%d",&start,&end);

printf("Enter 0 for moving lower direction else enter 1\n");
scanf("%d",&k);

if(k==1){

for(i=0;i<n;i++){
if(ciln[i]<head){
diff=head-ciln[i];
if(diff<finaldiff){
finaldiff=diff;
final=ciln[i];
}
}
}
ans=(end-head)+(end-start)+(final-start);
printf("total head momvent is %d \n",ans);

}
}
