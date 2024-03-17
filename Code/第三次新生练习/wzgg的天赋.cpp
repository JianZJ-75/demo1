#include <stdio.h>
#include <string.h>

int main(){
	int t;
	scanf("%d",&t);
	while(t--){
		char a[101];
		scanf("%s",&a);
		int c=strlen(a)-1;
		int n1,n2,max1=0,max2=0,max=0;
		for(int i=0;i<c+1;i++){
			//printf("i=%d\n",i);
			n1=1;
			n2=0;
			//printf("dao\n");
			for(int l=i-1,r=i+1;l>=0||r<=c;l--,r++){
				//printf("l%d=%d r%d=%d\n",i,l,i,r);
				if(a[l]==a[r]){
					n1+=2;
					//printf("%d %d\n",l,r);
				}else{
					//printf("break1\n");
					break;
				}
			}
			//printf("n1=%d\n",n1);
			if(max1<n1){
				max1=n1;
			}
			for(int l=i,r=i+1;l>=0||r<=c;l--,r++){
				//printf("l%d=%d r%d=%d\n",i,l,i,r);
				if(a[l]==a[r]){
					n2+=2;
					//printf("%d %d\n",l,r);
				}else{
					//printf("break2\n");
					break;
				}
			}
			//printf("n2=%d\n",n2);
			if(max2<n2){
				max2=n2;
			}
			if(max1>max){
				max=max1; 
			}
			if(max2>max){
				max=max2;
			}
			//printf("max=%d\n",max);
		}
		printf("%d\n",max);
	}
	return 0;
}
