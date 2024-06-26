keyword="ch03"

if [ -n "$1" ]; then
    keyword="$1"
fi

clear

echo "keyword: $keyword"

# 根据关键字，查找源文件列表
src_list=$(find ./src -type f -name "*.java" | grep $keyword | sort)


if [ -n "$src_list" ]; then
    for i in $src_list; do
        target_name=$(echo $i | sed -e 's@^./src/@@' -e 's@.java$@@')
        echo "**$target_name**" # 获取java命令后面指定的部分
        echo "=======================================\n"
        cat $i # 打印程序文本
        echo "\n======================================="
        # 编译程序
        javac -cp ./target/ -d ./target/ $i \
        && echo ">>> 编译完成" \
        &&
        if [[ "$target_name" =~ ^.*Test$ ]]; then
            echo "********************************************\n"
            (cd ./target/ \
            && java -cp mysql-connector-j-8.4.0.jar:. $target_name) # 移动路径并执行程序
            echo "\n********************************************\n"
        else
            echo "############################################\n"
            echo "A file that doesn't end with Test."
            echo "\n############################################\n"
        fi
    done
else
    echo "No java source file found"
fi
