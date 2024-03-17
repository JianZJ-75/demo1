#include <bits/stdc++.h>
#define ll long long
#define double
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i--)

using namespace std;

string str;
int n;
set<pair<int, int>> ans;
bool pl[210][210];
bool lp[210][210];
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
pair<int, int> stk[100];

void dfs(int idx, int x, int y)
{
    int okl = 0;
    if (lp[x][y])
        okl = 1;
    lp[x][y] = true;
    if (idx >= n)
        if (!okl)
            lp[x][y] = false;
        ans.insert(make_pair(x - 100, y - 100));
        return;
    if (str[idx] == 'L')
    {
        int ok = 0;
        if (pl[x - 1][y])
            ok = 1;
        if (!ok)
        {
            dfs(idx + 1, x - 1, y);
            if (x - 1 != 100 || y != 100)
            {
                if (!lp[x - 1][y])
                {
                    pl[x - 1][y] = true;
                    dfs(idx + 1, x, y);
                    pl[x - 1][y] = false;
                }
            }
        }
        else
            dfs(idx + 1, x, y);
    }

    if (str[idx] == 'R')
    {
        int ok = 0;
        if (pl[x + 1][y])
            ok = 1;
        if (!ok)
        {
            dfs(idx + 1, x + 1, y);
            if (!lp[x + 1][y])
            {
                pl[x + 1][y] = true;
                dfs(idx + 1, x, y);
                pl[x + 1][y] = false;
            }
        }
        else
            dfs(idx + 1, x, y);
    }

    if (str[idx] == 'D')
    {
        int ok = 0;
        if (pl[x][y - 1])
            ok = 1;
        if (!ok)
        {
            dfs(idx + 1, x, y - 1);
            if (!lp[x][y - 1])
            {
                pl[x][y - 1] = true;
                dfs(idx + 1, x, y);
                pl[x][y - 1] = false;
            }
        }
        else
            dfs(idx + 1, x, y);
    }

    if (str[idx] == 'U')
    {
        int ok = 0;
        if (pl[x][y + 1])
            ok = 1;
        if (!ok)
        {
            dfs(idx + 1, x, y + 1);
            if (!lp[x][y + 1])
            {
                pl[x][y + 1] = true;
                dfs(idx + 1, x, y);
                pl[x][y + 1] = false;
            }
        }
        else
            dfs(idx + 1, x, y);
    }
    if (!okl)
        lp[x][y] = false;
}
void Jian()
{
    // cout << qmi(2,20);
    for (int i = 0; i <= 200; i++)
        for (int j = 0; j <= 200; j++)
            pl[i][j] = false, lp[i][j];
    cin >> n;
    cin >> str;
    dfs(0, 100, 100);
    cout << ans.size() << "\n";
    for (auto i : ans)
    {
        cout << i.first << " " << i.second << "\n";
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    // cin >> _;
    while (_--)
        Jian();
    return 0;
}