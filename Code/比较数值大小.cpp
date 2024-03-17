#include <stdio.h>
int main()
{
	//初始化
	double a,b,c,max;
	//赋值
	printf("请输入需要比较的数：");
	scanf("%lf %lf %lf",&a,&b,&c);
	//比较
	if(a>b){
		max=a;
	}else{
		max=b;
	}	
	if(max<c)
		max=c;
	printf("最大值为%f。",max);
	return 0;
} 
