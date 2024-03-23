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

ll qmi(ll a, ll b)
{
    ll ret = 1;
    while (b)
    {
        if (b & 1)
            ret = ret * a;
        b /= 2;
        a = a * a;
    }
    return ret;
}

ll gcd(ll a, ll b)
{
    if (a < b)
        swap(a, b);
    return b ? gcd(b, a % b) : a;
}

const ll N = 1e5 + 10;
vector<ll> edges[N];
ll sz[N];
ll n, k, cnt;

void dfs(ll x, ll fa, ll mid)
{
    sz[x] = 1;
    for (auto i : edges[x])
    {
        if (i == fa)
            continue;
        dfs(i, x, mid);
        if (sz[i] >= mid)
        {
            cnt++;
            continue;
        }
        sz[x] += sz[i];
    }
}

bool ok(ll x)
{
    memset(sz, 0, sizeof(sz));
    cnt = 0;
    dfs(1, -1, x);
    if (sz[1] < x)
        cnt--;
    return cnt >= k;
}

void Jian()
{
    cin >> n >> k;
    rep(i, 1, n)
        edges[i].clear();
    rep(i, 1, n - 1)
    {
        ll u, v;
        cin >> u >> v;
        edges[u].push_back(v);
        edges[v].push_back(u);
    }
    ll l = 0, r = n + 1;
    while (r - l > 1)
    {
        ll mid = (l + r) / 2;
        if (ok(mid))
            l = mid;
        else
            r = mid;
    }
    cout << l << endl;
}

signed main()
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