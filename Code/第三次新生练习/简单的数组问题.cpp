#include <stdio.h>

void qo(int a[]);
void max1(int *max,int a[]);
int a[100001]={0,};
int main(int argc,char const *argv[]){
	int t;0
	scanf("%d",&t);
	int q,n,sy;
	int max=0;
	while(t--){
		scanf("%d",&q);
		int ju=q;
		while(q--){
			scanf("%d",&n); 
			a[n]++;
		}               
		max1(&max,a);
		//printf("max=%d ju=%d ju/2=%d\n",max,ju,ju/2);
		if(max==ju){
			sy=max;
		}else if(max>=ju/2){
			sy=max-ju/2;
			if(ju%2!=0){
				sy+=1;
			}
		}else{
			if(ju%2==0){
				sy=0;
			}else{
				sy=1;
			}
		}
		printf("%d\n",sy);
		qo(a);
	}
	return 0;
}
void max1(int *max,int a[]){
	//*max=0;
	int m=100001;
	*max=*a;
	while(m--){
		*a++;
		if(*max<*a){
			*max=*a;
		}
	}
}
void qo(int a[]){
	int m=100001;
	while(m--){
		*a=0;
		*a++;
	} 
}
