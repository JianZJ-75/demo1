#include <stdio.h>
int main()
{
	//��ʼ��
	double a,b,c,max;
	//��ֵ
	printf("��������Ҫ�Ƚϵ�����");
	scanf("%lf %lf %lf",&a,&b,&c);
	//�Ƚ�
	if(a>b){
		max=a;
	}else{
		max=b;
	}	
	if(max<c)
		max=c;
	printf("���ֵΪ%f��",max);
	return 0;
} 
