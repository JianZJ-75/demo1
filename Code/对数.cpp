#include <stdio.h>
int main()
{
	//��ʼ�� 
	int x,a,t;
	//��ֵ
	scanf("%d",&x);
	t=x;
	a=0;
	//�ж� 
	do
	{
		x/=2;
		a++;
		printf("x=%d,a=%d\n",x,a);
	}while(x>1);
	printf("log2 of %d is %d.\n",t
	,a);
	return 0;
}
