#include <stdio.h>
int main()
{
	//��ʼ�� 
	int x,n;
	//��ֵ
	printf("���������֣�");
	scanf("%d",&x);
	n=0;
	//���ݴ���
	do
	{
		n++;
		x/=10;
		printf("x=%d,n=%d\n",x,n);
	}while(x>0);
	printf("������Ϊ%dλ����",n);
	return 0; 
}
