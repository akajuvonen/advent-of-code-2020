(ns advent-of-code.core
  (:require [advent-of-code.day01]))

(def input-day1 "inputs/day1.txt")

(defn -main
  "Advent of code solutions."
  [& args]
  (println "Day 1")
  (println "Part 1")
  (println (advent-of-code.day01/part1 (slurp input-day1)))
  (println "Part 2")
  (println (advent-of-code.day01/part2 (slurp input-day1))))
