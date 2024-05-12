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
const int N=110;
const int M=5010;
template<typename T>
struct FlowGraph{
	int s,t,vtot;
	int head[N],etot;
	int dis[N],cur[N];
	struct edge{
		int v,nxt;T f;
	}e[M<<1];
	void addedge(int u,int v,T f,T f2=0){
		e[etot]={v,head[u],f};head[u]=etot++;
		e[etot]={u,head[v],f2};head[v]=etot++;
	}
	bool bfs(){
		for (int i=1;i<=vtot;i++){
			dis[i]=0;
			cur[i]=head[i];
		}
		queue<int>q;q.push(s);dis[s] = 1;
		while(!q.empty()){
			int u=q.front();q.pop();
			for (int i=head[u];~i;i=e[i].nxt){
				if(e[i].f&&!dis[e[i].v]){
					int v=e[i].v;
					dis[v]=dis[u] + 1;
					if(v==t) return 1;
					q.push(v);
				}
			}
		}
		return 0;
	}
	T dfs(int u, T m) {
		if (u==t)return m;
		T flow=0;
		for (int i=cur[u];~i;cur[u]=i=e[i].nxt)
			if (e[i].f&&dis[e[i].v]==dis[u]+1){
				T f=dfs(e[i].v,min(m, e[i].f));
				e[i].f-=f;e[i^1].f+=f;
				m-=f;flow+=f;
				if(!m)break;
			}
		if(!flow) dis[u]=-1;
		return flow;
	}
	T dinic(){
		T flow=0;
		while(bfs())
		  flow+=dfs(s,numeric_limits<T>::max());
		return flow;
	}
	void init(int s_,int t_,int vtot_){
		s=s_;t=t_;vtot=vtot_;etot=0;
		for(int i=1;i<=vtot;i++)head[i]=-1;
	}
};
FlowGraph<long long>g;
int n,m,s,t;
int main(){
	n=read();m=read();
	s=read();t=read();
	g.init(s,t,n);
	for(int i=1;i<=m;i++){
		int x=read(),y=read(),z=read();
		g.addedge(x,y,z);
	}
	printf("%lld\n",g.dinic());
	return 0;
}

