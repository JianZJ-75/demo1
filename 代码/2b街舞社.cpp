#include <stdio.h>
#include <math.h>

long long g(int N,int x);//组合的分子，防爆值 
//unsigned long long f(int N,int x);//排列 
int main(){
	long long sum,a,b;
	int N;
	scanf("%d",&N);
	//计算组合 
	//for(int i=20;N<=20;N+=2){
	a=g(N,1);
	b=g(N/2,0);
	sum=a/b/2;//分组 
	//调试 
	/*{
		printf("a=%llu\n",a);
		printf("b=%llu\n",b); 
		printf("sum=%llu\n",sum);
	}*/
	//考虑特殊情况 
	if(N==2||N==4){
		goto out;
	} 
	sum*=pow(g(N/2-1,0),2.0);//各组合并 
	out:
	//输出 
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
