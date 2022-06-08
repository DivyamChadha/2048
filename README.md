# 2048

2048 game made in Java.

### Executing program

Simple shell file to compile and run the game.

```sh
#!/bin/bash

# Determine the build directory
if [ $# -eq 0 ]
  then
    build_dir="build/latest/"
else
    build_dir="build/$1/"
fi

# Compile all the files in src dir to the build dir
files=$(find src -type f -name "*.java")
mkdir -p $build_dir
javac $files -d $build_dir

# Run the app
cd $build_dir
java App
```

