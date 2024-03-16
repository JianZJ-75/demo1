#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#define ll long long
#define dd double

using namespace std;

int main(){
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		char a[1000000];
		cin>>a;
		int nn=strlen(a);
		int ret=1;
		int n_s=1,n_m=1,wz=0;
		if(nn!=1){
			for(int i=0;i<nn;i++){//ÅÐ¶ÏÊ××ÖÄ¸ÊýÁ¿ 
				wz=i;
				if(i>0&&a[i]!=a[i-1]) break;
				if(i>0&&a[i]==a[i-1]) n_s++;  
				if(n_s>1){
					ret=0;
					break;
				}
			}
			//cout<<"ret="<<ret<<endl;
			if(ret==0||a[wz]>a[wz-1]) cout<<a[0]<<a[0]<<endl;
			else{
				for(int i=0;i<nn;i++){
					//cout<<"i="<<i<<endl;
					if(i>0){
						wz=i;
						//if(a[i]>a[i-1]) break;
						if(a[i]>a[i-1]){
							wz--;
							break;
						}
						else if(a[i]==a[i-1]) n_m++;
						else n_m=1;
					}
				}
				cout<<"n_m="<<n_m<<" wz="<<wz<<endl;
				//if(n_m%2!=0) wz-=n_m/2;
				//if(wz+1==nn&&a[nn-1]!=a[nn-2]) wz++;
				cout<<"n_m="<<n_m<<" wz="<<wz<<endl;
				//cout<<"nn="<<nn<<endl;
				for(int i=0;i<=wz;i++) cout<<a[i];
				//for(int i=0;i<wz;i++) cout<<a[i];
				for(int i=wz;i>=0;i--) cout<<a[i];
				//for(int i=wz-1;i>=0;i--) cout<<a[i];
				cout<<endl;
			}
		}else cout<<a[0]<<a[0]<<endl;
	}
	return 0;
} 
