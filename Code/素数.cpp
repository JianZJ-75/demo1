#include <stdio.h>
int main()
{
	//初始化 
	long long x,q;
	//输入并赋值 
	printf("请输入一个整数：");
	scanf("%lld",&x);
	q=1;
	//判断并输出
	if(x==0||x==1){
		printf("该数无效！");
		return 0;
	}
	for(int i=2;i<x;i++){
		q=x%i;
		//printf("q=%d\n",q);
		if (q==0){
			printf("该整数不为素数！");
			return 0; 
		}
	} 
	printf("该整数为素数！"); 
	return 0; 	
}
