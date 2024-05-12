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
const int N=20100;
const int M=201000;
template<typename T>
struct MinCostGraph{
    int s,t,vtot,head[N],etot;
    T dis[N],flow,cost;
    int pre[N];bool vis[N];
    struct edge{
        int v,nxt;
        T f,c;
    }e[M<<2];
    void addedge(int u,int v,T f,T c,T f2=0){
        e[etot]={v,head[u],f,c};
        head[u]=etot++;
        e[etot]={u,head[v],f2,-c};
        head[v]=etot++;
    }
    bool spfa(){
        T inf=numeric_limits<T>::max()/2;
        for(int i=1;i<=vtot;++i){
            dis[i]=inf;
            vis[i]=0;
            pre[i]=-1;
        }
        dis[s]=0;vis[s]=1;
        queue<int>q;q.push(s);
        while(!q.empty()){
            int u=q.front();
            for(int i=head[u];~i;i=e[i].nxt){
                int v=e[i].v;
                if(e[i].f&&dis[v]>dis[u]+e[i].c){
                    dis[v]=dis[u]+e[i].c;
                    pre[v]=i;
                    if(!vis[v]){
                        vis[v]=1;
                        q.push(v);
                    }
                }
            }
            q.pop();
            vis[u]=0;
        }
        return dis[t]!=inf;
    }
    void augment(){
        int u=t;
        T f=numeric_limits<T>::max();
        while(~pre[u]){
            f=min(f,e[pre[u]].f);
            u=e[pre[u]^1].v;
        }
        flow+=f;
        cost+=f*dis[t];u=t;
        while(~pre[u]){
            e[pre[u]].f-=f;
            e[pre[u]^1].f+=f;
            u=e[pre[u]^1].v;
        }
    }
    array<int,2> solve(){
        flow=0;cost=0;
        while(spfa())augment();
        return {flow,cost};
    }

    void init(int s_,int t_,int vtot_){
        s=s_;t=t_;vtot=vtot_;etot=0;
        for(int i=1;i<=vtot;++i)head[i]=-1;
    }
};
MinCostGraph<int>g;
int n,m;
int main(){
	n=read();m=read();g.init(1,n,n);
    for(int i=1;i<=m;i++){
        int u=read(),v=read(),f=read(),c=read();
        g.addedge(u,v,f,c);
    }
    array<int,2> it=g.solve();
    printf("%d %d",it[0],it[1]);
    return 0;
}
