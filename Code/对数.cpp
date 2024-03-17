#include <stdio.h>
int main()
{
	//³õÊ¼»¯ 
	int x,a,t;
	//¸³Öµ
	scanf("%d",&x);
	t=x;
	a=0;
	//ÅÐ¶Ï 
	do
	{
		x/=2;
		a++;
		printf("x=%d,a=%d\n",x,a);
	}while(x>1);
	printf("log2 of %d is %d.\n",t
	,a);
	return 0;
}
