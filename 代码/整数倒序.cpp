#include <stdio.h>
int main()
{
	//��ʼ�� 
	int a,b,ret;
	//��ֵ 
	ret=0;
	printf("��������Ҫ���������"); 
	scanf("%d",&a);
	//�������� 
	while(a>0){
		b=a%10;
		a/=10;
		ret=ret*10+b;
		//printf("%d",b);
	} 
	//������
	printf("���������Ϊ%d.",ret);
	return 0; 	
 } 
