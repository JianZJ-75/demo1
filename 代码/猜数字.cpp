#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main()
{
	//��ʼ��
	srand(time(0));
	int number=rand()%100+1;
	//int number=99;
	int a,count;
	int e,f;
	int c=0,d=0;
	count=0;
	//��ʼ��Ϸ
	printf("�����ֲ����֣���ְֽ��������������Ϸ��\n����1�󰴻س�������\n");
	scanf("%d",&e);
	printf("����������ˣ�������1���س���\n"); 
	scanf("%d",&f);
	printf("���£�"); 
	do
	{
		scanf("%d",&a);
		count++;
		if(a>number){
			c++;
			if(c<2){
				printf("�����������Ҳ̫���˰ɣ�һ����ٹ������ˣ��������һ�Σ�"); 
			}else if(c<4){
				printf("�����ҵ��죬���Ǵ��ˣ����������ˣ�������"); 
			}else{
				printf("���˴��ˣ����ͣ�������");
			}
			//scanf("%d",&a);
		}else if(a<number){
			d++;
			if(d<2){
				printf("���������������ô��ģ�����ôС��ʲô�������ˣ������������һ�Σ�"); 
			}else if(d<4){
				printf("��������С�ˣ����ϲ���ôС���ﰡ��������");
			}else{
				printf("С��С�ˣ����ͣ�������");
			}
			//scanf("%d",&a);
		}
	}while(a!=number);
	if(count<=7){
		printf("Ӵ�ǣ�С�Թ��ӻ��������%d�ξͲµ��ˣ�����ְ�������ϬŶ��",count);
	}else{
		printf("�����Ƥ����%d�βŲ��У�����������С�Թ��ӣ���ѧѧ��ѧ�ɣ�û����......",count);
	}
	//��Ϸ���� 
	return 0;
}
