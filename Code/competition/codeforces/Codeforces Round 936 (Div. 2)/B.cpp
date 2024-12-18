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
            ret = ret * a % M;
        b /= 2;
        a = a * a % M;
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
    ll n, k;
    cin >> n >> k;
    ll a[n + 1];
    rep(i, 1, n)
        cin >> a[i];
    ll mx = 0, c = 0;
    rep(i, 1, n)
    {
        c = max(a[i], c + a[i]);
        mx = max(mx, c);
    }
    ll sum = 0;
    rep(i, 1, n)
        sum += a[i];
    sum %= M;
    mx %= M;
    cout << (M + sum + (M + qmi(2, k) - 1) % M * mx % M) % M << endl;
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