def check_list(li):
    op_list = []
    for i in li:
        number_string = ""
        number_string = str(int(i[:6],16))
        total_val = 0

        for k in number_string:
           total_val+=int(k)
        final_val = str(hex(total_val).split('x')[-1])

        if str(int(final_val,16)) == str(int(i[6:8],16)):
            op_list.append("VALID")
        else:
            op_list.append("INVALID")
    print(op_list)
