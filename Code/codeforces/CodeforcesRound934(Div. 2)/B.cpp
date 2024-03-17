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
    ll n, k;
    cin >> n >> k;
    ll a[n + 1], b[n + 1];
    map<ll, ll> mp1, mp2;
    rep(i, 1, n)
            cin >>
        a[i],
        mp1[a[i]]++;
    rep(i, 1, n)
            cin >>
        b[i],
        mp2[b[i]]++;
    vector<ll> l, r;
    rep(i, 1, n)
    {
        if (mp1[i] == 2)
        {
            l.push_back(i);
            l.push_back(i);
        }
        if (mp2[i] == 2)
        {
            r.push_back(i);
            r.push_back(i);
        }
    }
    while (l.size() != r.size())
    {
        if (l.size() > r.size())
            l.pop_back();
        if (l.size() < r.size())
            r.pop_back();
    }
    rep(i, 1, n)
    {
        if (mp1[i] == 1)
        {
            l.push_back(i);
            r.push_back(i);
        }
    }
    rep(i, 0, 2 * k - 1)
        cout << l[i] << " ";
    cout << endl;
    rep(i, 0, 2 * k - 1)
        cout << r[i] << " ";
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