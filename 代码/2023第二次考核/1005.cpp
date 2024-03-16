#include <bits/stdc++.h>
#define ll long long
#define dd double
#define endl '\n'
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i--)
const int M = 1e9 + 7;

using namespace std;

void Jian()
{
    ll n, m;
    cin >> n >> m;
    ll a[n + 1];
    rep(i, 1, n)
        cin >> a[i];
    ll k = 2;
    ll sum = 0;
    while (m--)
    {
        rep(i, 1, n) 
            if (a[i] > 0)
            {
                a[i] -= k;
                if (a[i] == 0)
                    k += 2;
            }
        sum += k;
    }
    cout << sum << endl;
}

int main()
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