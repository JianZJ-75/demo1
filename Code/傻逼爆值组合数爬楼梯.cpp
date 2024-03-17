#include <stdio.h>
//#include <string.h>
long long f(int n2,int n12);//计算步数相同时的种数 
int main(){
	int n1,n2=1,N;
	//输出阶梯数 
	scanf("%d",&N); 
	if(N>=1&&N<=40){
		long long n=1;
		n1=N-2;
		int max=N/2;//n2最大数量
		long long ret;
		for(;n2<=max;n2++,n1-=2){
			ret=f(n2,n1+n2);
			n+=ret;//每个步数种数相加 
		}
		printf("%lld\n",n);
	}
	return 0;
} 
long long f(int n2,int n12){
	printf("n2=%d n12=%d\n",n2,n12);
	long long ret,a=1,b=1;
	//判断n2与n12大小
	if(n2>n12/2){
		n2=n12-n2;
	} 
	//排列组合C几几 
	//c的分母 
	for(int i=n2;i>=1;i--){
		a*=i;
	}
	//c的分子 
	for(int j=n12,i=n2;i>=1;i--,j--){
		b*=j;
	}
	ret=b/a;
	printf("%lld\n",ret);
	//返回该步数的种数 
	return ret;
}
