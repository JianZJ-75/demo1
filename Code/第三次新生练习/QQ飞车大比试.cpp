#include <stdio.h>
#define ll long long

int main(int argc,char *argv[]){
	int t;
	scanf("%d",&t);
	ll n,sum;
	while(t--){
		scanf("%lld",&n);
		if(n==1){
			sum=1;
		}else{
			sum=2*n-1;
		}
		printf("%lld\n",sum);
	} 
	return 0;
}
