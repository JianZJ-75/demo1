#include <stdio.h>
#include <math.h>

long long g(int N,int x);//��ϵķ��ӣ�����ֵ 
//unsigned long long f(int N,int x);//���� 
int main(){
	long long sum,a,b;
	int N;
	scanf("%d",&N);
	//������� 
	//for(int i=20;N<=20;N+=2){
	a=g(N,1);
	b=g(N/2,0);
	sum=a/b/2;//���� 
	//���� 
	/*{
		printf("a=%llu\n",a);
		printf("b=%llu\n",b); 
		printf("sum=%llu\n",sum);
	}*/
	//����������� 
	if(N==2||N==4){
		goto out;
	} 
	sum*=pow(g(N/2-1,0),2.0);//����ϲ� 
	out:
	//��� 
	printf("%lld\n",sum);
	//}
}
/*unsigned long long f(int N,int x){
	if(N==0){
		return 0;
	}else if(N==1){
		return 1;
	}else{
		return N*f(N-1);
	}
}*/
long long g(int N,int x){
	long long a=N;
	int p=1;
	if(x==1){
		p=N/2;
	}	
	for(int i=N-1;i>p;i--){
		a*=i;
		//printf("g(a)=%llu\n",a);
	}
	return a;
}
