#include<bits/stdc++.h>
#define N 30 //叶子节点最大值
#define M 2*N-1 //所有结点最大值
//存储字符集的大小n，n个字符，n个权值，即weight,data,n
typedef struct{
    char data;
    int weight;
    int parent;
    int Lchild;
    int Rchild;
    int flag;
}HTNode,HuffmanTree[M+1]; //0号单元不用

//初始化哈夫曼
void InitHuffmanTree(HuffmanTree ht,int n)
{
    printf("提示——（输入示例a b c d e）请输入对应叶子节点的字符：\n");
    for(int i=1;i<=n;i++)   //初始化叶子节点
    {
        ht[i].data='\0';
        ht[i].Lchild=0;
        ht[i].Rchild=0;
        ht[i].weight=0;
        ht[i].parent=0;
        ht[i].flag=0;
        getchar(); //消除空格 读取下一次输入的空格并且消除
        ht[i].data=getchar();
    }
    int i;
    printf("提示——（输入示例12 40 15 8 25）请输入对应叶子节点的权重：\n");
    for(i=1;i<=n;i++) //初始化叶子节点
    {
        scanf("%d",&ht[i].weight);
    }
    int m=2*n-1;//结点总数
    for(i=n+1;i<=m;i++)//初始化非叶子节点
    {
        ht[i].Lchild=0;
        ht[i].Rchild=0;
        ht[i].weight=0;
        ht[i].parent=0;
        ht[i].flag=0; //判断是否被删除
    }
}

//选择最小权值节点下标
int select(HuffmanTree ht,int n)//选择最小权值的结点下标
{
    int i,temp,min;
    for(i=1;i<=n;i++)//设置初始下标和权值
    {
        if(ht[i].flag==0)
        {
            temp=ht[i].weight;//初始权值
            min=i;
            break;
        }
    }
    for(i=1;i<=n;i++)
    {
        if(ht[i].flag==0&&temp>ht[i].weight)
        {
            temp=ht[i].weight;
            min=i;
        }
    }
    ht[min].flag=1;
    return min;
    
}

//构建哈夫曼树
void createHuffmanTree(HuffmanTree ht,int n)
{
    for(int i=n+1;i<=(2*n-1);i++)
    {
        int s1=select(ht,i-1);//这里i-1
        int s2=select(ht,i-1);
        ht[i].weight = ht[s1].weight+ht[s2].weight;
        ht[s1].parent=i;
        ht[s2].parent=i;
        ht[i].Lchild=s1;
        ht[i].Rchild=s2;
        
    }
}
 void file(HuffmanTree ht,int n){//将哈夫曼树存进文件中
FILE *fp; // 文件指针
fp = fopen("hfmTree.txt", "w"); // 打开文件，以写入方式打开
for (int i = 0; i < n; i++) { // 循环写入数据
    fprintf(fp, "%d ", ht[i].weight);
}
     for (int i = 0; i < n; i++) { // 循环写入数据
         fprintf(fp, "%c", ht[i].data);
     }
fclose(fp); // 关闭文件
 }
//获得编码（从下往上反向）
int GetCode(int A[],HuffmanTree ht, int n)
{
    int length=0,i,j,get;
    char s[100]; //定义要输入字符的空间
    printf("（提示——输入示例bbbaddeccbbb）输入要编码的字符：\n");
    getchar();//清除换行符
    gets(s);
    int m=strlen(s);
    for(i=m-1;i>=0;i--)//从后往前处理字符
    {
        for(j=1;j<=n;j++)
        {
            if(s[i]==ht[j].data)
            {
                get = j;  //获取最后一个字符的flag也就是位置
            }
        }
        while(ht[get].parent) 
        {
            if(ht[ht[get].parent].Lchild==get) //判断父节点的左孩子是否等于我们找的get那个位置
            {
                A[length]=0; //左孩子是0
            }
            else{
                A[length]=1; //右孩子是1
            }
            length++;
            get=ht[get].parent;//再把父节点给get 直到父节点为0 就编码成功
        }
    }
    return length-1;  //最后会多+1，所以减去一个1
}
//打印编码
void printCode(int A[], int length)
{    FILE *fp; // 文件指针
    fp = fopen("CodeFile", "w"); // 打开文件，以写入方式打开

    int i;
    for(i=length; i>=0; i--)//从后向前输出即为编码结果
    {    fprintf(fp, "%d ", A[i]);
        printf("%d",A[i]);
    }
        fclose(fp); // 关闭文件
    printf("\n");
}

//解码
int GetreCode(int A[], char B[], HuffmanTree ht, int length1, int n)
{
    int i,length2=0,cur=2*n-1;
    for(i=length1;i>=0;i--)
    {
        if(A[i])//A[i]只可能为1或者0，提示：0是左孩子，1是右孩子
        {
            cur=ht[cur].Rchild;//根结点的右孩子赋值给cur
            if(ht[cur].Rchild==0)//该结点的右孩子如果是0就说明是叶子节点，提示：二叉树只有0和2
            {
                B[length2]=ht[cur].data;
                length2++;
                cur=2*n-1;//回到根节点
            }
        }
        else{
            cur=ht[cur].Lchild;//和上面一样
            if(ht[cur].Lchild==0)
            {
                B[length2]=ht[cur].data;
                length2++;
                cur=2*n-1;
            }
        }
    }
    return length2-1;
}

//解码打印
void printreCode(char B[],int length2)
{
    int i;
    for(i=0;i<=length2;i++)
        printf("%c",B[i]);
    printf("\n");
}

//打印哈夫曼树
void printHuffmanTree(HuffmanTree ht, int n)
{
    printf("结点\tweigt\tdata\tLchild\tRchild\n");
    for(int i=1;i<=n;i++)
    {
        printf("%d\t%d\t%c\t%d\t%d\n",i,ht[i].weight,ht[i].data,ht[i].Lchild,ht[i].Rchild);
    }
}
void filein(HuffmanTree ht,int n){//将哈夫曼树存进文件中
    FILE *fp; // 文件指针
    fp = fopen("Treeprint.txt", "w"); // 打开文件，以写入方式打开
    for (int i = 0; i < n; i++) { // 循环写入数据
        fprintf(fp, "%d ", ht[i].weight);
    }
    for (int i = 0; i < n; i++) { // 循环写入数据
        fprintf(fp, "%c", ht[i].data);
    }
    for (int i = 0; i < n; i++) { // 循环写入数据
        fprintf(fp, "%d", ht[i].Lchild);
    }
    for (int i = 0; i < n; i++) { // 循环写入数据
        fprintf(fp, "%d", ht[i].Rchild);
    }
    fclose(fp); // 关闭文件
}
int main()
{
    HuffmanTree ht; 
    int n; //n为所需的结点数
    int A[100];//存储编码
    char B[100];//存储输出的字符串
    printf("提示——（输入示例 5）请输入叶子节点个数:\n");
    scanf("%d",&n);
    InitHuffmanTree(ht,n); //初始化
    createHuffmanTree(ht,n); //构建哈弗曼树
    
    
    int length = GetCode(A,ht,n);
    printCode(A,length);
    
    int length2 = GetreCode(A,B,ht,length,n);
    printreCode(B,length2);
    filein( ht,n);
    printHuffmanTree(ht,n);
}
