#include <stdio.h>
int main()
{
	//��ʼ�� 
	double a,s,result;
	int n;
    //��ֵ
	s=0;
	n=0;
	scanf("%lf",&a);
	while(a!=0)
	{
		s+=a;
		n++;
		scanf("%lf",&a);
	}
	result=s/n;
	printf("ƽ��ֵΪ%f.\n",result); 
	return 0;
}
