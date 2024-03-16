#include <stdio.h>
int main()
{
	int a=0,b=0,c=1000;
	printf("请输入金额（元）：");
	scanf("%d",&a);
	
	b=c-a;
	printf("找您%d元。",b);
	return 0;
}
