from collections import Counter

def can_you_sort(given):
    counter = Counter(given)
    print sorted(given, key=lambda x: (counter[x], x))

if __name__ == '__main__':
    given = [4, 5, 6, 5, 4, 3]
    can_you_sort(given)