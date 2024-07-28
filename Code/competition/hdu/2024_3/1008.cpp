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
const ll M = 1e9 + 7;

using namespace std;

const ll N = 1e5 + 10;
ll n, m, k;
ll dis[N];
vector<pii> e[N];
bool pos[N];
priority_queue<pii> q;

void Jian()
{
    cin >> n >> m >> k;
    rep(i, 1, n)
        e[i].clear();
    while (!q.empty())
        q.pop();
    rep(i, 1, m)
    {
        ll u, v, t;
        cin >> u >> v >> t;
        e[u].push_back({v, t});
        e[v].push_back({u, t});
    }
    rep(i, 1, n)
    {
        pos[i] = 0;
        dis[i] = INF;
    }
    dis[1] = 0;
    q.push({0, 1});
    rep(i, 2, n)
    {
        dis[i] = k * (i | 1);
        q.push({-dis[i], i});
    }
    while (!q.empty())
    {
        ll u = q.top().y;
        q.pop();
        if (pos[u])
            continue;
        pos[u] = 1;
        for (auto i : e[u])
        {
            ll v = i.x, d = i.y;
            if (dis[v] > dis[u] + d)
            {
                dis[v] = dis[u] + d;
                if (!pos[v])
                    q.push({-dis[v], v});
            }
        }
        if (u % 2)
            continue;
        for (ll v = u; v <= n; v = u | (v + 1))
        {
            ll d = v * k;
            if (dis[v] > dis[u] + d)
            {
                dis[v] = dis[u] + d;
                if (!pos[v])
                    q.push({-dis[v], v});
            }
        }
    }
    rep(i, 2, n)
        cout << dis[i] << " ";
}

signed main()
{
    srand(time(0));
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    ll _ = 1;
    cin >> _;
    while (_--)
        Jian();
    return 0;
}