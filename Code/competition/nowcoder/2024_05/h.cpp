#include <bits/stdc++.h>
#define ll long long
#define dd double
#define endl '\n'
#define pii pair<ll, ll>
#define x first
#define y second
#define rep(i, a, b) for (int i = a; i <= b; i++)
#define rrep(i, a, b) for (int i = a; i >= b; i--)
#define INF 0x3f3f3f3f
#define LINF 0x3f3f3f3f3f3f3f3f
const ll M = 1e9 + 7;

using namespace std;

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

const int N = 50;
int n, m;
vector<int> e[N];
ll p[N];
int dep[N], ans;

void dfs(int x, int fa, ll state)
{
    dep[x] = dep[fa] + 1;
    ans = max(ans, dep[x]);
    for (auto i : e[x]) 
    {
        if ((1ll << i) & state == 1)
            continue;
        dfs(i, x, state | p[x]);
    }
}

void Jian()
{
    n = read();
    m = read();
    rep(i, 1, m)
    {
        int u = read(), v = read();
        e[u].push_back(v);
        e[v].push_back(u);
    }
    rep(i, 1, n)
        for (auto j : e[i])
            p[i] |= (1ll << j);
    ans = 1;
    rep(i, 1, n)
    {
        dep[i] = 0;
        dfs(i, 0, (1ll << i));
    }
    printf("%d", ans);
}

signed main()
{
    srand(time(0));
    // ios::sync_with_stdio(false);
    // cin.tie(0);
    // cout.tie(0);
    int _ = 1;
    // cin >> _;
    while (_--)
        Jian();
    return 0;
}