#include <stdio.h>
int main()
{
	unsigned 	int a=0;
	int b=0;
	while(++a>0);
	printf("�����Ϊ%u\n",a-1);
	b++;
	a-=1;
	while((a/=10)!=0){
		b++;
	}
	printf("λ��Ϊ%u\n",b);  
 	return 0;
}
