#include <bits/stdc++.h>
#define ll long long
#define dd double
#define endl '\n'
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i--)
const int M = 1e9 + 7;

using namespace std;

ll a[10][10] = {
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    {1, 2, 2, 2, 2, 2, 2, 2, 2, 1},
    {1, 2, 3, 3, 3, 3, 3, 3, 2, 1},
    {1, 2, 3, 4, 4, 4, 4, 3, 2, 1},
    {1, 2, 3, 4, 5, 5, 4, 3, 2, 1},
    {1, 2, 3, 4, 5, 5, 4, 3, 2, 1},
    {1, 2, 3, 4, 4, 4, 4, 3, 2, 1},
    {1, 2, 3, 3, 3, 3, 3, 3, 2, 1},
    {1, 2, 2, 2, 2, 2, 2, 2, 2, 1},
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
};

void Jian()
{
    string s[10];
    rep(i, 0, 9)
        cin >> s[i];
    ll sum = 0; // 分数
    ll k = 0;   // 次数
    rep(i, 0, 9)
        rep(j, 0, 9) if (s[i][j] == 'X')
    {
        k++;
        sum += a[i][j];
    }
    if (k * 30 > sum * 10)
        cout << "zwxggyyds!\n";
    else if (k * 30 < sum * 10)
        cout << "szaggyyds!\n";
    else
        cout << sum << endl;
}

int main()
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