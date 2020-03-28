# Read from the file file.txt and output the tenth line to stdout.
#!/bin/bash
num=0
cat file.txt | while read line
do
    let "num=$num+1"
    if [ $num -eq 10 ]
    then
        echo $line
    fi
done