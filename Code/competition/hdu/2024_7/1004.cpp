#include <bits/stdc++.h>
#define ll long long
#define dd double
#define endl '\n'
#define pii pair<ll, ll>
#define x first
#define y second
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i--)
#define INF 0x3f3f3f3f
#define LINF 0x3f3f3f3f3f3f3f3f

using namespace std;

ll read()
{
    ll x = 0, f = 1; char c = getchar();
    while (c < '0' || c > '9') { if (c == '-') f = -1; c = getchar(); }
    while (c >= '0' && c <= '9') { x = x * 10 + c - '0'; c = getchar(); }
    return x * f;
}

const ll N = 2e6 + 1;
ll n, s, r1, r2;
vector<ll> e[N];
ll dp[N];
ll mx;

void dfs(ll x, ll fa) {
    dp[x] = 0;
    for (auto y : e[x])
    {
        if (y == fa)
            continue;
        dfs(y, x);
        mx = max(mx, dp[x] + dp[y] + 1);
        dp[x] = max(dp[x], dp[y] + 1);
    }
}

void Jian()
{
    n = read(), s = read(), r1 = read(), r2 = read();
    rep(i, 1, n)
        e[i].clear();
    rep(i, 1, n - 1)
    {
        ll u = read(), v = read();
        e[u].push_back(v);
        e[v].push_back(u);
    }
    mx = 0;
    dfs(1, 0);
    if (2 * r1 >= mx || 2 * r1 >= r2)
        cout << "Kangaroo_Splay\n";
    else
        cout << "General_Kangaroo\n";
}

signed main()
{
    srand(time(0));
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    _ = read();
    while (_--)
        Jian();
    return 0;
}