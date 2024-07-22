#include <bits/stdc++.h>
#define MAXN 100010
using namespace std;
int kmp1[MAXN];
int kmp2[MAXN];
int la, lb, j;
char a[MAXN], b[MAXN], c[MAXN], d[MAXN];
void akmp()
{
    for (int i = 2; i <= lb; i++)
    {
        while (j && b[i] != b[j + 1])
            j = kmp2[j];
        if (b[j + 1] == b[i])
            j++;
        kmp2[i] = j;
    }
}
void bkmp()
{
    for (int i = 2; i <= la; i++)
    {
        while (j && a[i] != a[j + 1])
            j = kmp1[j];
        if (a[j + 1] == a[i])
            j++;
        kmp1[i] = j;
    }
}
int main()
{
    int t;
    scanf("%d", &t);
    while (t--)
    {
        int n;
        scanf("%d%s%s", &n, a + 1, b + 1);
        int ans[n + 10];
        int idx = 1;
        la = strlen(a + 1);
        lb = strlen(b + 1);
        j = 0;
        akmp();
        j = 0;
        bkmp();

        for (int i = 1; i <= n; i++)
        {
            scanf("%s%s", c + 1, d + 1);
            j = 0;
            lb = strlen(c + 1);
            la = strlen(a + 1);
            int ok = 0;
            for (int i = 1; i <= la; i++)
            {
                while (j > 0 && a[i] != c[j + 1])
                    j = kmp1[j];
                if (c[j + 1] == a[i])
                    j++;
                if (j == lb)
                {
                    ok = 1;
                    break;
                }
            }
            if (!ok)
                continue;

            j = 0;
            ok = 0;
            la = strlen(d + 1);
            lb = strlen(b + 1);
            for (int i = 1; i <= la; i++)
            {
                while (j > 0 && b[j + 1] != d[i])
                    j = kmp2[j];
                if (b[j + 1] == d[i])
                    j++;
                if (j == lb)
                {
                    ok = 1;
                    break;
                }
            }
            if (ok)
            {
                ans[idx++] = i;
            }
        }

        for (int i = 1; i < idx; i++)
        {
            if (i != idx - 1)
                cout << ans[i] << " ";
            else
                cout << ans[i] << "\n";
        }
    }
    return 0;
}