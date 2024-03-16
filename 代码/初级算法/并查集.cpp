#include <bits/stdc++.h>
#define ll long long
#define dd double
#define endl '\n'
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i--)
const int M = 1e9 + 7;

using namespace std;
// 并查集 O(mlog(n))
const int N = 2e5 + 10;
int fa[N];             // 每个节点的代表元素
int sz[N];             // 每个节点所在树的总节点数
int dep[N];            // 每个节点的深度
void Initialize(int n) // 初始化
{
    rep(i, 1, n)
    {
        fa[i] = i;
        sz[i] = dep[i] = 1;
    }
}
int Findset(int x) // 查找代表元素
{
    if (fa[x] == x)
        return x;
    fa[x] = Findset(fa[x]);
    return fa[x];
}
void Union1(int x, int y) // 合并
{
    int fx = Findset(x), fy = Findset(y);
    if (fx == fy)
        return;
    fa[fx] = fy;
}
void Union2(int x, int y) // 启发式合并
{
    int fx = Findset(x), fy = Findset(y);
    if (fx == fy)
        return;
    if (sz[fx] > sz[fy])
        swap(fx, fy);
    fa[fx] = fy;
    sz[fy] += sz[fx];
}
void Union3(int x, int y) // 按深度合并
{
    int fx = Findset(x), fy = Findset(y);
    if (fx == fy)
        return;
    if (dep[fx] > dep[fy])
        swap(fx, fy);
    fa[fx] = fy;
    if (dep[fx] == dep[fy])
        dep[fy]++;
}
void Jian()
{
}

int main()
{
    srand(time(0));
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    cin >> _;
    while (_--)
        Jian();
    return 0;
}