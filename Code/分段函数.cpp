#include <stdio.h>
int main()
{
	//初始化 
	double x,f;
	//赋值并计算 
	scanf("%lf",&x); 
	//判断
	switch(x<=0){
	case 1:
		f=-(x<0);
		break;
	default:
		f=2*x;
		break;
	} 
	printf("f(%f)=%f\n",x,f);
	return 0;
	
}
