#include <stdio.h>
int main()
{
	//初始化 
	double a,b,c;
	//输入金额与票面 
	printf("请输入购买的金额：");
	scanf("%lf",&a);
	printf("请输入支付的票面：");
	scanf("%lf",&b);
	//计算 
	c=b-a;
	//判断 
	if(c<0){
		c=-c;
		printf("余额不足,还需%f元。",c); 
	}else{
	printf("找您%f元。",c);
	}	
	return 0; 
}
