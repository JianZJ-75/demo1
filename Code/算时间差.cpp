#include <stdio.h>
int main()
{
	int hour1,minute1;
	int hour2,minute2;
	int a;
	printf("����������ʱ��㣺"); 
	scanf("%d %d",&hour1,&minute1);
	scanf("%d %d",&hour2,&minute2);
	a=(hour2-hour1)*60+minute2-minute1;
	printf("ʱ���Ϊ%dСʱ%d���ӡ�",
	a/60,
	a%60);
	return 0; 
}
