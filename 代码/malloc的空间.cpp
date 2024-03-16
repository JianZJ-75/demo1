#include <stdio.h>
#include <stdlib.h>

//void swap(int *min,int *max);
int main(){
	void *a;
	int n=0;
	while((a=malloc(1024*1024))){
		n++;
	}
	printf("分配了%dMB的空间\n",n);
	free(a);
	return 0;
}
