#include <stdio.h>
void sum(int begin,int end)
{
	int i;
	int sum=0;
	for(i=begin;i<=end;i++){
		sum+=i;
	}
	printf("%d��%d�ĺ�Ϊ%d.\n",begin,end,sum);
}
int main()
{
	sum(10,20);
	sum(99,130);
	sum(1,5);
	return 0;
}
