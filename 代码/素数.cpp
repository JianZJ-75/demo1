#include <stdio.h>
int main()
{
	//��ʼ�� 
	long long x,q;
	//���벢��ֵ 
	printf("������һ��������");
	scanf("%lld",&x);
	q=1;
	//�жϲ����
	if(x==0||x==1){
		printf("������Ч��");
		return 0;
	}
	for(int i=2;i<x;i++){
		q=x%i;
		//printf("q=%d\n",q);
		if (q==0){
			printf("��������Ϊ������");
			return 0; 
		}
	} 
	printf("������Ϊ������"); 
	return 0; 	
}
