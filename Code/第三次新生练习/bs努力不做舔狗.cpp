#include <stdio.h>
#include <string.h>
#define ll long long

int main(){
	int t;
	scanf("%d",&t);
	while(t--){
		char a[1000001];
		scanf("%s",&a);
		ll n=strlen(a); 
		ll ret=0;
		for(int i=0;i<n-1;i++){//�ж��ַ������ĸ���� 
			if(a[i]>a[i+1]){
				ret=i;
			}else{
				ret=i+1;
			}
		}
		if(a[ret]=='0'){//���ȫ��0 
			a[ret]='1';
		}
		printf("%c\n",a[ret]);
	}
	return 0;
}
