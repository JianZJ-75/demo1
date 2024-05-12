#include<bits/stdc++.h>
using namespace std;
int read(){
	int num=0;bool flag=1;
	char c=getchar();
	for(;c<'0'||c>'9';c=getchar())
	  if(c=='-')flag=0;
	for(;c>='0'&&c<='9';c=getchar())
	  num=(num<<1)+(num<<3)+c-'0';
	return flag?num:-num;
}
const int N=1e5+10;
int n,q;
#define ll long long
struct Tree{
	struct cow{
		int ls,rs;
		ll sum,lazy;
	}tree[N<<2];int tot=1;
	#define ls(p) tree[p].ls
	#define rs(p) tree[p].rs
	#define sum(p) tree[p].sum
	#define lazy(p) tree[p].lazy
	void chck_new(int p){
		if(!ls(p))ls(p)=++tot;
		if(!rs(p))rs(p)=++tot;
	}
	void lazytime(int p,int l,int r){
		int mid=l+r-1>>1;
		sum(ls(p))+=lazy(p)*(mid-l+1);
		sum(rs(p))+=lazy(p)*(r-mid);
		lazy(ls(p))+=lazy(p);
		lazy(rs(p))+=lazy(p);
		lazy(p)=0;
	}
	void add(int p,int l,int r,int L,int R,ll d){
		if(l>=L&&r<=R){
			sum(p)+=d*(r-l+1);
			lazy(p)+=d;return ;
		}
		chck_new(p);lazytime(p,l,r);
		int mid=l+r-1>>1;
		if(L<=mid)add(ls(p),l,mid,L,R,d);
		if(R>mid)add(rs(p),mid+1,r,L,R,d);
		sum(p)=sum(ls(p))+sum(rs(p));
	}
	ll ask(int p,int l,int r,int L,int R){
		if(l>=L&&r<=R)return sum(p);
		chck_new(p);lazytime(p,l,r);
		int mid=l+r-1>>1;ll ans=0;
		if(L<=mid)ans+=ask(ls(p),l,mid,L,R);
		if(R>mid)ans+=ask(rs(p),mid+1,r,L,R);
		return ans;
	}
}T;
int main(){
	n=read();q=read();
	for(int i=1;i<=n;i++)
	  T.add(1,1,n,i,i,read());
	for(int i=1;i<=q;i++){
		int op=read();
		if(op==1){
			int x=read(),y=read(),k=read();
			T.add(1,1,n,x,y,k);
		}
		else{
			int x=read(),y=read();
			printf("%lld\n",T.ask(1,1,n,x,y));
		}
	}
	return 0;
}