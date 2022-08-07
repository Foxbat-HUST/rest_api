#! /bin/bash
SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
env=$SCRIPT_DIR/$1
if [ ! -d $env ]
then
    echo "no data found in $env/"
    exit 1
fi
sqlFile="$SCRIPT_DIR/$(($(date +%s%N)/1000000)).sql"
touch $sqlFile
for file in $env/*.csv; do
    columns="($(head -n 1 $file))"
    insert=$(echo $(basename -- $file) | awk -v columns=$columns -F"[_|.]" '{print "INSERT INTO "$2 columns""}')
    tail --lines=+2 $file | while read line
    do
        echo "$insert VALUES($line);" >> $sqlFile
    done
done

echo $sqlFile
