import glob, os, re


def find_files_in_dir():
    os.chdir("../Antlr_demo")
    print(os.getcwd())
    listfiles = []
    for file in glob.glob("*.txt"):
        print("file: " + file)
        if "_MD" in file:
            listfiles.append(file)
    return listfiles


def get_list_update_times_from_files(list_file):
    list_updates = []
    for file in list_file:
        f = open(file, 'r')
        for x in f:
            if "update: " in x:
                d = re.findall('\\d+', x)
                if len(d) < 1:
                    continue
                list_updates.append(float(d[0]))
    print(list_updates)


def form_list_for_updates():
    pass


the_list = find_files_in_dir()
get_list_update_times_from_files(the_list)
