import copy


def final_discounted(prices):
    stack = []
    discounted_price = copy.deepcopy(prices)
    changed_indices = []
    for i in range(len(prices)-1, -1, -1):
        if stack:
            while stack and stack[-1] > prices[i]:
                stack.pop()
            if stack:
                discounted_price[i] -= stack[-1]
            else:
                changed_indices.append(i)
        else:
            changed_indices.append(i)
        stack.append(prices[i])
    return changed_indices, sum(discounted_price)


if __name__ == '__main__':
    prices = [1, 3, 3, 2, 5]
    changed_indices, sum_val = final_discounted(prices)
    print changed_indices, sum_val