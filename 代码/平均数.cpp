#include <stdio.h>
int main()
{
	printf("请输入两个整数：");
	int a,b;
	scanf("%d %d",&a,&b);
	double c=(a+b)/2.0;
	printf("%d与%d的平均数为%f。",a,b,c);
	return 0;
}
