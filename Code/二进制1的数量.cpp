#include <stdio.h>

int main(){
	int T;
	unsigned long long n,count;
	count=0;
	scanf("%d",&T);
	unsigned long long a[T];
	//scanf("%lld",&n);
	for(int i=0;i<T;i++){
		count=0;
		scanf("%llu",&n);
		unsigned long long j=n;
		do{
			//int j=T;
			unsigned long long q;
			q=j%2;
			j/=2;
			//printf("j=%d q=%d\n",j,q);
			if(q==1){
				count++;
			}
		}while(j!=0);
		a[i]=count;
	}
	for(int i=0;i<T;i++){
		printf("%llu",a[i]);
		if(i<T-1){
			printf("\n");
		}
	}
	return 0;
} 
