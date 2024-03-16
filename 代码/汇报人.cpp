#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main(){
	srand(time(0));
	int a=rand()%5+1;
	if(a==1){
		printf("章耀东"); 
	}else if(a==2){
		printf("潘涛");
	}else if(a==3){
		printf("侯陈琛");
	}else if(a==4){
		printf("张宇");
	}else{
		printf("王中宇");
	}
	return 0;
}
