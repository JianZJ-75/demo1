#include <stdio.h>

int main(){
	double  s,t;
	scanf("%d %d",&s,&t);
	double sum=10;
	if(s>3&&s<=10) sum+=2*(s-3);
	else if(s>10) sum+=2*7+3*(s-10);
	printf("%.0lf",sum+2*t/5); 
	return 0;
}
