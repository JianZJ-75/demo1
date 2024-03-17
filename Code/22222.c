#include <stdio.h>
#include <stdlib.h>
#include <string.h>

const int N = 1e5 + 10;

typedef struct
{
    int weight;
    int fa;
    int lc, rc;
    char ch;
} huffman;

typedef struct
{
    char bits[29];
    int start;
    char ch; // 编码对应的字符
} Codetype;

huffman tree[2 * 27]; // huffman的构建
Codetype code[28];    // 每一个字符的编码

// 编码
void HuffmanCode()
{
    int n = 27, m = 2 * n - 1;

    char c[] = {' ', ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    for (int i = 1, j, p; i <= n; i++)
    {
        code[i].ch = c[i];
        code[i].start = n;
        j = i;
        p = tree[i].fa;

        // 从叶子节点往回找
        while (p != 0)
        {
            if (tree[p].lc == j)
                code[i].bits[code[i].start--] = '0';
            else
                code[i].bits[code[i].start--] = '1';
            j = p;
            p = tree[p].fa;
        }
    }
}

void decode(char ccc[])
{
    if (ccc == "N")
        return;
    int n = 27, m = 2 * n - 1;
    int len = strlen(ccc);

    huffman st, idx;

    // 找根节点
    for (int i = 1; i <= m; i++)
    {
        if (tree[i].fa == 0)
        {
            st = tree[i];
            idx = tree[i];
            break;
        }
    }

    // 找到叶子节点
    for (int i = 0; i < len; i++)
    {
        if (ccc[i] == '0')
            st = tree[st.lc];
        else
            st = tree[st.rc];

        // 叶子节点
        if (st.lc == st.rc && st.lc == 0)
        {
            printf("%c", st.ch);
            st = idx;
        }
    }
    printf("\n");
}

// 建树
void creat()
{
    int n = 27;
    int m = 2 * n - 1;

    for (int i = 1; i <= m; i++)
        tree[i].fa = tree[i].lc = tree[i].rc = tree[i].weight = 0;

    char c[] = {' ', ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    int va[] = {-1, 184, 1, 2, 4, 77, 53, 66, 44, 32,
                22, 47, 88, 99, 100, 107, 34, 55, 58,
                49, 54, 23, 17, 71, 85, 57, 119, 74};

    for (int i = 1; i <= n; i++)
    {
        tree[i].weight = va[i];
        tree[i].ch = c[i];
        tree[i].fa = tree[i].lc = tree[i].rc = 0;
    }

    int p1, p2, small1, small2, f;

    for (int i = n + 1; i <= m; i++)
    {
        p1 = p2 = 0;
        small1 = small2 = 0x3f3f3f3f;

        for (int j = 1; j <= i - 1; j++)
        {
            if (tree[j].fa == 0)
                if (tree[j].weight < small1) // 查找最小值，p1
                {
                    small2 = small1;
                    small1 = tree[j].weight;
                    p2 = p1;
                    p1 = j;
                }
            建树
            else if (tree[j].weight < small2) // 查找次小值，p2
            {
                small2 = tree[j].weight;
                p2 = j;
            }
        }
        tree[p1].fa = tree[p2].fa = i;
        tree[i].weight = tree[p1].weight + tree[p2].weight;
        tree[i].lc = p1;
        tree[i].rc = p2;
    }
}

int main()
{
    // 建树
    creat();
    // 编码
    HuffmanCode();

    for (int i = 1; i <= 27; i++)
    {
        printf("%c  ", code[i].ch);
        for (int j = code[i].start + 1; j <= 27; j++)
            printf("%c", code[i].bits[j]);
        printf("\n");
    }

    char a[N];
    gets(a);

    char b[N];
    gets(b);

    int len = strlen(a);

    for (int i = 0; i < len; i++)
    {
        if (a[0] == 'N' && len == 1)
            break;
        if (a[i] == ' ')
            for (int j = code[1].start + 1; j <= 27; j++)
                printf("%c", code[1].bits[j]);
        else
            for (int j = code[a[i] - 'A' + 2].start + 1; j <= 27; j++)
                printf("%c", code[a[i] - 'A' + 2].bits[j]);

        if (i == len - 1)
            printf("\n");
    }
    decode(b);
}