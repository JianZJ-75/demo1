#include <stdio.h>
int main(){
	char i;
	int a=0,b=0,c=0,d=0;
	while(scanf("%c",&i)!=EOF){
		if((i>='a'&&i<='z')||(i>='A'&&i<='Z')){
			a++;
		}else if(i>='0'&&i<='9'){
			b++;
		}else if(i==' '){
			c++;
		}else if(i=='\n'){
			break;
		}else{
			d++;
		}
	}
	printf("%d %d %d %d\n",a,b,c,d);
	return 0;
}
