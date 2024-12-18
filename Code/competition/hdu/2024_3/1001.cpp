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

const ll N = 1e6 + 10;
ll f[N];
ll ans[N];
ll n;

void Jian()
{
    cin >> n;
    f[1] = 1;
    rep(i, 1, n)
    {
        for (ll j = i; j < n; j += i)
            f[j + 1] += f[i],
            f[j + 1] %= mod;
        for (ll j = i; j <= n; j += i)
            ans[j] += f[i],
            ans[i] %= mod;
        cout << ans[i] << " ";
    }
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