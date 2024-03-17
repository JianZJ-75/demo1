#include <stdio.h>
#include <math.h> 

int main(){
	int t,s,j1;
	double j2;
	scanf("%d",&t);
	while(t--){
		scanf("%d",&s);
		j1=sqrt(s);
		j2=sqrt(s);
		if(j1!=j2){
			j1++;
		}
		if(s==1){
			j1=1;
		}
		printf("%d\n",j1);
	}
	return 0;
}
