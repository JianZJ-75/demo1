#include <stdio.h>
int main()
{
	//初始化 
	int a,b,ret;
	//赋值 
	ret=0;
	printf("请输入需要倒序的数："); 
	scanf("%d",&a);
	//整数倒序 
	while(a>0){
		b=a%10;
		a/=10;
		ret=ret*10+b;
		//printf("%d",b);
	} 
	//输出结果
	printf("该数倒序后为%d.",ret);
	return 0; 	
 } 
