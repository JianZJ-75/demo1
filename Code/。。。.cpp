#include <bits/stdc++.h>
using namespace std;
const int N = 50;
#define ll long long
int read()
{
    int num = 0;
    bool flag = 1;
    char c = getchar();
    for (; c < '0' || c > '9'; c = getchar())
        if (c == '-')
            flag = 0;
    for (; c >= '0' && c <= '9'; c = getchar())
        num = (num << 1) + (num << 3) + c - '0';
    return flag ? num : -num;
}
int n, m, Max, dep[N];
vector<int> e[N];
ll p[N];
void dfs(int x, int fa, ll state)
{
    dep[x] = dep[fa] + 1;
    Max = max(Max, dep[x]);
    for (auto y : e[x])
    {
        if ((1ll << y) & state)
            continue;
        dfs(y, x, state | p[x]);
    }
}
signed main()
{
    n = read();
    m = read();
    for (int i = 1; i <= m; i++)
    {
        int u = read(), v = read();
        if (u == v)
            continue;
        e[u].push_back(v);
        e[v].push_back(u);
    }
    for (int i = 1; i <= n; i++)
    {
        for (auto j : e[i])
            p[i] |= (1ll << j);
    }
    Max = 1;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
            dep[i] = 0;
        dfs(i, 0, (1ll << i));
    }
    printf("%d", Max);
    return 0;
}