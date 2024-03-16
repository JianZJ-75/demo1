#include <stdio.h>
int main()
{
	int a=4,b=5;
	int c;
	c=a;
	a=b;
	b=c;
	printf("%d %d",a,b);
	return 0;
}
