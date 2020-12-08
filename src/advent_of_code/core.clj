(ns advent-of-code.core
  (:require [advent-of-code.day01]))

(def input-day1 "inputs/day1.txt")

(defn -main
  "Advent of code solutions."
  [& args]
  (println (advent-of-code.day01/part1 (slurp input-day1))))
