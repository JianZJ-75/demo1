#include <iostream>

using namespace std;

int a[10001];
int b[10001];

int main(){
	int n;
	cin>>n;
	a[0]=1;
	b[0]=1;
	for(int i=2;i<=n;i++){
		for(int j=0;j<10000;j++){
			b[j]*=i;
		}
		for(int j=0;j<10000;j++){
			if(b[j]>9){
				b[j+1]+=b[j]/10;
				b[j]%=10;
			} 
		}
		for(int j=0;j<10000;j++){
			a[j]+=b[j];
			if(a[j]>9){
				a[j+1]+=a[j]/10;
				a[j]%=10;
			}
		}
	}
	int ret;
	for(int i=10000;i>=0&&a[i]==0;i--){
		ret=i-1;
	}
	for(;ret>=0;ret--){
		cout<<a[ret];
	}
	return 0;
}
