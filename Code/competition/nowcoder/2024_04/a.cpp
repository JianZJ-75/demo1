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

const ll N = 1e6 + 10;
ll fa[N], dep[N], ans[N];
ll n;

ll find(ll x)
{
    if (fa[x] == x)
        return x;
    ll tmp = find(fa[x]);
    dep[x] += dep[fa[x]];
    return fa[x] = tmp;
}

void Jian()
{
    cin >> n;
    rep(i, 0, n)
    {
        fa[i] = i;
        dep[i] = ans[i] = 0;
    }
    rep(i, 2, n)
    {
        ll a, b, c;
        cin >> a >> b >> c;
        fa[b] = a;
        dep[b] = 1;
        find(b);
        ans[find(a)] = max(ans[find(a)], ans[b] + dep[b]);
        cout << ans[c] << " ";
    }
    cout << endl;
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