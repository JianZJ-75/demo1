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
const ll mod = 998244353;

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

// 1 1
// 2 1+1
// 3 1+1+1
// 4 1+2+1+1
// 5 1+2+2+1+1

const ll N = 1e6 + 10;
ll f[N];
ll ans[N];

void Jian()
{
    ll n;
    cin >> n;
    f[1] = 1;
    rep(i, 2, n) {
        f[i] = f[i - 1] + f[i - 2];
        f[i] %= mod;
    }
    rep(i, 1, n) {
        rep(j, 1, n / i)
            ans[i * j] += f[i],
            ans[i * j] %= mod;
    }
    rep(i, 1, n)
        cout << ans[i] << " ";
    cout << endl;
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