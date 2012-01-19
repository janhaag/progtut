from sys import exit
from subprocess import Popen as popen, STDOUT, PIPE
from re import match

############################### ADJUST AS NEEDED ##############################

no_of_tests = 1
classes_base_directory = "../target/classes"

############################### START OF PROGRAM ##############################

failures = 0

for i in range(1, no_of_tests):
    with open("Praktomat{}.test".format(i), "r") as f:
        data = ""
        checks = []
        for line in f:
            if line[0] == ">":
                data += line[1:]
            elif line[0] == "<":
                checks.append(line[1:].strip())
            else:
                print("ERROR: Malformed test file.")
                exit(2)

        shell = popen(["java", "Shell"],
                      stderr = STDOUT,
                      stdin = PIPE,
                      stdout = PIPE,
                      universal_newlines = True,
                      cwd = classes_base_directory)

        result = shell.communicate(data.encode("utf-8"))[0].splitlines()
        if match("(> )+", result[-1]) != None:
            del result[-1]

        iter_len = len(checks) if len(checks) < len(result) else len(result)

        if not len(checks) == len(result):
            print("FAIL: Did not get the expected output length in test {}. \n"
                  "WARNING: False test results may occur.".format(i))
            failures += 1

        for i in range(iter_len):
            if match(checks[i], result[i]) is None:
                print("FAIL: Expected:")
                print(checks[i])
                print("Got:")
                print(result[i])
                failures += 1

print("There were {} failures.".format(failures))
exit(0 if failures == 0 else 1)
