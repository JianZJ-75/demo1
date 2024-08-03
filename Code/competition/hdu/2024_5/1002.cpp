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
    ll a[n + 1];
    rep(i, 1, n)
        cin >> a[i];
    sort(a + 1, a + 1 + n);
    ll d = 0;
    ll ans = n + 1;
    rep(i, 1, n)
        d = gcd(d, a[i]);
    if (a[1] == d)
        ans = n - 1;
    rep(i, 1, n)
    {
        rep(j, i + 1, n)
        {
            d = a[j] % a[i];
            if (!d)
                continue;
            bool ok = 1;
            rep(k, 1, n)
                if (j != k && a[k] % d)
                    ok = 0;
            if (ok)
                ans = min(ans, n);
        }
    }
    d = 0;
    rep(i, 2, n)
        if (a[i] % a[1])
            d = gcd(d, a[i]);
    if (d == 0 || d >= a[1])
        ans = min(ans, n);
    rep(i, 1, n)
    {
        ll mi = LINF;
        d = 0;
        rep(j, 1, n)
        {
            if (i != j && a[j] % a[i])
            {
                mi = min(mi, a[j]);
                d = gcd(d, a[j]);
            }
        }
        if (d == 0 || d == mi)
            ans = min(ans, n);
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