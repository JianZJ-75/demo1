#include <stdio.h>
int f(int a[10]);
int main(){
	int a[10];
	int x,n=0;
	while(scanf("%d",&x)!=EOF){
		//int i=0;
		for(;n<10;){
			a[n]=x;
			break;
		}
		n++;
		if(n==10){
			break;
		}
	}
	int c;
	while(f(a)){
		for(int i=0;i<10;i++){
			if(a[i]>a[i+1]){
				c=a[i];
				a[i]=a[i+1];
				a[i+1]=c;
			}
		}
    }
	for(int i=0;i<10;i++){
		printf("%d",a[i]);
		if(i<9){
			printf(" ");
		}
	}
	return 0;
} 
int f(int a[10]){
	int ret=1;
	for(int i=0;i<10;i++){
		if(a[i]>a[i+1]){
			goto out;
		}
	}
	ret=0;
	out:
	return ret;
} 
