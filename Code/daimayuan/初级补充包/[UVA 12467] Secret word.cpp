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
    string s;
    cin >> s;
    ll n = s.length();
    string t = s;
    reverse(t.begin(), t.end());
    s = " "  + s + "#" + t;
    ll nxt[n + 2 + n] = {0};
    ll j = 0;
    rep(i, 2, 2 * n + 1)
    {
        while (j && s[j + 1] != s[i])
            j = nxt[j];
        if (s[j + 1] == s[i])
            j++;
        nxt[i] = j;
    }
    ll ans = 0;
    rep(i, n + 1, 2 * n + 1)
        ans = max(ans, nxt[i]);
    rrep(i, ans, 1)
        cout << s[i];
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