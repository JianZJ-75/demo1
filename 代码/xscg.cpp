#include <iostream>
#include <cmath>
#include <algorithm>
#define ll long long

using namespace std;

int gcd(int a,int b){
    if(a<b) swap(a,b);
    return b?gcd(b,a%b):a;
}

int jp(int a,int b){
    if(a<b) swap(a,b);
    int ret=1;
    if(a%b==0) ret=0;
    return ret;
}

int main(){
	int a,b,c,d;
    cin>>a>>b>>c>>d;
    int n;
    if(a==0||c==0){
        if(a==c) n=0;
        else n=1;
    }else{
	    int gcd1,gcd2,lcm1,lcm2;
	    gcd1=gcd(a,b);
	    gcd2=gcd(c,d);
	    a/=gcd1;
	    b/=gcd1;
	    c/=gcd2;
	    d/=gcd2;
		if(a==c&&b==d) n=0;
		else{
			int n1,n2;
			lcm1=a*c/gcd(a,c);
			if(lcm1!=a&&lcm1!=c) n1=2;
			else{
				if(b==d) n1=1;
				else n1=2;
			}
			lcm2=b*d/gcd(b,d);
			if(lcm2!=b&&lcm2!=d) n2=2;
			else{
				if(a==c) n2=1;
				else n2=2;
			}
			if(n1>n2) swap(n1,n2);
			n=n1;
		}
	}
    cout<<n;
	return 0;
} 
