#include <stdio.h>
//#include <string.h>
long long f(int n2,int n12);//���㲽����ͬʱ������ 
int main(){
	int n1,n2=1,N;
	//��������� 
	scanf("%d",&N); 
	if(N>=1&&N<=40){
		long long n=1;
		n1=N-2;
		int max=N/2;//n2�������
		long long ret;
		for(;n2<=max;n2++,n1-=2){
			ret=f(n2,n1+n2);
			n+=ret;//ÿ������������� 
		}
		printf("%lld\n",n);
	}
	return 0;
} 
long long f(int n2,int n12){
	printf("n2=%d n12=%d\n",n2,n12);
	long long ret,a=1,b=1;
	//�ж�n2��n12��С
	if(n2>n12/2){
		n2=n12-n2;
	} 
	//�������C���� 
	//c�ķ�ĸ 
	for(int i=n2;i>=1;i--){
		a*=i;
	}
	//c�ķ��� 
	for(int j=n12,i=n2;i>=1;i--,j--){
		b*=j;
	}
	ret=b/a;
	printf("%lld\n",ret);
	//���ظò��������� 
	return ret;
}
