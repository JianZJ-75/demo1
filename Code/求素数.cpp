#include <stdio.h>

int main(){
	int number=100000;
	int sushu[number]={[0]=0};
	for(int i=1;i<number;i++){
		sushu[i]=1;
	} 
	/*for(int i=0;i<number;i++){
		printf("sushu[%d]=%d",i,sushu[i]);
		if(i<number-1){
			printf(" ");
		}else{
			printf("\n");
		}
	}*/
	for(int x=2;x<number;x++){
		if(sushu[x]==1){
			for(int i=2;i*x<number;i++){
				sushu[i*x]=0;
			}
		}
	}
	/*for(int i=0;i<number;i++){
		printf("suhsu[%d]=%d",i,sushu[i]);
		if(i<number-1){
			printf(" ");
		}else{
			printf("\n");
		}
	}*/
	for(int i=0;i<number;i++){
		if(sushu[i]==1){
			printf("%d",i);
			if(i<number-1){
				printf(" ");
			}
		}
	}
	return 0;
} 

