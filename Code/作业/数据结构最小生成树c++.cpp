#include <bits/stdc++.h>
#define ll long long
#define dd double
#define endl '\n'
#define x first
#define y second
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i--)

using namespace std;

struct Node
{
    ll y; // 边所到达顶点
    ll t; // 修建成本
    Node(ll y1, ll t1)
    {
        y = y1;
        t = t1;
    }
};

const ll N = 1000;
vector<Node> edge[N];
ll n;      // 点的个数
ll m;      // 边的个数
ll dist[N]; // dist记录每个点到顶点集的最短路
bool b[N]; // 判断是否加入顶点集

void Init()
{
    rep(i, 0, n)
        b[i] = 0,
        dist[i] = 0x3f;
}

int Prim(ll head)
{
    Init();
    dist[head] = 0;
    ll ans = 0; // 记录总成本
    ll cnt = 0; // 记录顶点集个数
    for (;;)
    {
        ll index = -1;
        rep(i, 1, n) // 遍历所有点寻找未加入顶点集的最小dist点
            if (!b[i] && dist[i] < dist[0]) 
                if (index == -1 || dist[i] < dist[index])
                    index = i;
        if (index == -1)
            break;
        cnt++;
        ans += dist[index];
        b[index] = 1;
        for (auto i : edge[index]) // 更新该节点所连顶点的dist
            if (i.t < dist[i.y])
                dist[i.y] = i.t;
    }
    if (cnt != n) // 如果不能生成最小生成树
        return -1;
    else
        return ans;
}

void Creat()
{
    cin >> n;
    m = n * (n - 1) / 2;
    rep(i, 1, m) // 建图
    {
        ll x, y, z, d;
        cin >> x >> y >> z >> d;
        if (d == 1) // 如果已修建,就把成本设为0
            z = 0;
        edge[x].push_back(Node(y, z));
        edge[y].push_back(Node(x, z));
    }
}

void run()
{
    Creat();
    ll ans = Prim(1);
    if (ans == -1)
        cout << "无法全省畅通！\n";
    else
        cout << "全省畅通需要的最低成本=" << ans;
}

int main()
{
    run();
    return 0;
}