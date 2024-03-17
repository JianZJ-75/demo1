#include <stdio.h>
int main(){
	long long x,a,b,n;
	scanf("%lld %lld",&a,&b);
	//long long A[10];
	long long A[10]={0}; 
	//for(int i=0;i<10;i++){
		//A[i]=0;
	//}
	//
	for(int y=0;y<10;y++){
		printf("A[%d]=%lld\n",y,A[y]);
	}
	//
	for(int j,x=a;x<=b;x++){
		n=x;
		for(;n>0;n/=10){
			j=n%10;
			A[j]++;
			printf("n=%lld A[%d]=%lld\n",n,j,A[j]);
		}
	}
	for(int q=0;q<10;q++){
		printf("A[%d]=%lld",q,A[q]);
		if(q<9){
			printf(" ");
		}
	}
	return 0;
}
