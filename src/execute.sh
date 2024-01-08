clear &&
javac $(find . -type f -name "*.java") -d ../target &&
cd ../target && find . -type f -name "*.class" | sort -n | sed -e 's@^./@@' -e 's@/@.@g' -e 's@.class$@@' -e 's@^@java @' | awk '{ print "echo ======= ...", substr($2, 44), "=======;" $0, "; echo" }' | bash 2> error
