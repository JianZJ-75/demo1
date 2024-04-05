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

void Jian()
{
    ll n;
    cin >> n;
    queue<ll> q;
    ll p[n + 1] = {0}, d[n + 1] = {0};
    rep(i, 2, n)
    {
        cin >> p[i];
        d[p[i]]++;
    }
    rep(i, 1, n)
        if (d[i] == 0)
            q.push(i);
    ll ans = q.size();
    ll t = 0;
    while (!q.empty())
    {
        t++;
        ll now = q.size();
        rep(i, 1, now)
        {
            ll x = q.front();
            q.pop();
            d[p[x]]--;
            if (d[p[x]] == 0)
                q.push(p[x]);
        }
        ans = min(ans, t + (ll) q.size());
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
    cin >> _;
    while (_--)
        Jian();
    return 0;
}