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
    ll n, l, d;
    cin >> n >> l >> d;
    ll a[n + 1];
    rep(i, 1, n)
        cin >> a[i];
    ll now = a[1];
    sort(a + 1, a + 1 + n);
    ll st = n + 1;
    rep(i, 1, n)
        if (a[i] >= l) {
            st = i;
            break;
        }
    st--;
    bool ok = 1;
    if (now >= l) {
        if (st < 3 || now - a[1] <= d)
            ok = 0;
    } else {
        if (st < 3 || a[n] - a[1] <= d)
            ok = 0;
    }
    cout << (ok ? "Yes\n" : "No\n");
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