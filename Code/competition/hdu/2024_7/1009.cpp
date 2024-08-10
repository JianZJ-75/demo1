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

const ll N = 1e5 + 1;
const ll MAX = 1e9;
ll n, k;
vector<pii> e[N];
ll tot[N];

void dfs(ll x, ll fa)
{
    for (auto i : e[x])
    {
        ll u = i.x, v = i.y;
        if (u == fa)
            continue;
        dfs(u, x);
        if (tot[u] <= MAX)
            tot[u] *= v;
        if (tot[x] <= MAX)
            tot[x] += tot[u];
    }
}

void Jian()
{
    n = read(), k = read();
    rep(i, 1, n)
    {
        e[i].clear();
        tot[i] = 0;
    }
    rep(i, 1, n)
    {
        int op = read();
        if (op) 
        {
            ll t = read();
            rep(j, 1, t)
            {
                ll x = read(), y = read();
                e[i].push_back({y, x});
            }
        } else 
            tot[i] = read();
    }
    dfs(k, 0);
    bool ok = 1;
    ll ans = 0;
    vector<ll> b;
    for (auto i : e[k])
        b.push_back(tot[i.x]);
    sort(b.begin(), b.end());
    ll len = b.size();
    ll cnt = 0;
    rep(i, 0, len - 2)
    {   
        if (b[i] > MAX)
            cnt++; 
        ans += b[i];
    }
    if (ans > MAX || cnt)
        cout << "Impossible\n";
    else
        cout << ans << endl;
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