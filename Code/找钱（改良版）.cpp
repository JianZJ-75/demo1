#include <stdio.h>
int main()
{
	//��ʼ�� 
	double a,b,c;
	//��������Ʊ�� 
	printf("�����빺��Ľ�");
	scanf("%lf",&a);
	printf("������֧����Ʊ�棺");
	scanf("%lf",&b);
	//���� 
	c=b-a;
	//�ж� 
	if(c<0){
		c=-c;
		printf("����,����%fԪ��",c); 
	}else{
	printf("����%fԪ��",c);
	}	
	return 0; 
}
