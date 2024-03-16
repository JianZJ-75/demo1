#include <stdio.h>
int main()
{
	int hour1,minute1;
	int hour2,minute2;
	printf("请输入两个时间点："); 
	scanf("%d %d",&hour1,&minute1);
	scanf("%d %d",&hour2,&minute2);
	int h=hour2-hour1,m=minute2-minute1;
	if(m<0){
		m+=60;
		h=--h;
	} 
	printf("时间差为%d小时%d分钟。",h,m);
	return 0; 
}
