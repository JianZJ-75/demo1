#include <stdio.h>
#include <stdlib.h>
#define N 100
#define inf 0x3f

int n;       // 顶点数
int m;       // 边数
int f[N][N]; // 邻接矩阵存有向图
int E[N];    // 存每个顶点的偏心度

void Init() // 初始化邻接矩阵以及偏心度
{
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++) // 将每个2个点的初始记录均设为无穷大
            f[i][j] = inf;
        E[i] = 0;    // 将偏心度初始化为0
        f[i][i] = 0; // i到i的距离为0
    }
}

void Create() // 建立有向图
{
    scanf("%d %d", &n, &m);
    Init();
    for (int i = 1; i <= m; i++)
    {
        int x, y, d; // 设A B C D E分别为1 2 3 4 5
        scanf("%d %d %d", &x, &y, &d);
        f[x][y] = d;
    }
}

void Floyd() // Floyd算法
{
    for (int k = 1; k <= n; k++)
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (f[i][k] + f[k][j] < f[i][j])
                    f[i][j] = f[i][k] + f[k][j];
}

void Solve() // 计算偏心度
{
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
            if (f[j][i] > E[i])
                E[i] = f[j][i];
}

void Find() // 寻找医院选址
{
    int index = -1;
    for (int i = 1; i <= n; i++)
        if (E[i] != inf)
            if (index == -1 || E[i] < E[index])
                index = i;
    if (index == -1)
        printf("无法建造符合要求的医院\n");
    else
        printf("医院应建在%c村庄\n", (char)('A' + index - 1));
}

int main()
{
    Create();
    Floyd();
    Solve();
    Find();
    return 0;
}