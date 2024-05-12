#include<bits/stdc++.h>
using namespace std;
int ex_gcd(int a,int &x,int b,int &y,int c){
	if(b==0){
		x=c/a;y=0;
		return a;
	}
	int d=ex_gcd(b,y,a%b,x,c);
	y=(y-(a/b)*x)%Mod;
	return d;
}
signed main(){
    return 0;
}
