#include <stdio.h>
#include <math.h>
int f(long long j,long long p);
int main(){
	int T;
	scanf("%d",&T);
	long long n;
	for(int i=0;i<T;i++){
		scanf("%lld",&n);
		long long j,p;
		j=n%2;
		p=n/2;
		if(f(j,p)==1){
			printf("YES\n");
		}else{
			if(f(n%4,p/2)==1){
				printf("YES\n");
			}else{
				printf("NO\n");
			}
		}
	}
	return 0;
}
int f(long long j,long long p){
	if(j!=0){
		goto a;
	}
	long long p1;
	double p2;
	p1=sqrt(p);
	p2=sqrt(p);
	if(p1==p2){
		return 1;
	}else if(p1!=p2){
		a: 
		return 0;
	}
} 
