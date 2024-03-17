#include <stdio.h>
int f(int x,int a);
int main()
{
	long long n,m,a,i,j;
	scanf("%d %d %d",&n,&m,&a);
	i=f(n,a);
	j=f(m,a);
	printf("%lld",i*j);
 	return 0;
}
int f(int x,int a)
{
	int i;
	if(x%a!=0){
		i=x/a+1;
	}else{
		i=x/a;
	}
	return i;
}
