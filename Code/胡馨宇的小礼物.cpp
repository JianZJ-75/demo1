#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main()
{
	//��ʼ��
	srand(time(0));
	int number=rand()%100+1;
	int a,count;
	int c,d;
	count=0;
	//��ʼ��Ϸ
	printf("�����ֲ����֣���ְֽ��������������Ϸ��\n����1�󰴻س�������\n");
	scanf("%d",&c);
	printf("����������˹���������1���س���\n"); 
	scanf("%d",&d);
	printf("���£�"); 
	do
	{
		scanf("%d",&a);
		count++;
		if(a>number){
			c++;
			if(c<2){
				printf("ܰ���������Ҳ̫���˰ɣ���ô��û�����Դ����ˣ��������һ�Σ�"); 
			}else if(c<4){
				printf("�����ҵ��죬���Ǵ��ˣ���������ˣ�������"); 
			}else{
				printf("���˴��ˣ����ͣ�������"); 
			}
			//scanf("%d",&a);
		}else if(a<number){
			d++;
			if(d<2){
				printf("ܰ�������������ô��ģ�����ôС��ʲô������Ҳ��������ô��ɣ������Ҳ��ˣ������������һ�Σ�"); 
			}else if(d<4){
				printf("��Ӵ�����Ǵ��ˣ��ʵ�����ŷ�ˣ�������");
			}else{
				printf("С��С�ˣ����ͣ�������");
			}
			//scanf("%d",&a);
		}
	}while(a!=number);
	if(count<=7){
		printf("Ӵ�ǣ�С�Թ��ӻ��������%d�ξͲµ��ˣ�����ְ�������ϬŶ��",count);
	}else{
		printf("���С��������%d�βŲ��У�����������С�Թ��ӣ������ù���������������ָ���......",count);
	}
	//��Ϸ���� 
	return 0;
}
