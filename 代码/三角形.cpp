#include <stdio.h>
int f(int a,int b,int c);
int main()
{
	int A,B,C,D;
	int a,b,c,d;
	scanf("%d %d %d %d",&A,&B,&C,&D);
	a=f(A,B,C);
	b=f(B,C,D);
	c=f(A,C,D);
	d=f(A,B,D);
	if(a==3||b==3||c==3||d==3){
		printf("TRIANGLE");
	}else if(a==2||b==2||c==2||d==2){
		printf("SEGMENT");
	}else{
		printf("IMPOSSIBLE");
	}
 	return 0;
}

int f(int a,int b,int c)
{
	int i=1;
	if(a+b>c&&a+c>b&&b+c>a){
		//printf("TRIANGLE");
		i=3;
		return i;
	}
	int max;
	//int i=0;
	if(a<b){
		max=b;
	}else if(a>b){
		max=a;
	}else{
		max=a;
	}
	if(max<c){
		max=c;
	}
	if(a+b>=max&&a+c>=max&&b+c>=max){
		i=2;
		//printf("SEGMENT");
		return i;
	}
	return i;
}
