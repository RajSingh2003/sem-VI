#include<stdio.h>

void main()
{
int min,max,ciln[20],ans=0,k,i,head,n,start,end;
printf("Enter no of block in cylinder and head\n");
scanf("%d%d",&n,&head);
printf("Enter block\n");
for(i=0;i<n;i++){
scanf("%d",&ciln[i]);
}

printf("Enter the  number moved from to ..");
scanf("%d%d",&start,&end);

printf("enter 0 for moving lower value else enter 1\n");
scanf("%d",&k);

if(k==0){
max=ciln[0];
for(i=1;i<n;i++){
if(ciln[i]>max)
max=ciln[i];
}

ans=(head-start)+(max-start);
printf("total head is %d",ans);
}
else{
min=ciln[0];
for(i=1;i<n;i++){
if(ciln[i]<min)
min=ciln[i];
}
ans=(end-head)+(end-min);
printf("total head is %d",ans);
}
}

/*
Output..

Enter no of block in cylinder and head
8 53
Enter block
98 183 41 122 14 124 65 67
Enter the  number moved from to ..0 199
enter 0 for moving lower value else enter 1
1
total head is 331
*/
