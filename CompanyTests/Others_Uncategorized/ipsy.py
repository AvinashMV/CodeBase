from collections import Counter


if __name__ == '__main__':
    input = ["Joe", "Mary", "Joe", "Mary"]
    vote_ballet = Counter(input)
    highest = max(vote_ballet.values())

    highest_list = [k for k, v in vote_ballet.items() if v == highest]
    if len(highest_list)>1:
        print max(highest_list)
    else:
        print highest_list[0]