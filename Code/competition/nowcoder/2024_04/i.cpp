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

bool cmp(ll a, ll b) {
    return a > b;
}

void Jian()
{
    ll n, m;
    cin >> n >> m;
    vector<ll> g[n + 1];
    rep(i, 1, m)
    {
        ll u, v;
        cin >> u >> v;
        g[v].push_back(u);
    }
    ll l[n + 1];
    rep(i, 1, n)
    {
        sort(g[i].begin(), g[i].end(), cmp);
        ll now = i - 1;
        for (auto x : g[i])
        {
            if (x != now)
                break;
            now--;
        }
        l[i] = now + 1;
    }
    ll p = 1;
    ll ans = 0;
    rep(i, 1, n)
    {
        while (p < n && l[p + 1] <= i)
            p++;
        ans += p - i + 1;
    }
    cout << ans << endl;
}

signed main()
{
    srand(time(0));
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    // cin >> _;
    while (_--)
        Jian();
    return 0;
}