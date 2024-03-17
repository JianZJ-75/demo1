x = int(input())
n = int(input())
ans = 1
mod = 1e9 + 7
while n > 0:
    ans = ans * x + 1
    ans %= mod
    n -= 1
print(ans)