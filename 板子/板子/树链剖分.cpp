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
int n;
struct Chain{
    struct Tr{
    	int Max,sum,l,r;
		#define l(p) tree[p].l
		#define r(p) tree[p].r
		#define Max(p) tree[p].Max
		#define sum(p) tree[p].sum
	}tree[N<<2];
	void build(int p,int l,int r){
		l(p)=l;r(p)=r;
		if(l==r){
			sum(p)=Max(p)=w[id[l]];
			return ;
		}
		int mid=l+r>>1;
		build(p<<1,l,mid);
		build(p<<1|1,mid+1,r);
		sum(p)=sum(p<<1)+sum(p<<1|1);
		Max(p)=max(Max(p<<1),Max(p<<1|1));
	}
	void change(int p,int x,int z){
		if(l(p)==r(p)){
			sum(p)=Max(p)=z;
			return ;
		}
		int mid=l(p)+r(p)>>1;
		if(x<=mid)change(p<<1,x,z);
		  else change(p<<1|1,x,z);
		sum(p)=sum(p<<1)+sum(p<<1|1);
		Max(p)=max(Max(p<<1),Max(p<<1|1));
	}
	int ask_Max(int p,int l,int r){
		if(l(p)>=l&&r(p)<=r)return Max(p);
		int mid=l(p)+r(p)>>1,Max=-INT_MAX;
		if(l<=mid)Max=max(Max,ask_Max(p<<1,l,r));
		if(r>mid)Max=max(Max,ask_Max(p<<1|1,l,r));
		return Max;
	}
	int ask_sum(int p,int l,int r){
		if(l(p)>=l&&r(p)<=r)return sum(p);
		int mid=l(p)+r(p)>>1,sum=0;
		if(l<=mid)sum+=ask_sum(p<<1,l,r);
		if(r>mid)sum+=ask_sum(p<<1|1,l,r);
		return sum;
	}
	
	
	struct cow{
		int x,y;
	}e[N<<1];int head[N],tot,w[N],id[N],dfn[N];
	void inse(int xxxx,int yyyy){
		e[++tot].x=head[xxxx];
		head[xxxx]=tot;
		e[tot].y=yyyy;
	}
	int fa[N],dep[N],sz[N],hv[N];
	void dfs1(int x,int f){
		dep[x]=dep[f]+1;sz[x]=1;fa[x]=f;
		for(int i=head[x];i;i=e[i].x){
			int y=e[i].y;
			if(y==f)continue;
			dfs1(y,x);sz[x]+=sz[y];
			if(sz[y]>sz[hv[x]])
			  hv[x]=y;
		}
	}
	int top[N];
	void dfs2(int x,int t){
		top[x]=t;dfn[x]=++tot;id[tot]=x;
		if(hv[x]==0)return ;
		dfs2(hv[x],t);
		for(int i=head[x];i;i=e[i].x){
			int y=e[i].y;
			if(y==fa[x]||y==hv[x])continue;
			dfs2(y,y);
		}
    }
	void build_tree(){
		for(int i=1;i<n;i++){
			int x=read(),y=read();
			inse(x,y);inse(y,x);
		}
		for(int i=1;i<=n;i++)w[i]=read();
		dfs1(1,0);tot=0;dfs2(1,1);build(1,1,n);
	}
	int Ask_Max(int x,int y){
		int Max=-INT_MAX;
		while(top[x]!=top[y]){
			if(dep[top[x]]<dep[top[y]])swap(x,y);
			Max=max(Max,ask_Max(1,dfn[top[x]],dfn[x]));
			x=fa[top[x]];
		}
		if(dep[x]<dep[y])swap(x,y);
		Max=max(Max,ask_Max(1,dfn[y],dfn[x]));
		return Max;
	}
	int Ask_sum(int x,int y){
		int sum=0;
		while(top[x]!=top[y]){
			if(dep[top[x]]<dep[top[y]])swap(x,y);
			sum+=ask_sum(1,dfn[top[x]],dfn[x]);
			x=fa[top[x]];
		}
		if(dep[x]<dep[y])swap(x,y);
		sum+=ask_sum(1,dfn[y],dfn[x]);
		return sum;
	}
}T;
signed main(){
	n=read();T.build_tree();
	int q=read();
	while(q--){
		char op[10];scanf("%s",op+1);
		if(op[1]=='Q'){
			if(op[2]=='M')printf("%d\n",T.Ask_Max(read(),read()));
			  else printf("%d\n",T.Ask_sum(read(),read()));
		}
		else{
			int l=T.dfn[read()],t=read();
			T.change(1,l,t);
		}
	}
	return 0;
}
