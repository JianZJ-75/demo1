#include <stdio.h>
int main()
{
	//初始化 
	int x,n;
	//赋值
	printf("请输入数字：");
	scanf("%d",&x);
	n=0;
	//数据处理
	do
	{
		n++;
		x/=10;
		printf("x=%d,n=%d\n",x,n);
	}while(x>0);
	printf("该数字为%d位数。",n);
	return 0; 
}
