import re
def retrievemostFrequent(literaturetext, wordstoexclude):
    regex = re.compile('[^a-zA-Z]')
    l = regex.sub(' ', literaturetext)
    exclude = set((' '.join(wordstoexclude).lower()).split(" "))
    word_dict = {}
    for i in l.lower().split(' '):
        if i.strip() not in exclude and i.strip():
            if i in word_dict:
                word_dict[i] += 1
            else:
                word_dict[i] = 1
    max_val = max(word_dict.values())
    res = []
    for i, j in word_dict.items():
        if j == max_val:
            res.append(i)
    return res


if __name__ == '__main__':
    literaturetext = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food."
    wordstoexclude = ["and", "he", "the", "to", "is", "Jack", "Jill"]
    print retrievemostFrequent(literaturetext, wordstoexclude)
