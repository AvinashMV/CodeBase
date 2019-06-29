def solution(given_string):
    given_string = given_string.replace('.', '')
    sent_list = given_string.split(" ")
    lower_sent_list = []
    for i in sent_list:
        lower_sent_list.append(i.lower())
    word_dict = {}
    for i in lower_sent_list:
        sorted_word = ''.join(sorted(i))
        if sorted_word in word_dict:
            word_dict[sorted_word].append(i)
        else:
            word_dict[sorted_word] = [i]
    ret_list = []
    for i in word_dict.values():
        if len(i) > 1:
            ret_list.append(i)
    return ret_list


if __name__ == '__main__':
    given_string = "Joe races to spin tops on top of pots. No one cares but his dog nips his hand."
    ans = solution(given_string)
    print ans