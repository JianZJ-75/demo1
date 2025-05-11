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
#define mmax(a, b) (a) >= (b) ? (a) : (b)
#define mmin(a, b) (a) <= (b) ? (a) : (b)

using namespace std;

void f(int &x) {
    cout << x << endl;
}

void Jian() {
    int x = 1;
    int* y = &x;
    cout << *y << endl;
    f(x);
    int a[5] = {1, 2, 3, 4, 5};
    int b[5][5];
    rep(i, 0, 4)
        rep(j, 0, 4)
            b[i][j] = a[j];
    cout << b << endl;
    cout << *b << endl;
    cout << *(b + 1) << endl;
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