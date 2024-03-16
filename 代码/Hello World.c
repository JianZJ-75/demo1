#include <stdio.h>

int main()
{
	int a=0;
	printf("请输入金额（元）：");
	scanf("%d",&a);
	
	int change=100-a;
	printf("找您%d元。",a);
	return 0;
}
