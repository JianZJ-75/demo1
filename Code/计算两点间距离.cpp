#include <stdio.h>
#include <math.h>
int main()
{
	double a,b,c,d;
	double i,j,x;
	while(scanf("%lf %lf %lf %lf",&a,&b,&c,&d)!=EOF){
		i=fabs(a-c);
		//printf("%f\n",i);
		j=fabs(b-d);
		//printf("%f\n",j);
		x=sqrt(pow(i,2)+pow(j,2));
		printf("%.2f\n",x);
	}
 	return 0;
}
