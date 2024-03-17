#include <stdio.h>
int main()
{
	int hour1,minute1;
	int hour2,minute2;
	int a;
	printf("请输入两个时间点："); 
	scanf("%d %d",&hour1,&minute1);
	scanf("%d %d",&hour2,&minute2);
	a=(hour2-hour1)*60+minute2-minute1;
	printf("时间差为%d小时%d分钟。",
	a/60,
	a%60);
	return 0; 
}
