def solution(given_input):
    i = 0
    j = len(given_input)-1
    while i < j:
        temp = given_input[i]
        given_input[i] = given_input[j]
        given_input[j] = temp
        i += 1
        j -= 1
    return given_input



if __name__ == '__main__':
    given_input = 'abcdefgh'
    ans = solution(given_input)
    print ans