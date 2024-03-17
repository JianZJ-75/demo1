#include <stdio.h>
#include <stdlib.h>

int main(){
	int a;
	while((a=getchar())!=EOF){
		putchar(a);
	} 
	printf("EOF");
	return 0;
}
