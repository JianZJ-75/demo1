#include <stdio.h>
#include <string.h>
int main(){
	char a[]="MTWTFS";
	char b[10];
	scanf("%s",b);
	for(int i=0;i<6;i++){
		if(b[0]==a[i]){
			if(i==1&&strlen(b)==8){
				printf("%d",i+3);
				goto a;
			}
			if(i==5&&strlen(b)==6){
				printf("%d",i+2);
				goto a;
			}
			printf("%d",i+1);
			goto b;
		}
	}
	a:
	b:
	return 0;
}
