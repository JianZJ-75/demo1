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

ll calc(ll x)
{
    ll res = 0;
    for (ll i = x; i; i /= 3)
        res += 1 + i % 3;
    return res;
}

void Jian()
{
    ll l, r;
    cin >> l >> r;
    ll ans = calc(r);
    vector<ll> q;
    for (ll i = r; i; i /= 3)
        q.push_back(i % 3);
    reverse(q.begin(), q.end());
    ll n = q.size();
    rep(i, 0, n - 1)
    {
        if (q[i] == 0)
            continue;
        ll x = 0;
        rep(j, 0, i)
            x = x * 3 + q[j];
        x--;
        rep(j, i + 1, n - 1)
            x = x * 3 + 2;
        if (x >= l)
            ans = max(ans, calc(x));
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