#include <stdio.h>
int main()
{
	//��ʼ��
	const double PRICE=20.5;
	const int STANDARD=30;
	int hour;
	double pay=0;
	//��ֵ
	printf("�����빤��ʱ�䣺");
	scanf("%d",&hour);
	//�жϲ�����
	if(hour>=STANDARD)
	pay=STANDARD*PRICE+(hour-STANDARD)*(PRICE*1.5);
	pay=hour*PRICE;
	//���ʽ��� 
	printf("Ӧ������%fԪ��",pay);
	return 0; 
}
