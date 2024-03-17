#include <stdio.h>
int main()
{
	//初始化 
	double a,s,result;
	int n;
    //赋值
	s=0;
	n=0;
	scanf("%lf",&a);
	while(a!=0)
	{
		s+=a;
		n++;
		scanf("%lf",&a);
	}
	result=s/n;
	printf("平均值为%f.\n",result); 
	return 0;
}
