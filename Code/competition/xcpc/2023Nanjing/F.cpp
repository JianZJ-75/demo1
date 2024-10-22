#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define endl '\n'
#define IOS ios::sync_with_stdio(false);cin.tie(0);cout.tie(0);

const ll N = 1e5 + 3;
ll pos[N];
ll p[N];
ll n, m;
unordered_set<ll> s[N];

void solve()
{
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
        pos[i] = 0;
    for (ll i = 1; i <= m; i++)
    {
        p[i] = 0;
        s[i].clear();
    }
    for (ll i = 1; i <= n; i++)
    {
        pos[i] = 0;
        ll pi;
        cin >> pi;
        for (ll j = 1; j <= pi; j++)
        {
            ll x;
            cin >> x;
            s[i].insert(x);
            p[x] = i;
        }
    }
    for (ll i = 1; i <= m; i++)
    {
        if (p[i] > 1 && s[p[i] - 1].count(i))
        {
            pos[p[i]] = 1;
        }
    }
    ll ans[n + 1];
    for (ll i = 1; i <= n; i++)
        ans[i] = i;
    ll ok = 0;
    for (ll i = 2; i <= n; i++)
    {
        if (!pos[i])
        {
            ok = 1;
            ans[i] = i - 1;
            ans[i - 1] = i;
            break;
        }
    }
    if (ok)
    {
        cout << "Yes\n";
        for (ll i = 1; i <= n; i++)
        {
            cout << ans[i];
            if (i == n)
                cout << endl;
            else
                cout << " ";
        }
    } else {
        cout << "No\n";
    }
}

signed main()
{
	IOS
    int _ = 1;
    cin >> _;
    while (_--)
    {
        solve();
    }
	return 0;
}