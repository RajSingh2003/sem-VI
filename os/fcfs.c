#include<stdio.h>

void main(){
int ciln[20],ans=0,i,head,n;
printf("Enter no of block in cylinder and head\n");
scanf("%d%d",&n,&head);

printf("Enter block\n");
for(i=0;i<n;i++){
scanf("%d",&ciln[i]);
}
ans=abs(ciln[0]-head);
for(i=1;i<n;i++){
ans=ans+abs(ciln[i]-ciln[i-1]);
}
printf(" Total head is : %d",ans);
}
