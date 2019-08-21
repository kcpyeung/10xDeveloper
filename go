#!/usr/bin/env bash

hash gprolog 2>/dev/null
if [ $? -ne 0 ]; then
  echo "Please install GNU Prolog before continuing"
  exit 2
fi

hash gradle 2>/dev/null
if [ $? -ne 0 ]; then
  echo "Please install Gradle before continuing"
  exit 3
fi

gradle run

chmod 700 run_prolog
./run_prolog
