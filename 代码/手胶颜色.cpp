#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main(){
	srand(time(0));
	int a=rand()%3+1;
	if(a==1){
		printf("·ÛÉ«");
	}else if(a==2){
		printf("ÂÌÉ«"); 
	}else if(a==3){
		printf("°×É«");
	}
	return 0;
}
