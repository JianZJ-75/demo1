#include <stdio.h>
int main()
{
	//��ʼ�� 
	int a;
	//��ֵ
	scanf("%d",&a); 
	//�ж� 
	switch(a){
	case 1:
		printf("��ã�");
		break;
	case 2:
		printf("���Ϻã�");
		break;
	case 3:
	 	printf("����ã�");
		break;
	case 4:
		printf("���Ϻã�");
		break;
	default:
		printf("������ʲô����");
		break; 
	}
	return 0;
}
