#include <stdio.h>
int main()
{
	//��ʼ�� 
	double x,f;
	//��ֵ������ 
	scanf("%lf",&x); 
	//�ж�
	switch(x<=0){
	case 1:
		f=-(x<0);
		break;
	default:
		f=2*x;
		break;
	} 
	printf("f(%f)=%f\n",x,f);
	return 0;
	
}
