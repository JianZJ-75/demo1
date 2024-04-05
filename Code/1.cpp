#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10;
int n, p[N], d[N];
void solved()
{
    cin >> n;
    for (int i = 2; i <= n; i++)
    {
        cin >> p[i];
        d[p[i]]++;
    }
    queue<int> q;
    for (int i = 1; i <= n; i++)
        if (d[i] == 0)
            q.push(i);
    int Min = q.size(), sz = 0;
    while (!q.empty())
    {
        sz++;
        int now = q.size();
        for (int i = 1; i <= now; i++)
        {
            int x = q.front();
            q.pop();
            d[p[x]]--;
            if (d[p[x]] == 0)
                q.push(p[x]);
        }
        Min = min(Min, sz + (int)q.size());
    }
    cout << Min << endl;
}

signed main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int _ = 1;
    cin >> _;
    while (_--)
        solved();
    return 0;
}
