chapter=ch03

if [ -n "$1" ]; then
    chapter="$1"
fi

echo $chapter

clear \
&& javac $(find . -type f -name "*.java" | grep $chapter) -d ../target \
&& cd ../target \
&& find . -type f -name "*Test.class" | grep $chapter | sort -n | sed -e 's@^./@@' -e 's@/@.@g' -e 's@.class$@@' -e 's@^@java @' | awk '{ print "echo ======= ...", substr($2, 24), "=======;" $0, "; echo" }' | bash
#&& find . -type f -name "*.class" | grep $chapter | sort -n | sed -e 's@^./@@' -e 's@/@.@g' -e 's@.class$@@' -e 's@^@java @' | awk '{ print "echo ======= ...", substr($2, 44), "=======;" $0, "; echo" }' | bash 2> error
