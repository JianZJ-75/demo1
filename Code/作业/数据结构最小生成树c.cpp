#include <stdio.h>
#define N 1000

typedef struct
{
    int y; // 边所到达顶点
    int t; // 修建成本
} Node;

Node edge[N][N];
int q[N]; // 每个点所拥有边的个数
int n; // 点的个数
int m; // 边的个数
int dist[N]; // dist记录每个点到顶点集的最短路
int b[N]; // 是否加入顶点集

void Init()
{
    for (int i = 0; i <= n; i++)
        b[i] = 0,
        dist[i] = 1000000;
}

int Prim(int head)
{
    Init();
    dist[head] = 0;
    int ans = 0; // 记录总成本
    for (;;)
    {
        int index = -1;
        for (int i = 1; i <= n; i++) // 遍历所有点寻找未加入顶点集的最小dist点
            if (b[i] == 0 && dist[i] < 1000000) 
                if (index == -1 || dist[i] < dist[index])
                    index = i;
        if (index == -1)
            break;
        ans += dist[index];
        b[index] = 1;
        for (int i = 1; i <= q[index]; i++) // 更新该节点所连顶点的dist
        {
            int d = edge[index][i].y;
            int t = edge[index][i].t;
            if (t < dist[d])
                dist[d] = t;
        }
    }
    return ans;
}

void Creat()//建图
{
    scanf("%d", &n);
    m = n * (n - 1) / 2;
    for (int i = 1; i <= m; i++)
    {
        int x, y, z, d;
        scanf("%d %d %d %d", &x, &y, &z, &d);
        Node a;
        if (d == 1) // 如果已修建,就把成本设为0
            z = 0;
        a.t = z;
        a.y = y;
        edge[x][++q[x]] = a;
        a.y = x;
        edge[y][++q[y]] = a;
    }
}

int main()
{
    Creat();
    printf("全省畅通需要的最低成本=%d", Prim(1));
    return 0;
}