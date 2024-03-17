#include <stdio.h>
int main(){
	int h1,m1,h2,m2;
	int h,m;
	while(scanf("%d %d %d %d",&h1,&m1,&h2,&m2)!=EOF){
		if(h1<h2){
			if(m1>m2){
				h2--;
				m2+=60;
				//printf("1\n");
			}
		}else if(h1==h2){
			if(m1>m2){
				h2--;
				h2+=24;
				m2+=60;
			}
		}else{
			h2+=24;
			//printf("2\n");
			if(m1>m2){
				h2--;
				m2+60;
			}
		}
		h=h2-h1;
		m=m2-m1;
		printf("%d %d\n",h,m);
	}
	return 0;
}
