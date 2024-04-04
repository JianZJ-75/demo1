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

struct P
{
    string s;
    ll len;
};

bool cmp(P a, P b)
{
    return a.len < b.len;
}

void Jian()
{
    ll n;
    cin >> n;
    P a[n + 1];
    rep(i, 1, n)
    {
        cin >> a[i].s;
        a[i].len = a[i].s.length();
    }
    sort(a + 1, a + 1 + n, cmp);
    map<string, bool> mp;
    ll ans = 0;
    rep(i, 1, n)
    {
        if (a[i].len == 1)
        {
            mp[a[i].s] = 1;
            ans = 1;
        } else
        {
            if (mp[a[i].s.substr(1)] && mp[a[i].s.substr(0, a[i].len - 1)])
            {
                mp[a[i].s] = 1;
                ans = a[i].len;
            }
        }
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