#include <bits/stdc++.h>
#define ll long long
#define dd double

using namespace std;

void Jian()
{
    int n;
    cin >> n;
    int a = log2(n) + 1;
    int er[a];
    for (int i = 0; i < a; i++)
    {
        er[i] = (n >> i & 1);
    }
    for (int i = a - 1; i >= 0; i--)
        cout << er[i];
    cout << endl;
}

int main()
{
    int t = 1;
    cin >> t;
    while (t--)
        Jian();
    return 0;
}