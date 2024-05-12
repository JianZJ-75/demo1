#include<bits/stdc++.h>
using namespace std;
#define ll long long
ll read(){
	ll num=0;bool flag=1;
	char c=getchar();
	for(;c<'0'||c>'9';c=getchar())
	  if(c=='-')flag=0;
	for(;c>='0'&&c<='9';c=getchar())
	  num=(num<<1)+(num<<3)+c-'0';
	return flag?num:-num;
}
const int B=60;
struct linear_basis{
	ll num[B+10];int hv;
	bool insert(ll x){
		for(int i=B-1;i>=0;i--){
			if(x>>i&1){
				if(num[i]==0){
					num[i]=x;
					hv++;
					return 1;
				}
				x^=num[i];
			}
		}
		return 0;
	}
	ll querymin(ll x){
		for(int i=B-1;i>=0;i--)
		  x=min(x,x^num[i]);
		return x;
	}
	ll querymax(ll x){
		for(int i=B-1;i>=0;i--)
		  x=max(x,x^num[i]);
		return x;
	}
	//x异或集合内的最小/最大值 
}ba;
//**注意题目有没有可以选空集的情况，如果没有要这个线性空间是不一定能够表示0的**
//如果存在insert中有false的，这个就能表示0 
int n;ll k;
signed main(){
	n=read();k=read();ll now=1;
	for(int i=1;i<=n;i++)
	  if(!ba.insert(read()))
	    now*=2;
	k=k/now;ll ans=0;
	for(int i=B-1;i>=0;i--){
		if(ba.num[i]==0)continue;
		if(k>=(1ll<<ba.hv-1)){
			k-=(1ll<<ba.hv-1);
			ans=max(ans,ans^ba.num[i]);
		}
		else ans=min(ans,ans^ba.num[i]);
		ba.hv--;
	}
	printf("%lld\n",ans);
	return 0;
} 
