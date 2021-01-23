(ns advent-of-code.core
  (:require [advent-of-code.day01]
            [advent-of-code.day02]
            [advent-of-code.day04]
            [advent-of-code.day05]
            [advent-of-code.day06]
            [advent-of-code.day07]
            [advent-of-code.day13]
            [advent-of-code.day14]
            [advent-of-code.day15]
            [advent-of-code.day16]
            [advent-of-code.day18]
            [advent-of-code.day22]
            [advent-of-code.day25])
  (:gen-class))

(defn- pad-int-string
  "Pad string x if just one digit, e.g., 1 -> 01.
   Always return string."
  [x]
  (if (<= (count x) 1)
    (str 0 x)
    x))

(defn gen-func
  [day part]
  (str "advent-of-code.day" day "/part" part))

(defn gen-input
  [day]
  (str "inputs/day" day ".txt"))

(defn run-day-part
  "Run advent of code day `day` part `part` (1 or 2)."
  [day part]
  (let [day (pad-int-string day)
        f (resolve (symbol (gen-func day part)))
        input (gen-input day)]
    (if (nil? f)
      (str "Code for day " day " part " part " not found.")
      (f input))))

(defn -main
  "Advent of code solutions."
  [day part]
  (println (str "Day " day ", part " part ":"))
  (println (run-day-part day part)))
  