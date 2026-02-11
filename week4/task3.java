import os

def compareTriplets(a, b):
    score_a = 0
    score_b = 0
    for val_a, val_b in zip(a, b):
        if val_a > val_b:
            score_a += 1
        elif val_a < val_b:
            score_b += 1
    return [score_a, score_b]

if __name__ == '__main__':
    fun = open(os.environ['OUTPUT_PATH'], 'w')

    a = list(map(int, input().rstrip().split()))
    b = list(map(int, input().rstrip().split()))

    result = compareTriplets(a, b)

    fun.write(' '.join(map(str, result)))
    fun.write('\n')

    fun.close()
