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
    ll n;
    cin >> n;
    ll m = 2 * n - 1;
    ll a[m + 1];
    rep(i, 1, m)   
        cin >> a[i];
    ll t = a[1];
    rep(i, 2, m)
        t ^= a[i];
    cout << t << endl;
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