#include <stdio.h>

int main(){
	double s=100,h=100.0;
	int i=10;
	while(i>0){
		h/=2;
		s+=h*2;
		i--;
	}
	s-=h*2;
	printf("%f %f\n",s,h);
	return 0;
}
