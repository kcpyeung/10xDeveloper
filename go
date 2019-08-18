#!/usr/bin/env bash

hash gprolog 2>/dev/null
if [ $? -ne 0 ]; then
  echo "Please install GNU Prolog before continuing"
  exit 2
fi

gprolog --consult-file 10x_dev.pl --query-goal 'devs([Jessie, Evan, John, Sarah, Matt])'
