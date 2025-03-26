#include <bits/stdc++.h>
#define ll long long
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i--)

using namespace std;

void Jian()
{
    ll n, q;
    cin >> n >> q;
    ll a[n + 1];
    rep(i, 1, n)
        cin >> a[i];
    sort(a + 1, a + 1 + n);
    ll pre[n + 1];
    pre[0] = 0;
    rep(i, 1, n)
        pre[i] = pre[i - 1] + a[i];
    ll ans = pre[n];
    ll mx = n;
    while (q--) {
        int op;
        cin >> op;
        if (op == 1) {
            ll v;
            cin >> v;
            ll l = 0, r = mx + 1;
            while (r - l > 1) {
                ll mid = (l + r) / 2;
                if (a[mid] < v)
                    l = mid;
                else
                    r = mid;    
            }
            if (r <= mx)
                a[r] = v;
            mx = min(r, mx);
            ans = pre[l] + v * (n - l);
        } else {
            cout << ans << endl;
        }
    }
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