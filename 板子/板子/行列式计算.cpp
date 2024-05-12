#include<bits/stdc++.h>

#define IOS ios::sync_with_stdio(false) , cin.tie(0)
#define ll long long
using namespace std;
const int N = 205;
ll g[N][N];

ll Rainbow(int n, int mod) {
    ll ans = 1;
    for(int i = 1; i <= n; i++)
        for(int j = 1; j <= n; j++)
            g[i][j] %= mod;
    for(int i = 1; i <= n; i++) {
        for(int j = i + 1; j <= n; j++) {
            int x = i, y = j;
            while(g[x][i]) {
                int t = g[y][i] / g[x][i];
                for(int k = i; k <= n; k++)
                    g[y][k] = (g[y][k] - t * g[x][k]) % mod;
                swap(x, y);
            }
            if(x == i) {
                for(int k = i; k <= n; k++)
                    swap(g[j][k], g[i][k]);
                ans = -ans;
            }
        }
        if(g[i][i] == 0)
            return 0;
        ans = ans * g[i][i] % mod;
    }
    if(ans < 0) ans += mod;
    return ans;
    //½üËÆÓÚn^3 
}

int main() {
    int n, m, mod;
    cin >> n >> m >> mod;
    for(int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        g[u][v]--, g[v][u]--;
        g[u][u]++, g[v][v]++;
    }
    cout << Rainbow(n - 1, mod) << "\n";
    return 0;
}
