#include <stdio.h>
int main(){
	int a,b;
	scanf("%d %d",&a,&b);
	int c;
	c=b;
	b=a;
	a=c;
	printf("a=%d b=%d",a,b);
	return 0;
}
