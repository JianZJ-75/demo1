#include <stdio.h>
int main()
{
	//初始化
	const double PRICE=20.5;
	const int STANDARD=30;
	int hour;
	double pay=0;
	//赋值
	printf("请输入工作时间：");
	scanf("%d",&hour);
	//判断并计算
	if(hour>=STANDARD)
	pay=STANDARD*PRICE+(hour-STANDARD)*(PRICE*1.5);
	pay=hour*PRICE;
	//工资结算 
	printf("应付工资%f元。",pay);
	return 0; 
}
