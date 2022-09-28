t = int(input())

for case in range(t):
    n = input()
    result = []
    for i in range(len(n)-1, -1, -1):
        result.append(n[i])
    if "".join(result) == n:
        print("#{0}".format(case + 1), 1)
    else:
        print("#{0}".format(case + 1), 0)
