#include <stdio.h>
int f(int m,int a[],int x);
int main(){
	int n,x,m=0;
	scanf("%d",&n);
	int a[n];
	for(int i=0;i<n;i++){
		scanf("%d",&x);
		if(i==0||f(m,a,x)==1){
			a[m]=x;
			m++;
		}
	}
	printf("%d",m);
	return 0;
}
int f(int m,int a[],int x){
	for(int j=0;j<m;j++){
		if(a[j]==x){
			return 0;
		}
	}
	return 1;
}
