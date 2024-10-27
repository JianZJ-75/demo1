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
#define mmax(a, b) (a) >= (b) ? (a) : (b)
#define mmin(a, b) (a) <= (b) ? (a) : (b)

using namespace std;

ll read()
{
    ll x = 0, f = 1; char c = getchar();
    while (c < '0' || c > '9') { if (c == '-') f = -1; c = getchar(); }
    while (c >= '0' && c <= '9') { x = x * 10 + c - '0'; c = getchar(); }
    return x * f;
}

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

const ll N = 2e5 + 10;
ll d[N], a[N];
ll n, m;

bool check(ll x)
{
    rep(i, 1, n + 2)
        d[i] = 0;
    ll cnt = 0;
    rep(i, 1, n)
    {
        if (d[i] >= x)
        {
            cnt++;
        } else {
            ll tmp = (x - d[i]) / a[i] + (bool) ((x - d[i]) % a[i]);
            cnt += 2 * tmp - 1;
            if (cnt > m)
                return false;
            d[i + 1] += (tmp - 1) * a[i + 1];
        }
    }
    return true;
}

void Jian()
{
    cin >> n >> m;
    rep(i, 1, n)
        cin >> a[i];
    ll l = 0, r = 1e18;
    while (r - l > 1)
    {
        ll mid = (l + r) / 2;
        if (check(mid))
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