#include <stdio.h>
int fact(int a);
int main(){
	int a;
	int b;
	scanf("%d",&a);
	b=fact(a);
	printf("%d",b);
	return 0;
}
int fact(int a){
	if(a==1){
		return 1;
	}else if(a==0){
		return 0;
	}else{
		return a*fact(a-1);
	}
}
