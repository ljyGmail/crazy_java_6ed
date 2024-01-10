#!/bin/bash
keyword=ch03

if [ -n "$1" ]; then
    keyword="$1"
fi

vim $(find . -type f -name "*.java" | grep -i $keyword | sort)
